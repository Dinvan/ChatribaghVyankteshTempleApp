package com.ank.chatribaghvyankteshtempleapp;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

/**
 * Created by Ankur on 16/07/2016.
 */
public class AppController extends Application {
    public static final String TAG = AppController.class.getSimpleName();


    private ImageLoader mImageLoader;

    private static AppController mInstance;
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressWarnings("unused")
    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;

        initImageLoader(getApplicationContext());
    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }
    public static void initImageLoader(Context context) {
// This configuration tuning is custom. You can tune every option, you may tune some of them,
// or you can create default configuration by
// ImageLoaderConfiguration.createDefault(this);
// method.
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.denyCacheImageMultipleSizesInMemory();
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        config.writeDebugLogs(); // Remove for release app

// Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config.build());
    }

}
