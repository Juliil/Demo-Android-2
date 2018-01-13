package com.itm.mobile.dados.ormlite.controller;

import android.content.Context;

import com.itm.mobile.dados.ormlite.DatabaseHelper;
import com.itm.mobile.dados.ormlite.DatabaseManager;
import com.itm.mobile.dados.ormlite.model.ZonaEleitoral;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ZonaEleitoralRepo implements Crud{

    private DatabaseHelper helper;

    public ZonaEleitoralRepo(Context context) {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item) {
        int index = -1;

        ZonaEleitoral object = (ZonaEleitoral) item;
        try {
            index = helper.getZonaEleitoralDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int update(Object item) {
        int index = -1;

        ZonaEleitoral object = (ZonaEleitoral) item;

        try {
            helper.getZonaEleitoralDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int delete(Object item) {
        int index = -1;

        ZonaEleitoral object = (ZonaEleitoral) item;

        try {
            helper.getZonaEleitoralDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(UUID id) {
        ZonaEleitoral ZonaEleitoral  = null;
        try {
            ZonaEleitoral = helper.getZonaEleitoralDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ZonaEleitoral;
    }

    @Override
    public List<?> findAll() {
        List<ZonaEleitoral> items = new ArrayList<>();

        try {
            items = helper.getZonaEleitoralDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public List<ZonaEleitoral> findByCodTre(int param) {
        List<ZonaEleitoral> items = new ArrayList<>();
        try {
            QueryBuilder<ZonaEleitoral, UUID> queryBuilder = helper.getZonaEleitoralDao().queryBuilder();
            queryBuilder.orderBy(ZonaEleitoral.COD_TRE, true);
            queryBuilder.where().like(ZonaEleitoral.COD_TRE, param);
            items = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public List<ZonaEleitoral> findByMunicipio(UUID param) {
        List<ZonaEleitoral> items = new ArrayList<>();
        try {
            QueryBuilder<ZonaEleitoral, UUID> queryBuilder = helper.getZonaEleitoralDao().queryBuilder();
            queryBuilder.orderBy(ZonaEleitoral.COD_TRE, true);
            queryBuilder.where().like(ZonaEleitoral.MUNICIPIO_ID, param);
            items = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }
    
}
