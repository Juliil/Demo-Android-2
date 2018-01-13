package com.itm.mobile.dados.ormlite.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@DatabaseTable(tableName="TB_OCORRENCIA")
public class UsuarioAtividade implements Serializable {

    public static final String ID = "id";
    public static final String DT_REG = "dt_reg";
    public static final String TIPO = "tipo";
    public static final String LATITUDE = "LATITUDE";
    public static final String LONGITUDE = "longitude";
    public static final String OBS = "obs";
    public static final String TEXTO = "texto";
    public static final String USUARIO_ID = "usuario_id";

    @SerializedName("id")
    @DatabaseField(generatedId = true)
    private UUID id;
    @SerializedName("dt_reg")
    @DatabaseField(canBeNull = false,  columnName = "DT_REG", dataType = DataType.DATE_STRING,
            format = "yyyy-MM-dd HH:mm:ss")
    Date dt_reg;
    @SerializedName("tipo")
    @DatabaseField(canBeNull = false)
    int tipo;
    @SerializedName("latitude")
    @DatabaseField(canBeNull = false)
    Double latitude;
    @SerializedName("longitude")
    @DatabaseField(canBeNull = true)
    Double longitude;
    @SerializedName("texto")
    @DatabaseField(canBeNull = true)
    String texto;

    @SerializedName("usuario")
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = USUARIO_ID)
    public Usuario usuario;

    public UsuarioAtividade(){

    }

    public UsuarioAtividade(Date dt_reg, int tipo, Double latitude, Double longitude, String texto) {
        this.dt_reg = dt_reg;
        this.tipo = tipo;
        this.latitude = latitude;
        this.longitude = longitude;
        this.texto = texto;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
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
