package com.itm.mobile.dados.ormlite.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.UUID;

@DatabaseTable(tableName="TB_OCORRENCIA_TIPO")
public class OcorrenciaTipo implements Serializable {

    public final static String Id = "id";
    public final static String DESCRICAO = "descricao";
    public final static String IMAGEM = "imagem";
    public final static String CATEGORIA = "categoria";

    @SerializedName("id")
    @DatabaseField(generatedId = true)
    private UUID id;
    @SerializedName("descricao")
    @DatabaseField(canBeNull = false)
    String descricao;
    @SerializedName("imagem")
    @DatabaseField(canBeNull = false)
    String imagem;
    @SerializedName("categoria")
    @DatabaseField(canBeNull = false)
    int categoria;

    public OcorrenciaTipo(){

    }

    public OcorrenciaTipo(String descricao, String imagem, int categoria) {
        this.descricao = descricao;
        this.imagem = imagem;
        this.categoria = categoria;
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

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
}
