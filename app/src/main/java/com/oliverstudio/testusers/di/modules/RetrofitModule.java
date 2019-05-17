package com.oliverstudio.testusers.di.modules;

import com.google.gson.GsonBuilder;
import com.oliverstudio.testusers.data.network.ApiRandomUser;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    @Provides
    @Singleton
    public ApiRandomUser provideApiRandomUser() {
        return new Retrofit.Builder()
                .baseUrl(ApiRandomUser.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .build().create(ApiRandomUser.class);
    }

}