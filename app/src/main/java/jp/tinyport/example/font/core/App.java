package jp.tinyport.example.font.core;

import android.app.Application;

import jp.tinyport.example.font.core.di.AppComponent;
import jp.tinyport.example.font.core.di.AppModule;
import jp.tinyport.example.font.core.di.DaggerAppComponent;

public class App extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getComponent() {
        return mAppComponent;
    }
}
