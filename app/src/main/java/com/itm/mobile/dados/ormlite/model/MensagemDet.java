package com.itm.mobile.dados.ormlite.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.UUID;

@DatabaseTable(tableName="TB_MENSAGEM_DET")
public class MensagemDet implements Serializable {

    public final static String Id = "id";
    public final static String MENSAGEM_CAB_ID = "mensagem_cab_id";
    public final static String USUARIO_ID = "usuario_id";

    @SerializedName("id")
    @DatabaseField(generatedId = true)
    private UUID id;

    @SerializedName("mensagemCab")
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = MENSAGEM_CAB_ID)
    public MensagemCab mensagemCab;

    @SerializedName("usuario")
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = USUARIO_ID)
    public Usuario usuario;

    public MensagemDet(){

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public MensagemCab getMensagemCab() {
        return mensagemCab;
    }

    public void setMensagemCab(MensagemCab mensagemCab) {
        this.mensagemCab = mensagemCab;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
