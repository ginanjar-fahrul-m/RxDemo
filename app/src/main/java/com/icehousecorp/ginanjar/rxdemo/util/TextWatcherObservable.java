package com.icehousecorp.ginanjar.rxdemo.util;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import rx.Observable;
import rx.Subscriber;
import rx.subjects.BehaviorSubject;
import rx.subjects.Subject;

/**
 * Created by ginanjar on 4/1/15.
 */
public class TextWatcherObservable {
    private static final String TAG = TextWatcherObservable.class.getSimpleName();
    static public Observable<String> create(EditText editText){
        return Observable.create(new OnSubscribe(editText));
    }

    static class OnSubscribe implements TextWatcher, Observable.OnSubscribe<String> {
        final private Subject<String, String> subject = BehaviorSubject.create();

        private OnSubscribe(EditText editText){
            editText.addTextChangedListener(this);
        }

        @Override
        public void call(Subscriber<? super String> subscriber) {
            subject.subscribe(subscriber);
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            subject.onNext(s.toString());
            Log.v(TAG, "TextChanged");
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }
}
