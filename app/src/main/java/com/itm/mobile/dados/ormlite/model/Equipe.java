package com.itm.mobile.dados.ormlite.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@DatabaseTable(tableName="TB_EQUIPE")
public class Equipe implements Serializable {

    public static final String ID = "id";
    public static final String REG_NO = "reg_no";
    public static final String INICIO_ATIVIDADE = "inicio_atividade";
    public static final String STATUS = "status";
    public static final String TIPO_ATIVIDADE = "tipo_atividade";
    public static final String FIM_ATIVIDADE = "fim_atividade";
    public static final String USUARIO_ID = "usuario_id";

    @SerializedName("id")
    @DatabaseField(generatedId = true)
    private UUID id;
    @SerializedName("reg_no")
    @DatabaseField(canBeNull = false)
    int reg_no;
    @SerializedName("inicio_atividade")
    @DatabaseField(canBeNull = false,  columnName = "INICIO_ATIVIDADE", dataType = DataType.DATE_STRING,
            format = "yyyy-MM-dd HH:mm:ss")
    Date inicio_atividade;

    @SerializedName("usuario")
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = USUARIO_ID)
    public Usuario usuario; // COORDENADOR

    public Equipe(){

    }

    public Equipe(int reg_no, Date inicio_atividade) {
        this.reg_no = reg_no;
        this.inicio_atividade = inicio_atividade;
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

    public Date getInicio_atividade() {
        return inicio_atividade;
    }

    public void setInicio_atividade(Date inicio_atividade) {
        this.inicio_atividade = inicio_atividade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
