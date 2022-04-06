package com.example.hwalasdk;

public class test {

    //    private FirebaseAnalytics mFirebaseAnalytics;
    //        KeyboardView keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
//        Keyboard keyboard = new Keyboard(this, R.xml.number_pad);
//        root.setKeyboard(keyboard);
//        keyboardView.setOnKeyboardActionListener(this);
//        View  root2 = getLayoutInflater().inflate(R.layout.strat_screen, null);
//        getWindow().setContentView(root2);

    //        try {
////            Dialog mRootWindow = getWindow();
////            View  mRootView = mRootWindow.getDecorView().findViewById(android.R.id.content);
////            mRootView.getViewTreeObserver().addOnGlobalLayoutListener(
////                    new ViewTreeObserver.OnGlobalLayoutListener() {
////                        public void onGlobalLayout(){
////                            Rect r = new Rect();
////                            View view = mRootWindow.getDecorView();
////                            view.getWindowVisibleDisplayFrame(r);
////                            // r.left, r.top, r.right, r.bottom
////                        }
////                    });
////            WindowManager window = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
////            DisplayMetrics displayMetrics = new DisplayMetrics();
////            window.getDefaultDisplay().getMetrics(displayMetrics);
////            root.getLayoutParams().height = displayMetrics.heightPixels/2;
////            root.getLayoutParams().width = displayMetrics.widthPixels;
//////            LayoutParams layoutParams = root.getLayoutParams().height;
//////            layoutParams.width = width;
//////            layoutParams.height = height;
//////            root.setLayoutParams(layoutParams);
//
////            initFristScreen();
//
//
////        ImageView ivKeyboard = (ImageView) root.findViewById(R.id.ivKeyboard);
//            // get the KeyboardView and add our Keyboard layout to it
////        KeyboardView keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
////        Keyboard keyboard = new Keyboard(this, R.xml.number_pad);
////        keyboardView.setKeyboard(keyboard);
////        keyboardView.setOnKeyboardActionListener(this);
////        return keyboardView;
////            vf = (ViewFlipper) root.findViewById(R.id.viewFlipper);
////        ivKeyboard.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                //whatever you want to do...
////                Toast.makeText(MyInputMethodService.this,"welcome to HWALA",Toast.LENGTH_LONG).show();
////            }
////        });
////        text= (EditText) root.findViewById(R.id.ed_text);
////        text.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////
//////                kv.setVisibility(View.VISIBLE);
////            }
////        });
////        kv = (KeyboardView) root.findViewById(R.id.keyboard_view);
////        kv.setVisibility(View.GONE);
////        Keyboard   keyboard = new Keyboard(this, R.xml.number_pad);
////        kv.setKeyboard(keyboard);
////        kv.setOnKeyboardActionListener(this);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return root;







