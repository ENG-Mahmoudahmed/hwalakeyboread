package com.example.hwalasdk;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.inputmethodservice.InputMethodService;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

public class MyInputMethodService extends InputMethodService{

    @Override
    public View onCreateInputView() {

        View  root = getLayoutInflater().inflate(R.layout.test, null);
        (new Screen1()).InitScreen1(this);

        return root;
    }
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