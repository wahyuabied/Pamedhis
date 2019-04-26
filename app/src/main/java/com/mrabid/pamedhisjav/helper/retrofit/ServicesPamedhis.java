package com.mrabid.pamedhisjav.helper.retrofit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServicesPamedhis {
    private static Retrofit.Builder builder = new Retrofit.Builder();

    public static API buildServiceClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1, TimeUnit.MINUTES).readTimeout(30,TimeUnit.SECONDS).writeTimeout(15,TimeUnit.SECONDS).build();

        return builder.baseUrl("http://abdullahainun.me:3010/api/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(API.class);

    }

    public static API buildServiceClientHeader() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1, TimeUnit.MINUTES).readTimeout(30,TimeUnit.SECONDS).writeTimeout(15,TimeUnit.SECONDS).build();

        return builder.baseUrl("http://abdullahainun.me:3020/api/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(API.class);

    }

    public static API buildServiceClient3030() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1, TimeUnit.MINUTES).readTimeout(30,TimeUnit.SECONDS).writeTimeout(15,TimeUnit.SECONDS).build();

        return builder.baseUrl("http://abdullahainun.me:3030/api/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(API.class);

    }

    public static String domain () {
        return "http://abdullahainun.me:3010/";
    }
}
