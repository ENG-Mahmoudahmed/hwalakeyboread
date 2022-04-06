package com.example.hwalasdk;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.ImageView;

public class Screen5 {
    ImageView imback;
    Button btnext;
    HwalaKeyboard kv;
    public void InitScreen5(InputMethodService inputMethodService){
        View view2 = inputMethodService.getLayoutInflater().inflate(R.layout.screen_5, null);
        inputMethodService.getWindow().setContentView(view2);
        imback = view2.findViewById(R.id.im_back);
        imback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    (new Screen5()).InitScreen5(inputMethodService);
                } catch (Exception e) {
                }
            }
        });
        btnext = view2.findViewById(R.id.bt_next_screen);
        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    (new Screen6()).InitScreen6(inputMethodService);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        kv = (HwalaKeyboard) view2.findViewById(R.id.keyboard_view);
        kv.setVisibility(View.GONE);
        android.inputmethodservice.Keyboard keyboard = new Keyboard(inputMethodService, R.xml.number_pad);
//        InputConnection ic = text.onCreateInputConnection(new EditorInfo());
//        kv.setInputConnection(ic); // custom keyboard method
    }
}
