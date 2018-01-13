package com.itm.mobile.dados.ormlite.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@DatabaseTable(tableName="TB_OCORRENCIA")
public class Ocorrencia implements Serializable {

    public static final String ID = "id";
    public static final String DT_REG = "dt_reg";
    public static final String TITULO = "titulo";
    public static final String STATUS = "status";
    public static final String AREA_RESPONSAVEL = "area_responsavel";
    public static final String DT_RESPOSTA = "dt_resposta";
    public static final String TEXTO = "texto";
    public static final String OCORRENCIA_TIPO_ID = "ocorrencia_tipo_id";
    public static final String USUARIO_ID = "usuario_id";

    @SerializedName("id")
    @DatabaseField(generatedId = true)
    private UUID id;
    @SerializedName("dt_reg")
    @DatabaseField(canBeNull = false,  columnName = "DT_REG", dataType = DataType.DATE_STRING,
            format = "yyyy-MM-dd HH:mm:ss")
    Date dt_reg;
    @SerializedName("titulo")
    @DatabaseField(canBeNull = false)
    String titulo;
    @SerializedName("status")
    @DatabaseField(canBeNull = false)
    String status;
    @SerializedName("area_responsavel")
    @DatabaseField(canBeNull = true)
    String area_responsavel;
    @SerializedName("dt_resposta")
    @DatabaseField(canBeNull = true,  columnName = "ULT_MODIF", dataType = DataType.DATE_STRING,
            format = "yyyy-MM-dd HH:mm:ss")
    Date dt_resposta;
    @SerializedName("texto")
    @DatabaseField(canBeNull = true)
    String texto;

    @SerializedName("ocorrenciaTipo")
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = OCORRENCIA_TIPO_ID)
    public OcorrenciaTipo ocorrenciaTipo;

    @SerializedName("usuario")
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = USUARIO_ID)
    public Usuario usuario;

    public Ocorrencia(){

    }

    public Ocorrencia(Date dt_reg, String titulo, String status, String area_responsavel, Date dt_resposta, String texto) {
        this.dt_reg = dt_reg;
        this.titulo = titulo;
        this.status = status;
        this.area_responsavel = area_responsavel;
        this.dt_resposta = dt_resposta;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getArea_responsavel() {
        return area_responsavel;
    }

    public void setArea_responsavel(String area_responsavel) {
        this.area_responsavel = area_responsavel;
    }

    public Date getDt_resposta() {
        return dt_resposta;
    }

    public void setDt_resposta(Date dt_resposta) {
        this.dt_resposta = dt_resposta;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public OcorrenciaTipo getOcorrenciaTipo() {
        return ocorrenciaTipo;
    }

    public void setOcorrenciaTipo(OcorrenciaTipo ocorrenciaTipo) {
        this.ocorrenciaTipo = ocorrenciaTipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
