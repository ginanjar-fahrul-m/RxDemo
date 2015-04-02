package com.icehousecorp.ginanjar.rxdemo.view;

import android.app.Application;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import android.content.Context;

import com.icehousecorp.ginanjar.rxdemo.MainActivity;
import com.icehousecorp.ginanjar.rxdemo.R;

import android.widget.EditText;
import android.widget.TextView;

import rx.Observable;
import rx.Subscription;
import rx.android.lifecycle.LifecycleObservable;
import rx.android.view.ViewActions;
import rx.android.view.ViewObservable;
import rx.android.widget.WidgetObservable;
import rx.functions.Action1;

/**
 * Created by ginanjar on 4/1/15.
 */
public class DemoView extends FrameLayout{
    private static final String TAG = DemoView.class.getSimpleName();

    private EditText numberA;
    private EditText numberB;
    private EditText numberC;
    private TextView message;
    private Observable<String> sumObservable;
    private Subscription subsA;
    private Subscription subsB;

    public DemoView(Context context) {
        super(context, null);
    }

    public DemoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        numberA = (EditText) findViewById(R.id.editText);
        numberB = (EditText) findViewById(R.id.editText2);
        numberC = (EditText) findViewById(R.id.editText3);
        message = (TextView) findViewById(R.id.textView6);

        //WidgetObservable

        Observable<Integer> sumFromA = WidgetObservable.text(numberA)
            .map(e -> e.text())
            .map(c -> {
                try {
                    return Integer.parseInt(c.toString());
                } catch (Exception e) {
                    return 0;
                }
            });

        subsA = sumFromA.subscribe(i -> {
            try {
                numberC.setText("" + (i + Integer.parseInt(numberB.getText().toString())));
            } catch (Exception e){
                numberC.setText("" + i);
            }
        });

        Observable<Integer> sumFromB = WidgetObservable.text(numberB)
                .map(e -> e.text())
                .map(c -> {
                    try {
                        return Integer.parseInt(c.toString());
                    } catch (Exception e){
                        return 0;
                    }
                });

        subsB = sumFromB.subscribe(i -> {
            try {
                numberC.setText("" + (i + Integer.parseInt(numberA.getText().toString())));
            } catch (Exception e){
                numberC.setText("" + i);
            }
        });

        //add subsA and subsB to LifecycleObservable
        LifecycleObservable.bindActivityLifecycle(((MainActivity) getContext()).lifecycle(), sumFromA);
        LifecycleObservable.bindActivityLifecycle(((MainActivity) getContext()).lifecycle(), sumFromB);
    }
}
