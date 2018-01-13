package com.itm.mobile.dados.ormlite.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@DatabaseTable(tableName="TB_MENSAGEM_CAB")
public class MensagemCab implements Serializable {

    public static final String ID = "id";
    public static final String TITULO = "titulo";
    public static final String DT_REG = "dt_reg";
    public static final String STATUS = "status";
    public static final String TIPO = "tipo";
    public static final String TEXTO = "texto";
    public static final String USUARIO_ID = "usuario_id";

    @SerializedName("id")
    @DatabaseField(generatedId = true)
    private UUID id;
    @SerializedName("titulo")
    @DatabaseField(canBeNull = false)
    String titulo;
    @SerializedName("dt_reg")
    @DatabaseField(canBeNull = false,  columnName = "DT_REG", dataType = DataType.DATE_STRING,
            format = "yyyy-MM-dd HH:mm:ss")
    Date dt_reg;
    @SerializedName("tipo")
    @DatabaseField(canBeNull = false)
    int tipo;
    @SerializedName("texto")
    @DatabaseField(canBeNull = false)
    String texto;

    @SerializedName("usuario")
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = USUARIO_ID)
    public Usuario usuario;

    public MensagemCab(){

    }

    public MensagemCab(String titulo, Date dt_reg, int tipo, String texto) {
        this.titulo = titulo;
        this.dt_reg = dt_reg;
        this.tipo = tipo;
        this.texto = texto;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDt_reg() {
        return dt_reg;
    }

    public void setDt_reg(Date dt_reg) {
        this.dt_reg = dt_reg;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
