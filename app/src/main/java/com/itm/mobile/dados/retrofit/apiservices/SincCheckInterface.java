package com.itm.mobile.dados.retrofit.apiservices;

import com.itm.mobile.dados.retrofit.models.SyncDb;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by WLFULTRABOOK on 02/02/2016.
 */
public interface SincCheckInterface {

    @GET("/api/v1/atualiza/checkdb/{id}")
    Call<List<SyncDb>> checkSync(@Path("id") String id);

}
