package com.icehousecorp.ginanjar.rxdemo.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import rx.Observable;
import rx.android.lifecycle.LifecycleEvent;
import rx.subjects.BehaviorSubject;

/**
 * Created by ginanjar on 4/2/15.
 */
public class RxActionBarActivity extends ActionBarActivity {

    private final BehaviorSubject<LifecycleEvent> lifecycleSubject = BehaviorSubject.create();

    public Observable<LifecycleEvent> lifecycle(){
        return lifecycleSubject.asObservable();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        lifecycleSubject.onNext(LifecycleEvent.START);
        super.onStart();
    }

    @Override
    protected void onResume() {
        lifecycleSubject.onNext(LifecycleEvent.RESUME);
        super.onResume();
    }

    @Override
    protected void onPause() {
        lifecycleSubject.onNext(LifecycleEvent.PAUSE);
        super.onPause();
    }

    @Override
    protected void onStop() {
        lifecycleSubject.onNext(LifecycleEvent.STOP);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        lifecycleSubject.onNext(LifecycleEvent.DESTROY);
        super.onDestroy();
    }
}
