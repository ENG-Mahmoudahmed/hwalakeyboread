package com.example.hwalasdk;

import android.inputmethodservice.InputMethodService;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Screen6 {
    ImageView imback;
    Button btnext;
    public void InitScreen6(InputMethodService inputMethodService){
        View view2 = inputMethodService.getLayoutInflater().inflate(R.layout.screen_6, null);
        inputMethodService.getWindow().setContentView(view2);
//        imback = view2.findViewById(R.id.im_back);
//        imback.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                try {
//                    (new Screen6()).InitScreen6(inputMethodService);
//                } catch (Exception e) {
//                }
//            }
//        });
        btnext = view2.findViewById(R.id.bt_next_screen);
        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    (new Screen1()).InitScreen1(inputMethodService);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
