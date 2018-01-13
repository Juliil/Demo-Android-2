package com.itm.mobile.dados.ormlite.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.UUID;

@DatabaseTable(tableName="TB_MUNICIPIO")
public class Municipio implements Serializable {

    public static final String ID = "id";
    public static final String COD_TRE = "cod_tre";
    public static final String DESCRICAO = "descricao";

    @SerializedName("id")
    @DatabaseField(generatedId = true)
    private UUID id;
    @SerializedName("descricao")
    @DatabaseField(canBeNull = false)
    String descricao;
    @SerializedName("cod_tre")
    @DatabaseField(canBeNull = false)
    int cod_tre;

    public Municipio(){

    }

    public Municipio(String descricao, int cod_tre) {
        this.descricao = descricao;
        this.cod_tre = cod_tre;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCod_tre() {
        return cod_tre;
    }

    public void setCod_tre(int cod_tre) {
        this.cod_tre = cod_tre;
    }
}
