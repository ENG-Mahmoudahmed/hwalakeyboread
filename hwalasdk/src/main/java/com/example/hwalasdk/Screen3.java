package com.example.hwalasdk;

import static android.inputmethodservice.Keyboard.KEYCODE_DELETE;

import android.database.Cursor;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.net.URL;
import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;

public class Screen3  implements ContactAdapter.ItemListener , KeyboardView.OnKeyboardActionListener{
    private static String TAG_ANDROID_CONTACTS="1";
    RecyclerView ContactRecyclerView;
    InputMethodService inputMethodService;
    ImageView imback;
    ArrayList<ContactDTO> ContactDTOresult=new ArrayList<>();
    HwalaKeyboardChar kv;
    GifImageView loadingPanel;
    public void InitScreen3(InputMethodService inputMethodService ,String oldnumber){
        this.inputMethodService=inputMethodService;
        new Screen3.DownloadFilesTask().execute(null, null,null);
        View view2 = inputMethodService.getLayoutInflater().inflate(R.layout.screen_3, null);
        inputMethodService.getWindow().setContentView(view2);
         loadingPanel=view2.findViewById(R.id.loadingPanel);
        ContactRecyclerView = (RecyclerView) view2.findViewById(R.id.recyclview_contacts);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        ContactRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(inputMethodService);
        ContactRecyclerView.setLayoutManager(mLayoutManager);
        imback = view2.findViewById(R.id.im_back);
        imback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    (new Screen2()).InitScreen2(inputMethodService,"");
                } catch (Exception e) {
                    Toast.makeText(inputMethodService.getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        EditText screen3_searchview=view2.findViewById(R.id.screen3_searchview);
        screen3_searchview.requestFocus();
        screen3_searchview.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               String text = charSequence.toString();

//                if (editTextChangedFromClick) {
//                    editTextChangedFromClick = false;
//                    if (recyclerView.getVisibility() == View.VISIBLE)
//                        recyclerView.setVisibility(View.GONE);
//
//                } else {
//
//                    if (recyclerView.getVisibility() != View.VISIBLE)
//                        recyclerView.setVisibility(View.VISIBLE);

                    if (charSequence.toString().length() > 0) {
                        performFiltering(ContactDTOresult,text);
                    } else {
                        addContactToRecyclerView(ContactDTOresult);

                    }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        screen3_searchview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kv.setVisibility(View.VISIBLE);
            }
        });
        screen3_searchview.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic = screen3_searchview.onCreateInputConnection(new EditorInfo());
                    kv.setInputConnection(ic); // custom keyboard method
                }
            }
        });
        kv = (HwalaKeyboardChar) view2.findViewById(R.id.keyboard_view);
        kv.setVisibility(View.GONE);
        android.inputmethodservice.Keyboard keyboard = new Keyboard(inputMethodService, R.xml.char_pad);
        InputConnection ic = screen3_searchview.onCreateInputConnection(new EditorInfo());
        kv.setInputConnection(ic); // custom keyboard method
        BackView.InitBackView(inputMethodService,view2,null,"My contacts ",kv);
//        KeyboardView keyboardView = (KeyboardView) inputMethodService.getLayoutInflater().inflate(R.layout.keyboard_view, null);
//        Keyboard keyboard = new Keyboard(inputMethodService, R.xml.char_pad);
//        keyboardView.setKeyboard(keyboard);
//        keyboardView.setOnKeyboardActionListener(this);

    }

    @Override
    public void onItemClick(ContactDTO item) {
        try {
            (new Screen4()).InitScreen4(inputMethodService,item.getDisplayName() ,item.getNumber(),"0.0",ScreenName.Screen_3);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(inputMethodService.getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onPress(int i) {

    }

    @Override
    public void onRelease(int i) {

    }

    @Override
    public void onKey(int i, int[] ints) {
        InputConnection ic = inputMethodService.getCurrentInputConnection();
        if (ic == null) return;
        switch (i) {
            case KEYCODE_DELETE:
                CharSequence selectedText = ic.getSelectedText(0);
                if (TextUtils.isEmpty(selectedText)) {
                    // no selection, so delete previous character
                    ic.deleteSurroundingText(1, 0);
                } else {
                    // delete the selection
                    ic.commitText("", 1);
                }
                break;
            default:
                char code = (char) i;
                ic.commitText(String.valueOf(code), 1);
        }
    }

    @Override
    public void onText(CharSequence charSequence) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }

    public class DownloadFilesTask extends AsyncTask<URL, Integer, ArrayList<ContactDTO>> {
        protected ArrayList<ContactDTO> doInBackground(URL... urls) {
            return getAllContactList();
        }

        protected void onProgressUpdate(Integer... progress) {
//            Toast.makeText(getApplicationContext(), "loading", Toast.LENGTH_SHORT).show();

        }

        protected void onPostExecute(ArrayList<ContactDTO> result) {
            loadingPanel.setVisibility(View.GONE);
            ContactDTOresult=result;
            addContactToRecyclerView(result);

//            Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_SHORT).show();
        }
    }
    public ArrayList<ContactDTO> performFiltering(ArrayList<ContactDTO> ContactDTOlist,String text) {
        ArrayList<ContactDTO> filteredContactDTOlist=new ArrayList<>();
        filteredContactDTOlist.clear();
        for (ContactDTO model : ContactDTOlist) {
            if (model.getDisplayName().toLowerCase().contains(text.toLowerCase())||model.getNumber().toLowerCase().contains(text.toLowerCase())) {
                filteredContactDTOlist.add(model);
            }
        }
        addContactToRecyclerView(filteredContactDTOlist);
        return filteredContactDTOlist;
    }

    public void addContactToRecyclerView(ArrayList<ContactDTO> ContactDTOlist) {
        ContactAdapter contactAdapter = new ContactAdapter(ContactDTOlist,this);
        contactAdapter.notifyDataSetChanged();
        ContactRecyclerView.setAdapter(contactAdapter);
    }

    public  ArrayList<ContactDTO> getAllContactList(){
        ArrayList<ContactDTO> re=new ArrayList<>();
        Uri uri= ContactsContract.Contacts.CONTENT_URI;
        String sort=ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME+" ASC ";
        Cursor cursor=inputMethodService.getContentResolver().query(uri,null,null,null,sort);

        if(cursor.getCount()>0){
            while(cursor.moveToNext()){
                String id=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                String name=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                Uri uriPhone=ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
                String selection=ContactsContract.CommonDataKinds.Phone.CONTACT_ID+" =?";
                Cursor phoneCursor=inputMethodService.getContentResolver().query(uriPhone,null,
                        selection,new String[]{id},null);
                if(phoneCursor.moveToNext()){
                    String number=phoneCursor.getString(phoneCursor.getColumnIndex(
                            ContactsContract.CommonDataKinds.Phone.NUMBER
                    ));
                    ContactDTO contactDTO=new ContactDTO();
                    contactDTO.setDisplayName(name);
                    contactDTO.setNumber(number);
                    re.add(contactDTO);
                    phoneCursor.close();
                }
            }
            cursor.close();
        }
        return re;
    }
}
