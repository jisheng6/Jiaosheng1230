package com.bawei.jiaosheng1230;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Adminjs on 2017/12/30.
 */

public class IApplication extends Application{

    public static IGetDataBase iGetDataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://result.eolinker.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        iGetDataBase = retrofit.create(IGetDataBase.class);
    }
}
