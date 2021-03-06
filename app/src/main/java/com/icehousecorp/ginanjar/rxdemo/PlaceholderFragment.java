package com.icehousecorp.ginanjar.rxdemo;

/**
 * Created by ginanjar on 4/1/15.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.icehousecorp.ginanjar.rxdemo.view.DemoView;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private final static String TAG =  Playground.class.getSimpleName();

    public PlaceholderFragment() {
        Playground.getInstance().nativeLambdaTest();
    }
    private DemoView demoView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        demoView = (DemoView) view.findViewById(R.id.demo_view);
    }
}
