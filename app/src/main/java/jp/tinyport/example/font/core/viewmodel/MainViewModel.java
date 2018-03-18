package jp.tinyport.example.font.core.viewmodel;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.util.Pair;
import android.view.ViewGroup;

import java.util.Arrays;

import javax.inject.Inject;

import jp.tinyport.example.font.BR;
import jp.tinyport.example.font.R;
import jp.tinyport.example.font.databinding.SystemFontBinding;

public class MainViewModel extends BaseObservable implements LifecycleObserver, LifecycleOwner {
    private final Activity mActivity;
    private final LifecycleRegistry mLifecycleRegistry;
    private final SystemFontViewModel mSystemFontViewModel;

    private MenuAdapter mAdapter;

    @Inject
    MainViewModel(Activity activity, SystemFontViewModel systemFontViewModel) {
        mActivity = activity;
        mSystemFontViewModel = systemFontViewModel;
        mLifecycleRegistry = new LifecycleRegistry(this);
        mLifecycleRegistry.addObserver(systemFontViewModel);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        final ViewGroup mainContentView = mActivity.findViewById(R.id.main_content);

        mAdapter = new MenuAdapter(Arrays.asList(
                new Pair<>("FontFamily", createFontFamilyScene(mainContentView)),
                new Pair<>("System Font", createSystemFontScene(mainContentView)),
                new Pair<>("Bundled Font", createBundledFontScene(mainContentView))));
        notifyPropertyChanged(BR.adapter);

        // for workaround.
        TransitionManager.go(mAdapter.get(0).second);

        mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return mLifecycleRegistry;
    }

    @Bindable
    public RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    private Scene createFontFamilyScene(ViewGroup sceneRoot) {
        return new Scene(sceneRoot, mActivity.getLayoutInflater()
                .inflate(R.layout.fontfamily, sceneRoot, false));
    }

    private Scene createSystemFontScene(ViewGroup sceneRoot) {
        final SystemFontBinding binding = SystemFontBinding.inflate(
                mActivity.getLayoutInflater(), sceneRoot, false);
        binding.setVm(mSystemFontViewModel);
        binding.fontList.setFocusable(false);
        return new Scene(sceneRoot, binding.getRoot());
    }

    private Scene createBundledFontScene(ViewGroup sceneRoot) {
        return new Scene(sceneRoot, mActivity.getLayoutInflater()
                .inflate(R.layout.bundled_font, sceneRoot, false));
    }
}
