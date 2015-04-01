package com.icehousecorp.ginanjar.rxdemo;

import android.util.Log;

/**
 * Created by ginanjar on 4/1/15.
 */
public class Playground {
    private static Playground instance = null;
    private Playground(){}

    private final static String TAG =  Playground.class.getName();

    public static synchronized Playground getInstance(){
        if(instance == null){
            instance = new Playground();
        }

        return instance;
    }

    public static void nativeLambdaTest(){
        Log.v(TAG, "Runnable test");

        Runnable r1 = new Runnable(){

            @Override
            public void run() {
                Log.v(TAG, "Hello world from Java 7");
            }
        };

        r1.run();

        /*

        Lambda expressions are not supported at this language level

        Runnable r2 = () -> Log.v(TAG, "Hello world from Java 8");
        r2.run();

        */

        // using retrolambda, after a little bit configuration
        Runnable r2 = () -> Log.v(TAG, "Hello world from Java 8 with retrolambda");
        r2.run();
    }
}

