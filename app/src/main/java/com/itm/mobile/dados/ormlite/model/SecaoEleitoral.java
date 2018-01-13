package com.itm.mobile.dados.ormlite.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.UUID;

@DatabaseTable(tableName="TB_SECAOELEITORAL")
public class SecaoEleitoral implements Serializable {

    public static final String ID = "id";
    public static final String COD_TRE = "cod_tre";
    public static final String APTOS = "aptos";

    public static final String ZONAELEITORAL_ID = "zonaeleitoral_id";
    public static final String LOCALVOTACAO_ID = "localvotacao_id";

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

    @SerializedName("zonaEleitoral")
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = ZONAELEITORAL_ID)
    public ZonaEleitoral zonaEleitoral;

    @SerializedName("localVotacao")
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = LOCALVOTACAO_ID)
    public LocalVotacao localVotacao;

    public SecaoEleitoral(){

    }

    public SecaoEleitoral(int cod_tre, int qtde_eleitores, String telefone) {
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

    public ZonaEleitoral getZonaEleitoral() {
        return zonaEleitoral;
    }

    public void setZonaEleitoral(ZonaEleitoral zonaEleitoral) {
        this.zonaEleitoral = zonaEleitoral;
    }

    public LocalVotacao getLocalVotacao() {
        return localVotacao;
    }

    public void setLocalVotacao(LocalVotacao localVotacao) {
        this.localVotacao = localVotacao;
    }
}
