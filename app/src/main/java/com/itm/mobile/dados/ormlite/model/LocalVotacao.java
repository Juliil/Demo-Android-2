package com.itm.mobile.dados.ormlite.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.UUID;

@DatabaseTable(tableName="TB_LOCALVOTACAO")
public class LocalVotacao implements Serializable {

    public static final String ID = "id";
    public static final String COD_TRE = "cod_tre";
    public static final String NOME = "nome";
    public static final String ENDERECO = "endereco";
    public static final String BAIRRO = "bairro";
    public static final String QTDE_SECOES = "qtde_secoes";
    public static final String APTOS = "aptos";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";

    @SerializedName("id")
    @DatabaseField(generatedId = true)
    private UUID id;
    @SerializedName("cod_tre")
    @DatabaseField(canBeNull = false)
    int cod_tre;
    @SerializedName("nome")
    @DatabaseField(canBeNull = false)
    String nome;
    @SerializedName("endereco")
    @DatabaseField(canBeNull = false)
    String endereco;
    @SerializedName("bairro")
    @DatabaseField(canBeNull = false)
    String bairro;
    @SerializedName("qtde_secoes")
    @DatabaseField(canBeNull = false)
    int qtde_secoes;
    @SerializedName("aptos")
    @DatabaseField(canBeNull = false)
    int aptos;
    @SerializedName("latitude")
    @DatabaseField(canBeNull = false)
    double latitude;
    @SerializedName("longitude")
    @DatabaseField(canBeNull = false)
    double longitude;


    public LocalVotacao(){

    }

    public LocalVotacao(int cod_tre, String nome, String endereco, String bairro, int qtde_secoes,
                        int aptos, double latitude, double longitude) {
        this.cod_tre = cod_tre;
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.qtde_secoes = qtde_secoes;
        this.aptos = aptos;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getQtde_secoes() {
        return qtde_secoes;
    }

    public void setQtde_secoes(int qtde_secoes) {
        this.qtde_secoes = qtde_secoes;
    }

    public int getAptos() {
        return aptos;
    }

    public void setAptos(int aptos) {
        this.aptos = aptos;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
