package com.example.hwalasdk;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.os.Build;
import android.telephony.TelephonyManager;
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

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.regex.Pattern;

public class Screen4 {
    ImageView imback;
    Button btnext,btchange;
    HwalaKeyboard kv;
    String number = "";
    public TextView txtName;
    public TextView txtNumber;
    String amount;
    EditText text;


    public void InitScreen4(InputMethodService inputMethodService, String name, String number, String totalamount,ScreenName BackScreen, View root) {
//        View view2 = inputMethodService.getLayoutInflater().inflate(R.layout.screen_4, null);
//        inputMethodService.getWindow().setContentView(view2);
        View rootscreen=Global.ShowAndHide(root, Global.Screen.screen4);

        txtName = (TextView) rootscreen.findViewById(R.id.firstLine);
        txtNumber = (TextView) rootscreen.findViewById(R.id.secondLine);
        ((TextView) rootscreen.findViewById(R.id.tv_screen_4_e_wallet_number)).setText(getPhone(inputMethodService));

        txtName.setText(name);
        txtNumber.setText(number);

        imback = rootscreen.findViewById(R.id.im_back);
        imback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    switch (BackScreen){
                        case Screen_2:
                            (new Screen2()).InitScreen2(inputMethodService,root, number);
                            break;
                        case Screen_3:
                            (new Screen3()).InitScreen3(inputMethodService, number,root);
                            break;
                        default:
                            (new Screen2()).InitScreen2(inputMethodService,root, number);
                            break;
                    }

                } catch (Exception e) {
                    Toast.makeText(inputMethodService.getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnext = rootscreen.findViewById(R.id.bt_next_screen);
        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    amount = text.getText().toString();
                    try{
                        double value = Double.parseDouble(amount);
                        (new Screen5()).InitScreen5(inputMethodService, name, number, amount,BackScreen,root);
                    }
                    catch (Exception e){
                        Toast.makeText(inputMethodService.getApplicationContext(), "Please enter  valid amount", Toast.LENGTH_LONG).show();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(inputMethodService.getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        btchange = rootscreen.findViewById(R.id.bt_screen_4_change);
        btchange.setOnClickListener(new View.OnClickListener() {
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


        btnext.setBackground(inputMethodService.getDrawable(R.drawable.hwalabutton_unselected));
        btnext.setEnabled(false);
        text = (EditText) rootscreen.findViewById(R.id.et_screen_4_money_amount);
        text.requestFocus();
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kv.setVisibility(View.VISIBLE);
            }
        });
        // get the input connection from the currently focused edit text
        text.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic = text.onCreateInputConnection(new EditorInfo());
                    kv.setInputConnection(ic); // custom keyboard method
                }
            }
        });
        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
//                amount = text.getText().toString();
//                amount.replace("-","");
//                amount.replace("'","");
//                amount.replace("+","");
////                    amount.replace(".","");
//                text.setText(amount);
                if (editable.length() > 0) {
                    btnext.setBackground(inputMethodService.getDrawable(R.drawable.hwalabutton));
                    btnext.setEnabled(true);
                } else {
                    btnext.setBackground(inputMethodService.getDrawable(R.drawable.hwalabutton_unselected));
                    btnext.setEnabled(false);
                }
            }
        });
        if(!totalamount.equalsIgnoreCase("0.0")) {
            text.setText(totalamount);
        }
        kv = (HwalaKeyboard) rootscreen.findViewById(R.id.keyboard_view);
        kv.setVisibility(View.GONE);
        android.inputmethodservice.Keyboard keyboard = new Keyboard(inputMethodService, R.xml.number_pad);
        InputConnection ic = text.onCreateInputConnection(new EditorInfo());
        kv.setInputConnection(ic); // custom keyboard method
        BackView.InitBackView(inputMethodService,rootscreen,kv,"Transaction details",null);
    }

    public String getPhone(InputMethodService inputMethodService) {
        try {
            TelephonyManager tMgr = (TelephonyManager) inputMethodService.getSystemService(Context.TELEPHONY_SERVICE);
            if (ActivityCompat.checkSelfPermission(inputMethodService, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED
            ) {

                String mPhoneNumber = tMgr.getLine1Number();
                return mPhoneNumber;
            }
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(inputMethodService.getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        return "";
    }
}
