package com.itm.mobile.dados.ormlite.controller;

import android.content.Context;

import com.itm.mobile.dados.ormlite.DatabaseHelper;
import com.itm.mobile.dados.ormlite.DatabaseManager;
import com.itm.mobile.dados.ormlite.model.Ocorrencia;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OcorrenciaRepo implements Crud{

    private DatabaseHelper helper;

    public OcorrenciaRepo(Context context) {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item) {
        int index = -1;

        Ocorrencia object = (Ocorrencia) item;
        try {
            index = helper.getOcorrenciaDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int update(Object item) {
        int index = -1;

        Ocorrencia object = (Ocorrencia) item;

        try {
            helper.getOcorrenciaDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int delete(Object item) {
        int index = -1;

        Ocorrencia object = (Ocorrencia) item;

        try {
            helper.getOcorrenciaDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(UUID id) {
        Ocorrencia Ocorrencia  = null;
        try {
            Ocorrencia = helper.getOcorrenciaDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Ocorrencia;
    }

    @Override
    public List<?> findAll() {
        List<Ocorrencia> items = new ArrayList<>();

        try {
            items = helper.getOcorrenciaDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public List<Ocorrencia> listByTipo(UUID ocorr_id) {
        List<Ocorrencia> items = new ArrayList<>();
        try {
            QueryBuilder<Ocorrencia, UUID> queryBuilder = helper.getOcorrenciaDao().queryBuilder();
            queryBuilder.orderBy(Ocorrencia.DT_REG, true);
            queryBuilder.where().eq(Ocorrencia.OCORRENCIA_TIPO_ID, ocorr_id);
            items = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public List<Ocorrencia> listByResponsavel(String param) {
        List<Ocorrencia> items = new ArrayList<>();
        try {
            QueryBuilder<Ocorrencia, UUID> queryBuilder = helper.getOcorrenciaDao().queryBuilder();
            queryBuilder.orderBy(Ocorrencia.DT_REG, true);
            queryBuilder.where().eq(Ocorrencia.AREA_RESPONSAVEL, param);
            items = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }
    
}
