package com.itm.mobile.dados.ormlite.controller;

import android.content.Context;

import com.itm.mobile.dados.ormlite.DatabaseHelper;
import com.itm.mobile.dados.ormlite.DatabaseManager;
import com.itm.mobile.dados.ormlite.model.Municipio;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MunicipioRepo implements Crud{

    private DatabaseHelper helper;

    public MunicipioRepo(Context context) {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item) {
        int index = -1;

        Municipio object = (Municipio) item;
        try {
            index = helper.getMunicipioDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int update(Object item) {
        int index = -1;

        Municipio object = (Municipio) item;

        try {
            helper.getMunicipioDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int delete(Object item) {
        int index = -1;

        Municipio object = (Municipio) item;

        try {
            helper.getMunicipioDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(UUID id) {
        Municipio Municipio  = null;
        try {
            Municipio = helper.getMunicipioDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Municipio;
    }

    @Override
    public List<?> findAll() {
        List<Municipio> items = new ArrayList<>();

        try {
            items = helper.getMunicipioDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public List<Municipio> listByName(String param) {
        List<Municipio> items = new ArrayList<>();
        try {
            QueryBuilder<Municipio, UUID> queryBuilder = helper.getMunicipioDao().queryBuilder();
            queryBuilder.orderBy(Municipio.DESCRICAO, true);
            queryBuilder.where().eq(Municipio.DESCRICAO, param);
            items = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }
    
}
