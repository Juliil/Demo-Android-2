package com.itm.mobile.dados.ormlite.controller;

import android.content.Context;

import com.itm.mobile.dados.ormlite.DatabaseHelper;
import com.itm.mobile.dados.ormlite.DatabaseManager;
import com.itm.mobile.dados.ormlite.model.SecaoEleitoral;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SecaoEleitoralRepo implements Crud{

    private DatabaseHelper helper;

    public SecaoEleitoralRepo(Context context) {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item) {
        int index = -1;

        SecaoEleitoral object = (SecaoEleitoral) item;
        try {
            index = helper.getSecaoEleitoralDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int update(Object item) {
        int index = -1;

        SecaoEleitoral object = (SecaoEleitoral) item;

        try {
            helper.getSecaoEleitoralDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int delete(Object item) {
        int index = -1;

        SecaoEleitoral object = (SecaoEleitoral) item;

        try {
            helper.getSecaoEleitoralDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(UUID id) {
        SecaoEleitoral SecaoEleitoral  = null;
        try {
            SecaoEleitoral = helper.getSecaoEleitoralDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return SecaoEleitoral;
    }

    @Override
    public List<?> findAll() {
        List<SecaoEleitoral> items = new ArrayList<>();

        try {
            items = helper.getSecaoEleitoralDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public List<SecaoEleitoral> findByCodTre(int param) {
        List<SecaoEleitoral> items = new ArrayList<>();
        try {
            QueryBuilder<SecaoEleitoral, UUID> queryBuilder = helper.getSecaoEleitoralDao().queryBuilder();
            queryBuilder.orderBy(SecaoEleitoral.COD_TRE, true);
            queryBuilder.where().like(SecaoEleitoral.COD_TRE, param);
            items = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public List<SecaoEleitoral> listByZona(UUID param) {
        List<SecaoEleitoral> items = new ArrayList<>();
        try {
            QueryBuilder<SecaoEleitoral, UUID> queryBuilder = helper.getSecaoEleitoralDao().queryBuilder();
            queryBuilder.orderBy(SecaoEleitoral.COD_TRE, true);
            queryBuilder.where().eq(SecaoEleitoral.ZONAELEITORAL_ID, param);
            items = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public List<SecaoEleitoral> listByLocal(UUID param) {
        List<SecaoEleitoral> items = new ArrayList<>();
        try {
            QueryBuilder<SecaoEleitoral, UUID> queryBuilder = helper.getSecaoEleitoralDao().queryBuilder();
            queryBuilder.orderBy(SecaoEleitoral.COD_TRE, true);
            queryBuilder.where().eq(SecaoEleitoral.LOCALVOTACAO_ID, param);
            items = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }
    
}
