package com.itm.mobile.dados.ormlite.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@DatabaseTable(tableName="TB_EQUIPE_MEMBROS")
public class EquipeMembros implements Serializable {

    public static final String ID = "id";
    public static final String DT_REG = "dt_reg";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    public static final String ULT_CHECKIN = "ult_checkin";
    public static final String ULT_CHECKOUT = "ult_checkout";
    public static final String USUARIO_ID = "usuario_id";
    public static final String EQUIPE_ID = "equipe_id";


    @SerializedName("id")
    @DatabaseField(generatedId = true)
    private UUID id;
    @SerializedName("dt_reg")
    @DatabaseField(canBeNull = false,  columnName = "DT_REG", dataType = DataType.DATE_STRING,
            format = "yyyy-MM-dd HH:mm:ss")
    Date dt_reg;
    @SerializedName("latitude")
    @DatabaseField(canBeNull = false)
    double latitude;
    @SerializedName("longitude")
    @DatabaseField(canBeNull = false)
    double longitude;
    @SerializedName("ult_checkin")
    @DatabaseField(canBeNull = false,  columnName = "ULT_CHECKIN", dataType = DataType.DATE_STRING,
            format = "yyyy-MM-dd HH:mm:ss")
    Date ult_checkin;
    @SerializedName("ult_checkout")
    @DatabaseField(canBeNull = false,  columnName = "ULT_CHECKOUT", dataType = DataType.DATE_STRING,
            format = "yyyy-MM-dd HH:mm:ss")
    Date ult_checkout;

    @SerializedName("usuario")
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = USUARIO_ID)
    public Usuario usuario;

    @SerializedName("equipe")
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = EQUIPE_ID)
    public Equipe equipe;

    public EquipeMembros(){

    }

    public EquipeMembros(Date dt_reg, double latitude, double longitude, Date ult_checkin, Date ult_checkout) {
        this.dt_reg = dt_reg;
        this.latitude = latitude;
        this.longitude = longitude;
        this.ult_checkin = ult_checkin;
        this.ult_checkout = ult_checkout;
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

    public Date getUlt_checkin() {
        return ult_checkin;
    }

    public void setUlt_checkin(Date ult_checkin) {
        this.ult_checkin = ult_checkin;
    }

    public Date getUlt_checkout() {
        return ult_checkout;
    }

    public void setUlt_checkout(Date ult_checkout) {
        this.ult_checkout = ult_checkout;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
