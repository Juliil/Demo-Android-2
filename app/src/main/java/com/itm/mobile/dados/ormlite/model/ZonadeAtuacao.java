package com.itm.mobile.dados.ormlite.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@DatabaseTable(tableName="TB_ZONADEATUACAO")
public class ZonadeAtuacao implements Serializable {

    public static final String ID = "id";
    public static final String REG_NO = "reg_no";
    public static final String ULT_MODIF = "ult_modif";
    public static final String SECAOELEITORAL_ID = "secaoeleitoral_id";
    public static final String EQUIPE_ID = "equipe_id";

    @SerializedName("id")
    @DatabaseField(generatedId = true)
    private UUID id;
    @SerializedName("reg_no")
    @DatabaseField(canBeNull = false)
    int reg_no;
    @SerializedName("ult_modif")
    @DatabaseField(canBeNull = false,  columnName = "ULT_MODIF", dataType = DataType.DATE_STRING,
            format = "yyyy-MM-dd HH:mm:ss")
    Date ult_modif;

    @SerializedName("secaoeleitoral")
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = SECAOELEITORAL_ID)
    public SecaoEleitoral secaoeleitoral;

    @SerializedName("equipe")
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = EQUIPE_ID)
    public Equipe equipe;

    public ZonadeAtuacao(){

    }

    public ZonadeAtuacao(int reg_no, Date ult_modif) {
        this.reg_no = reg_no;
        this.ult_modif = ult_modif;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getReg_no() {
        return reg_no;
    }

    public void setReg_no(int reg_no) {
        this.reg_no = reg_no;
    }

    public Date getUlt_modif() {
        return ult_modif;
    }

    public void setUlt_modif(Date ult_modif) {
        this.ult_modif = ult_modif;
    }

    public SecaoEleitoral getSecaoeleitoral() {
        return secaoeleitoral;
    }

    public void setSecaoeleitoral(SecaoEleitoral secaoeleitoral) {
        this.secaoeleitoral = secaoeleitoral;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
