package com.example.hwalakeyboread;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.hololo.tutorial.library.PermissionStep;
import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;
import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener;

import java.util.ArrayList;

public class OnboardingActivity extends TutorialActivity {
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_onboarding);
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.hide();
//        }

        addFragment(new Step.Builder().setTitle("Pay on the go while you chat with ease")
                .setContent("Making money transfer hasn’t been easier. Enable the keyboard button and make transfers from your keyboard.")
                .setBackgroundColor(Color.BLACK) // int background color

                .setDrawable(R.drawable.ic_logos_hwala) // int top drawable
                .build());

        addFragment(new Step.Builder().setTitle( "Split bills payment with your friends")
                .setContent( "Need to split the bills? We got you covered our split payment system. Sharing bills is now easier than ever.")
                .setBackgroundColor(Color.BLACK) // int background color
                .setDrawable(R.drawable.ic_logos_hwala) // int top drawable
                .build());
        addFragment(new Step.Builder().setTitle(  "Access your most frequent contacts")
                .setContent(  "Quickly make money transfers through the app. Or add contacts to your accessibility menu with ease.")
                .setBackgroundColor(Color.BLACK) // int background color
                .setDrawable(R.drawable.ic_logos_hwala) // int top drawable
                .build());
        // Permission Step
//        addFragment(new PermissionStep.Builder().setTitle("getString(R.string.permission_title)")
//                .setContent("getString(R.string.permission_detail)")
//                .setBackgroundColor(Color.parseColor("#FF0957"))
//                .setDrawable(R.drawable.ic_logos_hwala)
//                .setSummary("getString(R.string.continue_and_learn)")
//                .setPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
//                .build());
//        try {
//            fragmentManager = getSupportFragmentManager();
//
//            // new instance is created and data is took from an
//            // array list known as getDataonborading
//            final PaperOnboardingFragment paperOnboardingFragment = PaperOnboardingFragment.newInstance(getDataforOnboarding());
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//            // fragmentTransaction method is used
//            // do all the transactions or changes
//            // between different fragments
//            fragmentTransaction.add(R.id.frame_layout, paperOnboardingFragment);
//
//            // all the changes are committed
//            fragmentTransaction.commit();
////            paperOnboardingFragment.setOnRightOutListener(new PaperOnboardingOnRightOutListener() {
////                @Override
////                public void onRightOut() {
////                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
////                    Fragment bf = new BlankFragment();
////                    fragmentTransaction.replace(R.id.frame_layout, bf);
////                    fragmentTransaction.commit();
////                }
////            });
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
    @Override
    public void finishTutorial() {
        Intent mainIntent = new Intent(OnboardingActivity.this, MainActivity.class);
        OnboardingActivity.this.startActivity(mainIntent);
        OnboardingActivity.this.finish();
    }
    public void enable2(View view) {

    }
    private ArrayList<PaperOnboardingPage> getDataforOnboarding() {

        // the first string is to show the main title ,
        // second is to show the message below the
        // title, then color of background is passed ,
        // then the image to show on the screen is passed
        // and at last icon to navigate from one screen to other
        PaperOnboardingPage source = new PaperOnboardingPage("Pay on the go while you chat with ease",
                "Making money transfer hasn’t been easier. Enable the keyboard button and make transfers from your keyboard.",
                Color.parseColor("#ffffff"), R.drawable.ic_logos_hwala,  R.drawable.onboardingicon);

        PaperOnboardingPage source1 = new PaperOnboardingPage("Split bills payment with your friends",
                "Need to split the bills? We got you covered our split payment system. Sharing bills is now easier than ever.",
                Color.parseColor("#ffffff"),
                R.drawable.ic_logos_hwala,
                R.drawable.onboardingicon);
        PaperOnboardingPage source2 = new PaperOnboardingPage("Access your most frequent contacts",
                "Quickly make money transfers through the app. Or add contacts to your accessibility menu with ease.",
                Color.parseColor("#ffffff"),
                R.drawable.ic_logos_hwala, R.drawable.onboardingicon);


        // array list is used to store
        // data of onbaording screen
        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();

        // all the sources(data to show on screens)
        // are added to array list
        elements.add(source);
        elements.add(source1);
        elements.add(source2);
        return elements;
    }

    @Override
    public void currentFragmentPosition(int position) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}