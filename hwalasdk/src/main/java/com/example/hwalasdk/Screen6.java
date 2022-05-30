package com.example.hwalasdk;

import android.inputmethodservice.InputMethodService;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Screen6 {
    ImageView imback;
    Button btnext;
    String name;
    String number;
    String amount;
    String note;
    public void InitScreen6(InputMethodService inputMethodService,String name,String number,String amount){
        this.name=name;
        this.number=number;
        this.amount=amount;
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
        TextView tv_amount=view2.findViewById(R.id.tv_screen6_amount);
         note=inputMethodService.getString(R.string.screen_6_successful_transaction_details).replace("+",number).replace("*",amount);
        tv_amount.setText(note);
        InputConnection ic = inputMethodService.getCurrentInputConnection();
        btnext = view2.findViewById(R.id.bt_next_screen);
        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ic.commitText(note ,1);
                    (new Screen1()).InitScreen1(inputMethodService);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(inputMethodService.getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
