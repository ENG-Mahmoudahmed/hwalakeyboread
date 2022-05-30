package com.example.hwalasdk;

import static android.content.Context.INPUT_METHOD_SERVICE;

import android.inputmethodservice.InputMethodService;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BackView {

    public static ImageView im_change_keyboeard;
    public static ImageView  im_hide_keyboeard;
    public static TextView tv_title;
    public static void InitBackView(InputMethodService inputMethodService, View root, HwalaKeyboard kv, String title,HwalaKeyboardChar keyboardChar){
        tv_title = root.findViewById(R.id.tv_title);
        tv_title.setText(title);
        im_change_keyboeard = root.findViewById(R.id.im_change_keyboeard);
        im_change_keyboeard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputMethodManager imeManager = (InputMethodManager)
                            inputMethodService.getApplicationContext().getSystemService(INPUT_METHOD_SERVICE);
                    imeManager.showInputMethodPicker();
                } catch (Exception e) {
                    Toast.makeText(inputMethodService.getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        im_hide_keyboeard = root.findViewById(R.id.im_hide_keyboeard);
        im_hide_keyboeard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(kv==null){
                        keyboardChar.setVisibility(View.GONE);
                    }else{
                        kv.setVisibility(View.GONE);
                    }

                } catch (Exception e) {
                    Toast.makeText(inputMethodService.getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
