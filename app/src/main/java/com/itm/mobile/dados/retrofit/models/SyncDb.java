package com.itm.mobile.dados.retrofit.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by WLFULTRABOOK on 16/03/2017.
 */

public class SyncDb {
    @SerializedName("id")
    public String id;
    @SerializedName("codid")
    public int codid;
    @SerializedName("status")
    public int status;
    @SerializedName("tipo_atualiz")
    public int tipo_atualiz;
}
