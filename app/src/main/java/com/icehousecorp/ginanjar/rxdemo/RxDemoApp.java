package com.icehousecorp.ginanjar.rxdemo;

import android.app.Application;
/**
 * Created by ginanjar on 4/1/15.
 */
public class RxDemoApp extends Application{

    private static RxDemoApp instance;

    @Override
    public void onCreate(){
        super.onCreate();
        instance = this;
    }

    public static RxDemoApp getInstance() {return instance;}
}
