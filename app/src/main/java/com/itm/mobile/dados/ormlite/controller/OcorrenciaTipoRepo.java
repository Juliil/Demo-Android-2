package com.itm.mobile.dados.ormlite.controller;

import android.content.Context;

import com.itm.mobile.dados.ormlite.DatabaseHelper;
import com.itm.mobile.dados.ormlite.DatabaseManager;
import com.itm.mobile.dados.ormlite.model.OcorrenciaTipo;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OcorrenciaTipoRepo implements Crud{

    private DatabaseHelper helper;

    public OcorrenciaTipoRepo(Context context) {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item) {
        int index = -1;

        OcorrenciaTipo object = (OcorrenciaTipo) item;
        try {
            index = helper.getOcorrenciaTipoDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int update(Object item) {
        int index = -1;

        OcorrenciaTipo object = (OcorrenciaTipo) item;

        try {
            helper.getOcorrenciaTipoDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int delete(Object item) {
        int index = -1;

        OcorrenciaTipo object = (OcorrenciaTipo) item;

        try {
            helper.getOcorrenciaTipoDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(UUID id) {
        OcorrenciaTipo OcorrenciaTipo  = null;
        try {
            OcorrenciaTipo = helper.getOcorrenciaTipoDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return OcorrenciaTipo;
    }

    @Override
    public List<?> findAll() {
        List<OcorrenciaTipo> items = new ArrayList<>();

        try {
            items = helper.getOcorrenciaTipoDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public List<OcorrenciaTipo> findByDescr(String param) {
        List<OcorrenciaTipo> items = new ArrayList<>();
        try {
            QueryBuilder<OcorrenciaTipo, UUID> queryBuilder = helper.getOcorrenciaTipoDao().queryBuilder();
            queryBuilder.orderBy(OcorrenciaTipo.DESCRICAO, true);
            queryBuilder.where().like(OcorrenciaTipo.DESCRICAO, param);
            items = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public List<OcorrenciaTipo> listByCateg(int param) {
        List<OcorrenciaTipo> items = new ArrayList<>();
        try {
            QueryBuilder<OcorrenciaTipo, UUID> queryBuilder = helper.getOcorrenciaTipoDao().queryBuilder();
            queryBuilder.orderBy(OcorrenciaTipo.DESCRICAO, true);
            queryBuilder.where().eq(OcorrenciaTipo.CATEGORIA, param);
            items = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }
    
}
