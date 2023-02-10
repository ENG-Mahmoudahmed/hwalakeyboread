package com.example.hwalasdk;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;

import android.content.Context;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.os.Build;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.util.regex.Pattern;

import de.hdodenhof.circleimageview.CircleImageView;

public class Screen2 {
    HwalaKeyboard kv;
    ImageView imback;
    Button btnext;
    String number="";
    EditText text;
    public void InitScreen2(InputMethodService inputMethodService
            ,View root
            ,String oldnumber){
        View rootscreen=Global.ShowAndHide(root, Global.Screen.screen2);
//        View view2 = inputMethodService.getLayoutInflater().inflate(R.layout.screen_2, null);
//        inputMethodService.getWindow().setContentView(view2);
//        Toast.makeText(inputMethodService.getApplicationContext(), "Please enter  valid phone number", Toast.LENGTH_LONG).show();
        imback = rootscreen.findViewById(R.id.im_back);
        imback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    (new Screen1()).InitScreen1(inputMethodService,root);
                } catch (Exception e) {
//                    Toast.makeText(inputMethodService.getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnext = rootscreen.findViewById(R.id.bt_next_screen);
        btnext.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                try {
                 number =text.getText().toString();
                   if(Pattern.matches("^[+]?[0-9]{10,13}$", number)) {
                       (new Screen4()).InitScreen4(inputMethodService, "", number, "",ScreenName.Screen_2,root);
                   }else {
                       Toast.makeText(inputMethodService.getApplicationContext(), "Please enter  valid phone number", Toast.LENGTH_LONG).show();
                   }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(inputMethodService.getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        CircleImageView img_contact = rootscreen.findViewById(R.id.img_contact);
        img_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    (new Screen3()).InitScreen3(inputMethodService,"",root);
                } catch (Exception e) {
                    Toast.makeText(inputMethodService.getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        TextView tv_contact = rootscreen.findViewById(R.id.tv_contact);
        tv_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    (new Screen3()).InitScreen3(inputMethodService,"",root);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(inputMethodService.getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        text= (EditText) rootscreen.findViewById(R.id.ed_contact_number);
        text.setText(oldnumber);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                kv.setVisibility(View.VISIBLE);
            }
        });
        text.requestFocus();

        // get the input connection from the currently focused edit text
        text.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic = text.onCreateInputConnection(new EditorInfo());
                    kv.setInputConnection(ic); // custom keyboard method
                }
            }
        });
        kv = (HwalaKeyboard) rootscreen.findViewById(R.id.keyboard_view);
        kv.setVisibility(View.GONE);
        Keyboard  keyboard = new Keyboard(inputMethodService, R.xml.number_pad);
        InputConnection ic = text.onCreateInputConnection(new EditorInfo());
        kv.setInputConnection(ic); // custom keyboard method
        BackView.InitBackView(inputMethodService,rootscreen,kv,"Transfer money to",null);
    }
}
