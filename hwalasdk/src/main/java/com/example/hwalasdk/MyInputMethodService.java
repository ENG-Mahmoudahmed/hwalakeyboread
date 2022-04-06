package com.example.hwalasdk;


import android.content.Intent;
import android.inputmethodservice.InputMethodService;
import android.view.View;
import android.view.inputmethod.CompletionInfo;

public class MyInputMethodService extends InputMethodService{

    @Override
    public View onCreateInputView() {
        View  root = getLayoutInflater().inflate(R.layout.test, null);
        (new Screen1()).InitScreen1(this);
        return root;
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