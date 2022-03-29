package com.example.hwalasdk;


import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyInputMethodService extends InputMethodService implements KeyboardView.OnKeyboardActionListener {
    private static String TAG_ANDROID_CONTACTS="1";
    KeyboardView   kv;
    EditText text;
    Button btsend;
    ImageView imback;
    @Override
    public View onCreateInputView() {
        View  root = getLayoutInflater().inflate(R.layout.strat_screen, null);
        try {
            initFristScreen();


//        ImageView ivKeyboard = (ImageView) root.findViewById(R.id.ivKeyboard);
            // get the KeyboardView and add our Keyboard layout to it
//        KeyboardView keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
//        Keyboard keyboard = new Keyboard(this, R.xml.number_pad);
//        keyboardView.setKeyboard(keyboard);
//        keyboardView.setOnKeyboardActionListener(this);
//        return keyboardView;
//            vf = (ViewFlipper) root.findViewById(R.id.viewFlipper);
//        ivKeyboard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //whatever you want to do...
//                Toast.makeText(MyInputMethodService.this,"welcome to HWALA",Toast.LENGTH_LONG).show();
//            }
//        });
//        text= (EditText) root.findViewById(R.id.ed_text);
//        text.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
////                kv.setVisibility(View.VISIBLE);
//            }
//        });
//        kv = (KeyboardView) root.findViewById(R.id.keyboard_view);
//        kv.setVisibility(View.GONE);
//        Keyboard   keyboard = new Keyboard(this, R.xml.number_pad);
//        kv.setKeyboard(keyboard);
//        kv.setOnKeyboardActionListener(this);
        }catch (Exception e){
        }
        return root;
    }

    public void initFristScreen(){
        View  root = getLayoutInflater().inflate(R.layout.strat_screen, null);
        getWindow().setContentView(root);
        btsend = root.findViewById(R.id.bt_transfer_money);
        btsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    initSecondScreen();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
    public void initSecondScreen(){
        View view2 = getLayoutInflater().inflate(R.layout.contact_list_screen, null);
        getWindow().setContentView(view2);
//        RecyclerView ContactRecyclerView = (RecyclerView) view2.findViewById(R.id.recyclview_contacts);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
//        ContactRecyclerView.setHasFixedSize(true);
//
//        // use a linear layout manager
//        LinearLayoutManager  mLayoutManager = new LinearLayoutManager(this);
//        ContactRecyclerView.setLayoutManager(mLayoutManager);

        imback = view2.findViewById(R.id.im_back);
        imback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    initFristScreen();
                } catch (Exception e) {
                }
            }
        });
       ImageView img_contact = view2.findViewById(R.id.img_contact);
        img_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    initContactScreen();
                } catch (Exception e) {
                }
            }
        });

        Button loadButton = (Button)view2.findViewById(R.id.bt_transfer_money);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        text= (EditText) view2.findViewById(R.id.ed_contact_number);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kv.setVisibility(View.VISIBLE);
            }
        });
        kv = (KeyboardView) view2.findViewById(R.id.keyboard_view);
        kv.setVisibility(View.GONE);
        Keyboard   keyboard = new Keyboard(this, R.xml.number_pad);
        kv.setKeyboard(keyboard);
        kv.setOnKeyboardActionListener(this);
    }
    public void initContactScreen(){
        View view2 = getLayoutInflater().inflate(R.layout.second_screen, null);
        getWindow().setContentView(view2);
        RecyclerView ContactRecyclerView = (RecyclerView) view2.findViewById(R.id.recyclview_contacts);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        ContactRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager  mLayoutManager = new LinearLayoutManager(this);
        ContactRecyclerView.setLayoutManager(mLayoutManager);

        imback = view2.findViewById(R.id.im_back);
        imback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    initSecondScreen();
                } catch (Exception e) {
                }
            }
        });
        ImageView img_contact = view2.findViewById(R.id.img_contact);
        img_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ContactAdapter contactAdapter = new ContactAdapter(getAllContactList());
                    ContactRecyclerView.setAdapter(contactAdapter);
