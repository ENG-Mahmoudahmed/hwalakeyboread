package com.example.hwalasdk;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.inputmethodservice.InputMethodService;
import android.text.InputType;
import android.text.Layout;
import android.view.View;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.core.view.WindowCompat;

import com.licensespring.License;
import com.licensespring.LicenseManager;
import com.licensespring.LicenseSpringConfiguration;

public class MyInputMethodService extends InputMethodService{
LinearLayout screen1;View screen2;

    @Override
    public View onCreateInputView() {
//        WindowCompat.setDecorFitsSystemWindows(window, !isAtLeastAndroid11());
        View  root = getLayoutInflater().inflate(R.layout.screen_1, null);
//        (new Screen1()).InitScreen1(this);
        if(Global.getLicense(getApplicationContext()) ==null){
//            Toast.makeText(getApplicationContext(),"hi test",Toast.LENGTH_LONG).show();
        }
        screen1=root.findViewById(R.id.linerScreen1);
        screen2=root.findViewById(R.id.screen_2);
        Button btnext = root.findViewById(R.id.bt_next_screen);
        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                throw new RuntimeException("Test Crash"); // Force a crash
                try {
                    screen1.setVisibility(View.GONE);
                    (new Screen2()).InitScreen2(MyInputMethodService.this,root,"");
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }
//    @Override
//    public void onComputeInsets(InputMethodService.Insets outInsets) {
//        super.onComputeInsets(outInsets);
//        if (!isFullscreenMode()) {
//            outInsets.contentTopInsets = outInsets.visibleTopInsets;
//        }
//    }
    @Override
    public void onStartInput(EditorInfo attribute, boolean restarting) {
//        switch (attribute.inputType & InputType.TYPE_MASK_CLASS) {
//            case InputType.TYPE_CLASS_NUMBER:
//                Toast.makeText(getApplicationContext(), "onDisplayCompletions", Toast.LENGTH_SHORT).show();
//                break;
//            case InputType.TYPE_CLASS_DATETIME:
//                Toast.makeText(getApplicationContext(), "onDisplayCompletions", Toast.LENGTH_SHORT).show();
//                break;
//            case InputType.TYPE_CLASS_PHONE:
//                Toast.makeText(getApplicationContext(), "onDisplayCompletions", Toast.LENGTH_SHORT).show();
//                break;
//            case InputType.TYPE_CLASS_TEXT:
//                Toast.makeText(getApplicationContext(), "onDisplayCompletions", Toast.LENGTH_SHORT).show();
//                break;
//            default:
//        }
    }

    @Override
    public boolean onEvaluateFullscreenMode() {
//        Toast.makeText(getApplicationContext(), "onEvaluateFullscreenMode", Toast.LENGTH_SHORT).show();
        return super.onEvaluateFullscreenMode();
    }
    @Override
    public void onDisplayCompletions(CompletionInfo[] completions) {
//        Toast.makeText(getApplicationContext(), "onDisplayCompletions", Toast.LENGTH_SHORT).show();
        super.onDisplayCompletions(completions);
    }
    private void sendAction(String text){
        Intent i=new Intent();
        i.setAction("launch.me.action.LAUNCH_IT");
        i.putExtra(Global.keyvalue,text);
        getApplicationContext().startActivity(i);
    }
}