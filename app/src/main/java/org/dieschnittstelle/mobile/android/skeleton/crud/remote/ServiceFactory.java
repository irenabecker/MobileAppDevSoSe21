package org.dieschnittstelle.mobile.android.skeleton.crud.remote;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceFactory {

    public final static String BASE_URL = "http://10.0.2.2:8080/";

    public static ServiceTodo getServiceTodo() {
        return new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder()
                        .connectTimeout(1, TimeUnit.SECONDS)
                        .build())
                .build()
                .create(ServiceTodo.class);
    }
}