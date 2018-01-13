package com.itm.mobile.dados.ormlite.controller;

import android.content.Context;

import com.itm.mobile.dados.ormlite.DatabaseHelper;
import com.itm.mobile.dados.ormlite.DatabaseManager;
import com.itm.mobile.dados.ormlite.model.MensagemDet;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MensagemDetRepo implements Crud{

    private DatabaseHelper helper;

    public MensagemDetRepo(Context context) {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item) {
        int index = -1;

        MensagemDet object = (MensagemDet) item;
        try {
            index = helper.getMensagemDetDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int update(Object item) {
        int index = -1;

        MensagemDet object = (MensagemDet) item;

        try {
            helper.getMensagemDetDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int delete(Object item) {
        int index = -1;

        MensagemDet object = (MensagemDet) item;

        try {
            helper.getMensagemDetDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(UUID id) {
        MensagemDet MensagemDet  = null;
        try {
            MensagemDet = helper.getMensagemDetDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return MensagemDet;
    }

    @Override
    public List<?> findAll() {
        List<MensagemDet> items = new ArrayList<>();

        try {
            items = helper.getMensagemDetDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public List<MensagemDet> listByCab(UUID msg_id) {
        List<MensagemDet> items = new ArrayList<>();
        try {
            QueryBuilder<MensagemDet, UUID> queryBuilder = helper.getMensagemDetDao().queryBuilder();
            queryBuilder.orderBy(MensagemDet.USUARIO_ID, true);
            queryBuilder.where().eq(MensagemDet.MENSAGEM_CAB_ID, msg_id);
            items = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }
    
}
