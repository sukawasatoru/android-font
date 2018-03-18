package jp.tinyport.example.font.core.viewmodel;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.provider.FontRequest;
import android.support.v4.provider.FontsContractCompat;
import android.util.Log;

import javax.inject.Inject;

import jp.tinyport.example.font.R;

public class DownloadableFontViewModel extends BaseObservable implements LifecycleObserver {
    public final ObservableField<Typeface> downloadTypeface;

    private static final String TAG = "DownloadableFont";

    private final Context mContext;

    private HandlerThread mHandlerThread;

    @Inject
    DownloadableFontViewModel(Context context) {
        mContext = context;
        downloadTypeface = new ObservableField<>();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        mHandlerThread = new HandlerThread(TAG);
        mHandlerThread.start();

        FontsContractCompat.requestFont(mContext,
                new FontRequest(
                        "com.google.android.gms.fonts",
                        "com.google.android.gms",
                        "Inconsolata",
                        R.array.com_google_android_gms_fonts_certs),
                new FontsContractCompat.FontRequestCallback() {

                    @Override
                    public void onTypefaceRetrieved(Typeface typeface) {
                        Log.i(TAG, "onTypefaceRetrieved");
                        downloadTypeface.set(typeface);
                    }

                    @Override
                    public void onTypefaceRequestFailed(int reason) {
                        Log.i(TAG, "onTypefaceRequestFailed " + reason);
                    }
                }, new Handler(mHandlerThread.getLooper()));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        mHandlerThread.quit();
    }
}
