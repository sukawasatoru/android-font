package jp.tinyport.example.font;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import jp.tinyport.example.font.core.App;
import jp.tinyport.example.font.core.di.ActivityModule;
import jp.tinyport.example.font.core.viewmodel.MainViewModel;
import jp.tinyport.example.font.databinding.MainBinding;

public class MainActivity extends Activity implements LifecycleOwner {
    @Inject
    MainViewModel mViewModel;

    private MainBinding mBinding;
    private LifecycleRegistry mLifecycleRegistry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((App) getApplication()).getComponent()
                .plus(new ActivityModule(this))
                .inject(this);

        mBinding = DataBindingUtil.setContentView(this, R.layout.main);
        mBinding.setVm(mViewModel);

        mLifecycleRegistry = new LifecycleRegistry(this);
        mLifecycleRegistry.addObserver(mViewModel);
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return mLifecycleRegistry;
    }
}