//                    if(!hasPhoneContactsPermission(Manifest.permission.READ_CONTACTS))
//                    {
//                        requestPermission(Manifest.permission.READ_CONTACTS);
//                    }else {
//
//                        // specify an adapter (see also next example)
//
////                    Toast.makeText(getApplicationContext(), "Contact data has been printed in the android monitor log..", Toast.LENGTH_SHORT).show();
//                    }
                } catch (Exception e) {
                }
            }
        });

        Button loadButton = (Button)view2.findViewById(R.id.bt_porced);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    public  ArrayList<ContactDTO> getAllContactList(){
        ArrayList<ContactDTO> re=new ArrayList<>();
        Uri uri=ContactsContract.Contacts.CONTENT_URI;
        String sort=ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME+" ASC ";
        Cursor cursor=getContentResolver().query(uri,null,null,null,sort);

        if(cursor.getCount()>0){
            while(cursor.moveToNext()){
                String id=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                String name=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                Uri uriPhone=ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
                String selection=ContactsContract.CommonDataKinds.Phone.CONTACT_ID+" =?";
                Cursor phoneCursor=getContentResolver().query(uriPhone,null,
                        selection,new String[]{id},null);
                if(phoneCursor.moveToNext()){
                    String number=phoneCursor.getString(phoneCursor.getColumnIndex(
                            ContactsContract.CommonDataKinds.Phone.NUMBER
                    ));
                    ContactDTO contactDTO=new ContactDTO();
                    contactDTO.setDisplayName(name);
                    contactDTO.setFamilyName(number);
                    re.add(contactDTO);
                    phoneCursor.close();
                }
            }
            cursor.close();
        }
        return re;
    }
    public  ArrayList<ContactDTO> getAllContacts()
    {
        ArrayList<ContactDTO> ret = new ArrayList<ContactDTO>();
        // Get all raw contacts id list.
        List<Integer> rawContactsIdList = (new Contact()).getRawContactsIdList( getApplicationContext());
        int contactListSize = rawContactsIdList.size();
        ContentResolver contentResolver =  getApplicationContext().getContentResolver();
        // Loop in the raw contacts list.
        for(int i=0;i<contactListSize;i++)
        {
            // Get the raw contact id.
            Integer rawContactId = rawContactsIdList.get(i);
            Log.d(TAG_ANDROID_CONTACTS, "raw contact id : " + rawContactId.intValue());
            // Data content uri (access data table. )
            Uri dataContentUri = ContactsContract.Data.CONTENT_URI;
            // Build query columns name array.
            List<String> queryColumnList = new ArrayList<String>();
            // ContactsContract.Data.CONTACT_ID = "contact_id";
            queryColumnList.add(ContactsContract.Data.CONTACT_ID);
            // ContactsContract.Data.MIMETYPE = "mimetype";
            queryColumnList.add(ContactsContract.Data.MIMETYPE);
            queryColumnList.add(ContactsContract.Data.DATA1);
            queryColumnList.add(ContactsContract.Data.DATA2);
            queryColumnList.add(ContactsContract.Data.DATA3);
            queryColumnList.add(ContactsContract.Data.DATA4);
            queryColumnList.add(ContactsContract.Data.DATA5);
            queryColumnList.add(ContactsContract.Data.DATA6);
            queryColumnList.add(ContactsContract.Data.DATA7);
            queryColumnList.add(ContactsContract.Data.DATA8);
            queryColumnList.add(ContactsContract.Data.DATA9);
            queryColumnList.add(ContactsContract.Data.DATA10);
            queryColumnList.add(ContactsContract.Data.DATA11);
            queryColumnList.add(ContactsContract.Data.DATA12);
            queryColumnList.add(ContactsContract.Data.DATA13);
            queryColumnList.add(ContactsContract.Data.DATA14);
            queryColumnList.add(ContactsContract.Data.DATA15);
            // Translate column name list to array.
            String queryColumnArr[] = queryColumnList.toArray(new String[queryColumnList.size()]);
            // Build query condition string. Query rows by contact id.
            StringBuffer whereClauseBuf = new StringBuffer();
            whereClauseBuf.append(ContactsContract.Data.RAW_CONTACT_ID);
            whereClauseBuf.append("=");
            whereClauseBuf.append(rawContactId);
            // Query data table and return related contact data.
            Cursor cursor = contentResolver.query(dataContentUri, queryColumnArr, whereClauseBuf.toString(), null, null);
            /* If this cursor return database table row data.
               If do not check cursor.getCount() then it will throw error
               android.database.CursorIndexOutOfBoundsException: Index 0 requested, with a size of 0.
               */
            if(cursor!=null && cursor.getCount() > 0)
            {
                StringBuffer lineBuf = new StringBuffer();
                cursor.moveToFirst();
                lineBuf.append("Raw Contact Id : ");
                lineBuf.append(rawContactId);
                long contactId = cursor.getLong(cursor.getColumnIndex(ContactsContract.Data.CONTACT_ID));
                lineBuf.append(" , Contact Id : ");
                lineBuf.append(contactId);
                do{
                    try {


                        // First get mimetype column value.
                        String mimeType = cursor.getString(cursor.getColumnIndex(ContactsContract.Data.MIMETYPE));
                        lineBuf.append(" \r\n , MimeType : ");
                        lineBuf.append(mimeType);
                        List<String> dataValueList = (new Contact()).getColumnValueByMimetype(cursor, mimeType,getApplicationContext());
                        int dataValueListSize = dataValueList.size();
                        for(int j=0;j < dataValueListSize;j++)
                        {
                            String dataValue = dataValueList.get(j);
                            lineBuf.append(" , ");
                            lineBuf.append(dataValue);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }while(cursor.moveToNext());
                Log.d(TAG_ANDROID_CONTACTS, lineBuf.toString());
            }
            Log.d(TAG_ANDROID_CONTACTS, "=========================================================================");
        }
        return ret;
    }
    private void sendAction(){
        Intent i=new Intent();
        i.setAction("launch.me.action.LAUNCH_IT");
        i.putExtra(Global.keyvalue,text.getText().toString());
        text.setText("");
        getApplicationContext().startActivity(i);
    }


    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection ic = getCurrentInputConnection();
        if (ic == null) return;
        switch (primaryCode) {
            case Keyboard.KEYCODE_DELETE:
                CharSequence selectedText = ic.getSelectedText(0);
                if (TextUtils.isEmpty(selectedText)) {
                    // no selection, so delete previous character
                    ic.deleteSurroundingText(1, 0);
                } else {
                    // delete the selection
                    ic.commitText("", 1);
                }
                break;
            case Keyboard.KEYCODE_DONE:
                kv.setVisibility(View.GONE);
                break;
            default:
                char code = (char) primaryCode;
//                ic.commitText(String.valueOf(code), 1);
                setText(String.valueOf(code));
        }
    }

    public void setText(String x){
        text.setText(text.getText().toString()+x);
    }
    @Override
    public void onPress(int primaryCode) {
        Toast.makeText(getApplicationContext(), "onPress", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRelease(int primaryCode) {
        Toast.makeText(getApplicationContext(), "onRelease", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onText(CharSequence text) {
        Toast.makeText(getApplicationContext(), "onText", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void swipeLeft() {
        Toast.makeText(getApplicationContext(), "swipeLeft", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void swipeRight() {
        Toast.makeText(getApplicationContext(), "swipeRight", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void swipeDown() {
        Toast.makeText(getApplicationContext(), "swipeDown", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void swipeUp() {
        Toast.makeText(getApplicationContext(), "swipeUp", Toast.LENGTH_SHORT).show();
    }
}