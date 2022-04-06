package com.example.hwalasdk;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class Screen2 {
    HwalaKeyboard kv;
    ImageView imback;
    Button btnext;
    public void InitScreen2(InputMethodService inputMethodService){
        View view2 = inputMethodService.getLayoutInflater().inflate(R.layout.screen_2, null);
        inputMethodService.getWindow().setContentView(view2);
        imback = view2.findViewById(R.id.im_back);
        imback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    (new Screen1()).InitScreen1(inputMethodService);
                } catch (Exception e) {
                }
            }
        });
        btnext = view2.findViewById(R.id.bt_next_screen);
        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    (new Screen4()).InitScreen4(inputMethodService);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });



        CircleImageView img_contact = view2.findViewById(R.id.img_contact);
        img_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    (new Screen3()).InitScreen3(inputMethodService);
                } catch (Exception e) {
                }
            }
        });
        TextView tv_contact = view2.findViewById(R.id.tv_contact);
        tv_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    (new Screen3()).InitScreen3(inputMethodService);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        EditText text= (EditText) view2.findViewById(R.id.ed_contact_number);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kv.setVisibility(View.VISIBLE);
            }
        });
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
        kv = (HwalaKeyboard) view2.findViewById(R.id.keyboard_view);
        kv.setVisibility(View.GONE);
        Keyboard  keyboard = new Keyboard(inputMethodService, R.xml.number_pad);
        InputConnection ic = text.onCreateInputConnection(new EditorInfo());
        kv.setInputConnection(ic); // custom keyboard method
    }
}