    //    public  ArrayList<ContactDTO> getAllContacts()
//    {
//        ArrayList<ContactDTO> ret = new ArrayList<ContactDTO>();
//        // Get all raw contacts id list.
//        List<Integer> rawContactsIdList = (new Contact()).getRawContactsIdList( getApplicationContext());
//        int contactListSize = rawContactsIdList.size();
//        ContentResolver contentResolver =  getApplicationContext().getContentResolver();
//        // Loop in the raw contacts list.
//        for(int i=0;i<contactListSize;i++)
//        {
//            // Get the raw contact id.
//            Integer rawContactId = rawContactsIdList.get(i);
//            Log.d(TAG_ANDROID_CONTACTS, "raw contact id : " + rawContactId.intValue());
//            // Data content uri (access data table. )
//            Uri dataContentUri = ContactsContract.Data.CONTENT_URI;
//            // Build query columns name array.
//            List<String> queryColumnList = new ArrayList<String>();
//            // ContactsContract.Data.CONTACT_ID = "contact_id";
//            queryColumnList.add(ContactsContract.Data.CONTACT_ID);
//            // ContactsContract.Data.MIMETYPE = "mimetype";
//            queryColumnList.add(ContactsContract.Data.MIMETYPE);
//            queryColumnList.add(ContactsContract.Data.DATA1);
//            queryColumnList.add(ContactsContract.Data.DATA2);
//            queryColumnList.add(ContactsContract.Data.DATA3);
//            queryColumnList.add(ContactsContract.Data.DATA4);
//            queryColumnList.add(ContactsContract.Data.DATA5);
//            queryColumnList.add(ContactsContract.Data.DATA6);
//            queryColumnList.add(ContactsContract.Data.DATA7);
//            queryColumnList.add(ContactsContract.Data.DATA8);
//            queryColumnList.add(ContactsContract.Data.DATA9);
//            queryColumnList.add(ContactsContract.Data.DATA10);
//            queryColumnList.add(ContactsContract.Data.DATA11);
//            queryColumnList.add(ContactsContract.Data.DATA12);
//            queryColumnList.add(ContactsContract.Data.DATA13);
//            queryColumnList.add(ContactsContract.Data.DATA14);
//            queryColumnList.add(ContactsContract.Data.DATA15);
//            // Translate column name list to array.
//            String queryColumnArr[] = queryColumnList.toArray(new String[queryColumnList.size()]);
//            // Build query condition string. Query rows by contact id.
//            StringBuffer whereClauseBuf = new StringBuffer();
//            whereClauseBuf.append(ContactsContract.Data.RAW_CONTACT_ID);
//            whereClauseBuf.append("=");
//            whereClauseBuf.append(rawContactId);
//            // Query data table and return related contact data.
//            Cursor cursor = contentResolver.query(dataContentUri, queryColumnArr, whereClauseBuf.toString(), null, null);
//            /* If this cursor return database table row data.
//               If do not check cursor.getCount() then it will throw error
//               android.database.CursorIndexOutOfBoundsException: Index 0 requested, with a size of 0.
//               */
//            if(cursor!=null && cursor.getCount() > 0)
//            {
//                StringBuffer lineBuf = new StringBuffer();
//                cursor.moveToFirst();
//                lineBuf.append("Raw Contact Id : ");
//                lineBuf.append(rawContactId);
//                long contactId = cursor.getLong(cursor.getColumnIndex(ContactsContract.Data.CONTACT_ID));
//                lineBuf.append(" , Contact Id : ");
//                lineBuf.append(contactId);
//                do{
//                    try {
//
//
//                        // First get mimetype column value.
//                        String mimeType = cursor.getString(cursor.getColumnIndex(ContactsContract.Data.MIMETYPE));
//                        lineBuf.append(" \r\n , MimeType : ");
//                        lineBuf.append(mimeType);
//                        List<String> dataValueList = (new Contact()).getColumnValueByMimetype(cursor, mimeType,getApplicationContext());
//                        int dataValueListSize = dataValueList.size();
//                        for(int j=0;j < dataValueListSize;j++)
//                        {
//                            String dataValue = dataValueList.get(j);
//                            lineBuf.append(" , ");
//                            lineBuf.append(dataValue);
//                        }
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
//                }while(cursor.moveToNext());
//                Log.d(TAG_ANDROID_CONTACTS, lineBuf.toString());
//            }
//            Log.d(TAG_ANDROID_CONTACTS, "=========================================================================");
//        }
//        return ret;
//    }
//    @Override
//    public void onKey(int primaryCode, int[] keyCodes) {
//        InputConnection ic = getCurrentInputConnection();
//        if (ic == null) return;
//        switch (primaryCode) {
//            case Keyboard.KEYCODE_DELETE:
//                CharSequence selectedText = ic.getSelectedText(0);
//                if (TextUtils.isEmpty(selectedText)) {
//                    // no selection, so delete previous character
////                    ic.deleteSurroundingText(1, 0);
//                    removepreviousText();
//                } else {
//                    removeText((String) selectedText);
////                    // delete the selection
////                    ic.commitText("", 1);
//                }
//                break;
//            case Keyboard.KEYCODE_DONE:
//                kv.setVisibility(View.GONE);
//                break;
//            default:
//                char code = (char) primaryCode;
////                ic.commitText(String.valueOf(code), 1);
//                setText(String.valueOf(code));
//        }
//    }
//
//    public void setText(String x){
//        text.setText(text.getText().toString()+x);
//    }
//    public void removeText(String x){
//        String t=text.getText().toString().replace(x,"");
//        text.setText(t);
//    }
//    public void removepreviousText(){
//        String tes=text.getText().toString();
//        String delete=tes.substring(0,tes.length()-1);
//        text.setText(delete);
//    }
//    @Override
//    public void onPress(int primaryCode) {
//        Toast.makeText(getApplicationContext(), "onPress", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onRelease(int primaryCode) {
//        Toast.makeText(getApplicationContext(), "onRelease", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onText(CharSequence text) {
//        Toast.makeText(getApplicationContext(), "onText", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void swipeLeft() {
//        Toast.makeText(getApplicationContext(), "swipeLeft", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void swipeRight() {
//        Toast.makeText(getApplicationContext(), "swipeRight", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void swipeDown() {
//        Toast.makeText(getApplicationContext(), "swipeDown", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void swipeUp() {
//        Toast.makeText(getApplicationContext(), "swipeUp", Toast.LENGTH_SHORT).show();
//    }
}
