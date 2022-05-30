package com.example.hwalasdk;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Screen5 {
    ImageView imback;
    Button btnext;
    HwalaKeyboard kv;
    String name;
    String number;
    String amount;

    public void InitScreen5(InputMethodService inputMethodService,String name,String number,String amount,ScreenName BackScreen){
        this.name=name;
        this.number=number;
        this.amount=amount;
        View view2 = inputMethodService.getLayoutInflater().inflate(R.layout.screen_5, null);
        inputMethodService.getWindow().setContentView(view2);
        imback = view2.findViewById(R.id.im_back);
        imback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    (new Screen4()).InitScreen4(inputMethodService,name,number,amount,BackScreen);
                } catch (Exception e) {
                    Toast.makeText(inputMethodService.getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnext = view2.findViewById(R.id.bt_next_screen);
        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    (new Screen6()).InitScreen6(inputMethodService,name,number,amount);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(inputMethodService.getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
//        TextView tv_amount=view2.findViewById(R.id.tv_amount);
//        tv_amount.setText(inputMethodService.getString(R.string.screen_5_disc).replace("+",number));
        EditText ed_1=getEditText(view2,R.id.ed_screen_5_pin_1,inputMethodService);
        EditText ed_2=getEditText(view2,R.id.ed_screen_5_pin_2,inputMethodService);
        EditText ed_3=getEditText(view2,R.id.ed_screen_5_pin_3,inputMethodService);
        EditText ed_4=getEditText(view2,R.id.ed_screen_5_pin_4,inputMethodService);
        ed_1.requestFocus();
        ed_1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                ed_2.requestFocus();
            }
        });
        ed_2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                ed_3.requestFocus();
            }
        });
        ed_3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                ed_4.requestFocus();
            }
        });
        ed_4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        BackView.InitBackView(inputMethodService,view2,kv,"Verification ",null);
    }
    public EditText getEditText(View view2,int name,InputMethodService inputMethodService){
        EditText text= (EditText) view2.findViewById(name);
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
        android.inputmethodservice.Keyboard keyboard = new Keyboard(inputMethodService, R.xml.number_pad);
        InputConnection ic = text.onCreateInputConnection(new EditorInfo());
        kv.setInputConnection(ic); // custom keyboard method
        return text;
    }
}
