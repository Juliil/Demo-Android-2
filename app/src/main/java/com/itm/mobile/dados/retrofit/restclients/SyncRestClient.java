package com.itm.mobile.dados.retrofit.restclients;

import android.util.Log;

import com.itm.mobile.config.Constants;
import com.itm.mobile.dados.retrofit.apiservices.SincCheckInterface;
import com.itm.mobile.dados.retrofit.models.SyncDb;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SyncRestClient {
    private static SyncRestClient instance = null;

    private SyncRestClient.ResultCallback callback;

    private SincCheckInterface service;
    List<SyncDb> syncDb = null;
    boolean success = false;

    public SyncRestClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        service = retrofit.create(SincCheckInterface.class);
    }

    public List<SyncDb> checkSinc(String Id) {
        Call<List<SyncDb>> objlist = service.checkSync(Id);
        objlist.enqueue(new Callback<List<SyncDb>>() {
            @Override
            public void onResponse(Call<List<SyncDb>> call, Response<List<SyncDb>> response) {
                if (response.isSuccessful()) {
                    syncDb = response.body();
                    callback.resultReady(syncDb);
                }
            }

            @Override
            public void onFailure(Call<List<SyncDb>> call, Throwable t) { Log.e("REST", t.getMessage()); }
        });
        return syncDb;
    }

    public static SyncRestClient getInstance() {
        if(instance == null) {
            instance = new SyncRestClient();
        }
        return instance;
    }


    public void setCallback(SyncRestClient.ResultCallback callback) {
        this.callback = callback;
    }


    public interface ResultCallback {
        void resultReady(List<SyncDb> ret);
    }
}
