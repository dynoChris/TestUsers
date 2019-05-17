package com.oliverstudio.testusers;

import android.app.Application;

import com.oliverstudio.testusers.di.AppComponent;
import com.oliverstudio.testusers.di.DaggerAppComponent;

public class App extends Application {

    private static AppComponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        sAppComponent = DaggerAppComponent.builder()
                .build();

    }

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }

}
