package com.icehousecorp.ginanjar.rxdemo.util;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import rx.Observable;
import rx.Subscriber;
import rx.subjects.BehaviorSubject;
import rx.subjects.Subject;

/**
 * Created by ginanjar on 4/1/15.
 */
public class TextWatcherObservable {
    static public Observable<Integer> create(EditText editText){
        return Observable.create(new OnSubscribe(editText));
    }

    static class OnSubscribe implements TextWatcher, Observable.OnSubscribe<Integer> {
        final private Subject<Integer, Integer> subject = BehaviorSubject.create();

        private OnSubscribe(EditText editText){
            editText.addTextChangedListener(this);
        }

        @Override
        public void call(Subscriber<? super Integer> subscriber) {
            subject.subscribe(subscriber);
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            subject.onNext(Integer.parseInt(s.toString()));
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }
}
