package com.dk.sixt.carzrent.apis;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dk on 30/8/17.
 */

public class ApiManager {

    private static ApiManager apiManager;
    private ApiInterface apiInterface;
    private Context mContext;
    private ApiClient apiClient;

    private ApiManager(Context mContext) {
        this.mContext = mContext;
        this.apiClient= new ApiClient();
    }

    public static ApiManager getInstance(Context context) {
        if (apiManager == null) {
            apiManager = new ApiManager(context);
        }
        return apiManager;
    }

    public ApiInterface getApiInterface(){
        if(apiInterface==null)
            apiInterface = apiClient.getApiClient().create(ApiInterface.class);
        return apiInterface;
    }


    /**
     * Created by dk on 30/8/17.
     */

    private class ApiClient {

        private Retrofit mRetrofit;
        private String BASE_URL = "http://www.codetalk.de/";

        public  Retrofit getApiClient() {
            if (mRetrofit == null) {
                Gson gson = new GsonBuilder().setLenient().create();
                OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                        .connectTimeout(60, TimeUnit.SECONDS)
                        .writeTimeout(60, TimeUnit.SECONDS)
                        .readTimeout(60, TimeUnit.SECONDS)
                        .build();
                mRetrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
            }
            return mRetrofit;
        }


    }
}
