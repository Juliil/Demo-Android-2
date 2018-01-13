package com.itm.mobile.dados.ormlite.controller;

import android.content.Context;

import com.itm.mobile.dados.ormlite.DatabaseHelper;
import com.itm.mobile.dados.ormlite.DatabaseManager;
import com.itm.mobile.dados.ormlite.model.MensagemCab;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MensagemCabRepo implements Crud{

    private DatabaseHelper helper;

    public MensagemCabRepo(Context context) {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item) {
        int index = -1;

        MensagemCab object = (MensagemCab) item;
        try {
            index = helper.getMensagemCabDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int update(Object item) {
        int index = -1;

        MensagemCab object = (MensagemCab) item;

        try {
            helper.getMensagemCabDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int delete(Object item) {
        int index = -1;

        MensagemCab object = (MensagemCab) item;

        try {
            helper.getMensagemCabDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(UUID id) {
        MensagemCab MensagemCab  = null;
        try {
            MensagemCab = helper.getMensagemCabDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return MensagemCab;
    }

    @Override
    public List<?> findAll() {
        List<MensagemCab> items = new ArrayList<>();

        try {
            items = helper.getMensagemCabDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public List<MensagemCab> listByDate(UUID user_id) {
        List<MensagemCab> items = new ArrayList<>();
        try {
            QueryBuilder<MensagemCab, UUID> queryBuilder = helper.getMensagemCabDao().queryBuilder();
            queryBuilder.orderBy(MensagemCab.DT_REG, true);
            queryBuilder.where().eq(MensagemCab.USUARIO_ID, user_id);
            items = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

}
