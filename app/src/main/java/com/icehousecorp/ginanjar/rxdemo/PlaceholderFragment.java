package com.icehousecorp.ginanjar.rxdemo;

/**
 * Created by ginanjar on 4/1/15.
 */

import android.database.Observable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    public PlaceholderFragment() {
        Playground.getInstance().nativeLambdaTest();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        final EditText textNumberA = (EditText) rootView.findViewById(R.id.editText);
        final EditText textNumberB = (EditText) rootView.findViewById(R.id.editText2);
        final EditText textNumberC = (EditText) rootView.findViewById(R.id.editText3);

        // final Observable<Integer> numberA = Events.text

        return rootView;
    }
}
