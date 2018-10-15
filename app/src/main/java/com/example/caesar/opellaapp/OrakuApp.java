package com.example.caesar.opellaapp;

import android.app.Application;

import co.paystack.android.PaystackSdk;

public class OrakuApp extends Application {

    private static boolean isChatActivityOpen = false;



//    public static boolean isChatActivityOpen(){
//
//        return isChatActivityOpen;
//    }

//    public static void setChatActivityOpen(boolean tisChatActivityOpen){
//        FireCorral.isChatActivityOpen = tisChatActivityOpen;
//    }

    @Override
    public void onCreate() {

        super.onCreate();
//        if (FirebaseApp.getApps(this).isEmpty()){
//            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
//        }
        PaystackSdk.initialize(getApplicationContext());
    }

}
