package com.icehousecorp.ginanjar.rxdemo.view;

import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.content.Context;
import com.icehousecorp.ginanjar.rxdemo.R;
import com.icehousecorp.ginanjar.rxdemo.util.TextWatcherObservable;
import android.widget.EditText;

import rx.Observable;

/**
 * Created by ginanjar on 4/1/15.
 */
public class DemoView extends FrameLayout{
    private static final String TAG = DemoView.class.getSimpleName();

    private EditText numberA;
    private EditText numberB;
    private EditText numberC;
    private Observable<String> sumObservable;

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
        numberB = (EditText) findViewById(R.id.editText);

        sumObservable = TextWatcherObservable.create(numberA);

    }
}
