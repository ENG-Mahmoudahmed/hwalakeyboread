package com.example.hwalasdk;

import android.database.Cursor;
import android.inputmethodservice.InputMethodService;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.net.URL;
import java.util.ArrayList;

public class Screen3 {
    private static String TAG_ANDROID_CONTACTS="1";
    RecyclerView ContactRecyclerView;
    InputMethodService inputMethodService;
    ImageView imback;
    public void InitScreen3(InputMethodService inputMethodService){
        this.inputMethodService=inputMethodService;
        new Screen3.DownloadFilesTask().execute(null, null,null);
        View view2 = inputMethodService.getLayoutInflater().inflate(R.layout.screen_3, null);
        inputMethodService.getWindow().setContentView(view2);
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
                    (new Screen2()).InitScreen2(inputMethodService);
                } catch (Exception e) {
                }
            }
        });

    }

    private class DownloadFilesTask extends AsyncTask<URL, Integer, ArrayList<ContactDTO>> {
        protected ArrayList<ContactDTO> doInBackground(URL... urls) {
            return getAllContactList();
        }

        protected void onProgressUpdate(Integer... progress) {
//            Toast.makeText(getApplicationContext(), "loading", Toast.LENGTH_SHORT).show();

        }

        protected void onPostExecute(ArrayList<ContactDTO> result) {
            ContactAdapter contactAdapter = new ContactAdapter(result);
            ContactRecyclerView.setAdapter(contactAdapter);
//            Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_SHORT).show();
        }
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
                    contactDTO.setFamilyName(number);
                    re.add(contactDTO);
                    phoneCursor.close();
                }
            }
            cursor.close();
        }
        return re;
    }
}
