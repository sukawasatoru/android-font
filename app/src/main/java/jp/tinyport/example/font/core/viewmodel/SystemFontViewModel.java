package jp.tinyport.example.font.core.viewmodel;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;

import java.io.File;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class SystemFontViewModel extends BaseObservable implements LifecycleObserver {
    private final CompositeDisposable mDisposables;
    private final SystemFontAdapter mAdapter;

    @Inject
    SystemFontViewModel() {
        mDisposables = new CompositeDisposable();
        mAdapter = new SystemFontAdapter();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        mDisposables.add(Single.just(new File("/system/fonts"))
                .flatMapObservable(data -> Observable.fromArray(data.listFiles()))
                .map(data -> new Pair<>(data.getName(), Typeface.createFromFile(data)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mAdapter::add));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        mDisposables.dispose();
    }

    @Bindable
    public RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }
}
