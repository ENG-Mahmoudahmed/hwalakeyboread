package com.example.hwalakeyboread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hwalasdk.Global;

public class MainActivity extends AppCompatActivity {
        String text="";
    int PERMISSION_REQUEST_CONTACT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetDataFromIntent(getIntent());
        TextView t=findViewById(R.id.tvtext);
        t.setText(text);

        requestPermission();

//        InputMethodManager imeManager =
//                (InputMethodManager)
//
//                        getApplicationContext().getSystemService(INPUT_METHOD_SERVICE);
//        imeManager.showInputMethodPicker();
//        askForContactPermission();
    }
    public static Boolean getBooleanFromPreferences(Context context, String key) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Boolean result = sharedPreferences.getBoolean(key, false);
        return result;
    }

    public static void saveBooleanInPreferences(Context context, Boolean value, String key) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }
    public void showKeyboread(){
//        if(!getBooleanFromPreferences(this,"frist")) {
            Intent enableIntent = new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS);
            enableIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.startActivity(enableIntent);
//            saveBooleanInPreferences(this,true,"frist");
//        }
    }
    public void GetDataFromIntent(Intent in){
        text=in.getStringExtra(Global.keyvalue);
    }
    public void askForContactPermission(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS)) {
                    showDialog();
                }
            }
        } else {
            showDialog();
        }
    }
    public void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Contacts access needed");
        builder.setPositiveButton(android.R.string.ok, null);
        builder.setMessage("please confirm Contacts access");
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                // Only call the permission request api on Android M
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, PERMISSION_REQUEST_CONTACT);
                }
            }
        });
        builder.show();
    }
    // Check whether user has phone contacts manipulation permission or not.
    private boolean hasPhoneContactsPermission(String permission)
    {
        boolean ret = false;
        // If android sdk version is bigger than 23 the need to check run time permission.
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // return phone read contacts permission grant status.
            int hasPermission = ContextCompat.checkSelfPermission(getApplicationContext(), permission);
            // If permission is granted then return true.
            if (hasPermission == PackageManager.PERMISSION_GRANTED) {
                ret = true;
            }
        }else
        {
            ret = true;
        }
        return ret;
    }
    // Request a runtime permission to app user.
    private void requestPermission()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if( getApplicationContext().checkSelfPermission( Manifest.permission.READ_CONTACTS ) != PackageManager.PERMISSION_GRANTED )
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, PERMISSION_REQUEST_CONTACT);
        }else{
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, PERMISSION_REQUEST_CONTACT);

        }
    }
    // After user select Allow or Deny button in request runtime permission dialog
    // , this method will be invoked.
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        int length = grantResults.length;
        if(length > 0)
        {
            int grantResult = grantResults[0];
            if(grantResult == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getApplicationContext(), "You allowed permission, please click the button again.", Toast.LENGTH_LONG).show();
            }else
            {
                Toast.makeText(getApplicationContext(), "You denied permission.", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void enable(View view) {
        showKeyboread();
    }
}