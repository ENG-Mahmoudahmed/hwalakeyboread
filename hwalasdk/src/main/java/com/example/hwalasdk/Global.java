package com.example.hwalasdk;

import android.content.Context;
import android.view.View;

import com.licensespring.License;
import com.licensespring.LicenseManager;
import com.licensespring.LicenseSpringConfiguration;
import com.licensespring.model.Product;

public class Global {
    public final static String keyvalue="keyTest";
    public  static  License getLicense(Context context){
        try {
        LicenseSpringConfiguration configuration = LicenseSpringConfiguration.builder()
                .apiKey("757ee91a-d53d-4c04-9df3-40c7d777e63c")
                .productCode("ht1")
                .sharedKey("F-Aj111sUMBKbZDocKiT79QGnkRsfHCLmrD7VG2ojN0")
                .appName("Hwala Test 1")
//                .appVersion("1.0.0")
                .build();
        LicenseManager manager = LicenseManager.getInstance();
        manager.initialize(configuration, context);
        Product product = manager.getProductDetails();
        String s=product.getProductName();
        License currentLicense = manager.getCurrent();
        return currentLicense;
        }catch (Exception e){
          return null;
        }
    }


    public static View ShowAndHide(View root, Screen whichView){
        View screen1=root.findViewById(R.id.linerScreen1);
        View screen2=root.findViewById(R.id.screen_2);
        View screen3=root.findViewById(R.id.screen_3);
        View screen4=root.findViewById(R.id.screen_4);
        View screen5=root.findViewById(R.id.screen_5);
        View screen6=root.findViewById(R.id.screen_6);
        View screen7=root.findViewById(R.id.screen_7);
        screen1.setVisibility(View.GONE);
        screen2.setVisibility(View.GONE);
        screen3.setVisibility(View.GONE);
        screen4.setVisibility(View.GONE);
        screen5.setVisibility(View.GONE);
        screen6.setVisibility(View.GONE);
        screen7.setVisibility(View.GONE);
        switch (whichView){
            case screen1:
                screen1.setVisibility(View.VISIBLE);
//                screen2.setVisibility(View.VISIBLE);
//                screen3.setVisibility(View.VISIBLE);
//                screen4.setVisibility(View.VISIBLE);
//                screen5.setVisibility(View.VISIBLE);
//                screen6.setVisibility(View.VISIBLE);
//                screen7.setVisibility(View.VISIBLE);
                return screen1;
            case screen2:
//                screen1.setVisibility(View.VISIBLE);
                screen2.setVisibility(View.VISIBLE);
//                screen3.setVisibility(View.VISIBLE);
//                screen4.setVisibility(View.VISIBLE);
//                screen5.setVisibility(View.VISIBLE);
//                screen6.setVisibility(View.VISIBLE);
//                screen7.setVisibility(View.VISIBLE);
                return screen2;
            case screen3:
//                screen1.setVisibility(View.VISIBLE);
//                screen2.setVisibility(View.VISIBLE);
                screen3.setVisibility(View.VISIBLE);
//                screen4.setVisibility(View.VISIBLE);
//                screen5.setVisibility(View.VISIBLE);
//                screen6.setVisibility(View.VISIBLE);
//                screen7.setVisibility(View.VISIBLE);
                return screen3;
            case screen4:
//                screen1.setVisibility(View.VISIBLE);
//                screen2.setVisibility(View.VISIBLE);
//                screen3.setVisibility(View.VISIBLE);
                screen4.setVisibility(View.VISIBLE);
//                screen5.setVisibility(View.VISIBLE);
//                screen6.setVisibility(View.VISIBLE);
//                screen7.setVisibility(View.VISIBLE);
                return screen4;
            case screen5:
//                screen1.setVisibility(View.VISIBLE);
//                screen2.setVisibility(View.VISIBLE);
//                screen3.setVisibility(View.VISIBLE);
//                screen4.setVisibility(View.VISIBLE);
                screen5.setVisibility(View.VISIBLE);
//                screen6.setVisibility(View.VISIBLE);
//                screen7.setVisibility(View.VISIBLE);
                return screen5;
            case screen6:
//                screen1.setVisibility(View.VISIBLE);
//                screen2.setVisibility(View.VISIBLE);
//                screen3.setVisibility(View.VISIBLE);
//                screen4.setVisibility(View.VISIBLE);
//                screen5.setVisibility(View.VISIBLE);
                screen6.setVisibility(View.VISIBLE);
//                screen7.setVisibility(View.VISIBLE);
                return screen6;
            default:
                return screen1;
        }
    }
    public enum Screen{
        screen1,
        screen2,
        screen3,
        screen4,
        screen5,
        screen6,
        screen7;
    }
}
