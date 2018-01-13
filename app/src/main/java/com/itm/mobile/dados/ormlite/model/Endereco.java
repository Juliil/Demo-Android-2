package com.itm.mobile.dados.ormlite.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.UUID;

@DatabaseTable(tableName="TB_ENDERECO")
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    public final static String LOGRADOURO = "logradouro";
    public final static String BAIRRO = "bairro";
    public final static String NUMERO = "numero";
    public final static String CEP = "cep";

    @SerializedName("id")
    @DatabaseField(generatedId = true)
    private UUID id ;
    @SerializedName("logradouro")
    @DatabaseField(canBeNull = false, uniqueCombo = true, columnName = LOGRADOURO)
    String logradouro;
    @SerializedName("numero")
    @DatabaseField(canBeNull = false, uniqueCombo = true, columnName = NUMERO)
    String numero;
    @SerializedName("complemento")
    @DatabaseField(canBeNull = true)
    String complemento;
    @SerializedName("bairro")
    @DatabaseField(canBeNull = true)
    String bairro;
    @SerializedName("cep")
    @DatabaseField(canBeNull = true, uniqueCombo = true, columnName = CEP)
    String cep;
    @SerializedName("cidade")
    @DatabaseField(canBeNull = true)
    String cidade;
    @SerializedName("uf")
    @DatabaseField(canBeNull = true)
    String uf;

    public Endereco(){

    }

    public Endereco(UUID id, String logradouro, String numero, String complemento, String bairro,
                    String cep, String cidade, String uf) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
    }

    public Endereco(String logradouro, String numero, String complemento, String bairro, String cep, String cidade, String uf) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String toText() {
        String entrega = cep + " - "
                + logradouro + ", "
                + numero + ", "
                + complemento + " - "
                + bairro + " - "
                + cidade + "/"
                + uf;
        return entrega;
    }
}
