package com.itm.mobile.dados.ormlite.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.UUID;

@DatabaseTable(tableName="TB_ZONAELEITORAL")
public class ZonaEleitoral implements Serializable {

    public static final String ID = "id";
    public static final String COD_TRE = "cod_tre";
    public static final String QTDE_ELEITORES = "qtde_eleitores";
    public static final String TELEFONE = "telefone";

    public static final String MUNICIPIO_ID = "municipio_id";

    @SerializedName("id")
    @DatabaseField(generatedId = true)
    private UUID id;
    @SerializedName("cod_tre")
    @DatabaseField(canBeNull = false)
    int cod_tre;
    @SerializedName("qtde_eleitores")
    @DatabaseField(canBeNull = false)
    int qtde_eleitores;
    @SerializedName("telefone")
    @DatabaseField(canBeNull = false)
    String telefone;

    @SerializedName("municipio")
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = MUNICIPIO_ID)
    public Municipio municipio;


    public ZonaEleitoral(){

    }

    public ZonaEleitoral(int cod_tre, int qtde_eleitores, String telefone) {
        this.cod_tre = cod_tre;
        this.qtde_eleitores = qtde_eleitores;
        this.telefone = telefone;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getCod_tre() {
        return cod_tre;
    }

    public void setCod_tre(int cod_tre) {
        this.cod_tre = cod_tre;
    }

    public int getQtde_eleitores() {
        return qtde_eleitores;
    }

    public void setQtde_eleitores(int qtde_eleitores) {
        this.qtde_eleitores = qtde_eleitores;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
}
