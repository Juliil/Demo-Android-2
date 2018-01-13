package com.itm.mobile.dados.ormlite.controller;

import android.content.Context;

import com.itm.mobile.dados.ormlite.DatabaseHelper;
import com.itm.mobile.dados.ormlite.DatabaseManager;
import com.itm.mobile.dados.ormlite.model.Localizacao;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LocalizacaoRepo implements Crud{

    private DatabaseHelper helper;

    public LocalizacaoRepo(Context context) {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item) {
        int index = -1;

        Localizacao object = (Localizacao) item;
        try {
            index = helper.getLocalizacaoDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int update(Object item) {
        int index = -1;

        Localizacao object = (Localizacao) item;

        try {
            helper.getLocalizacaoDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int delete(Object item) {
        int index = -1;

        Localizacao object = (Localizacao) item;

        try {
            helper.getLocalizacaoDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(UUID id) {
        Localizacao Localizacao  = null;
        try {
            Localizacao = helper.getLocalizacaoDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Localizacao;
    }

    @Override
    public List<?> findAll() {
        List<Localizacao> items = new ArrayList<>();

        try {
            items = helper.getLocalizacaoDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public List<Localizacao> findByUser(UUID user_id) {
        List<Localizacao> items = new ArrayList<>();
        try {
            QueryBuilder<Localizacao, UUID> queryBuilder = helper.getLocalizacaoDao().queryBuilder();
            queryBuilder.where().eq(Localizacao.USUARIO_ID, user_id);
            items = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public List<Localizacao> listByDate(UUID user_id) {
        List<Localizacao> items = new ArrayList<>();
        try {
            QueryBuilder<Localizacao, UUID> queryBuilder = helper.getLocalizacaoDao().queryBuilder();
            queryBuilder.orderBy(Localizacao.DT_REG, true);
            queryBuilder.where().eq(Localizacao.USUARIO_ID, user_id);
            items = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }



}
