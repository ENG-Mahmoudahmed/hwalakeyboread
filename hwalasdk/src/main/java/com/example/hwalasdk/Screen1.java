package com.example.hwalasdk;

import android.content.Context;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Screen1 {
    Button btnext;
    public void InitScreen1(InputMethodService inputMethodService){
        View root = inputMethodService.getLayoutInflater().inflate(R.layout.screen_1, null);
        inputMethodService.getWindow().setContentView(root);
        btnext = root.findViewById(R.id.bt_next_screen);
        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    (new Screen2()).InitScreen2(inputMethodService,"");
                } catch (Exception e) {
                    e.printStackTrace();
                Toast.makeText(inputMethodService.getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
