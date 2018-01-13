package com.itm.mobile.dados.ormlite.controller;

import android.content.Context;

import com.itm.mobile.dados.ormlite.DatabaseHelper;
import com.itm.mobile.dados.ormlite.DatabaseManager;
import com.itm.mobile.dados.ormlite.model.ZonadeAtuacao;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ZonaAtuacaoRepo implements Crud{

    private DatabaseHelper helper;

    public ZonaAtuacaoRepo(Context context) {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item) {
        int index = -1;

        ZonadeAtuacao object = (ZonadeAtuacao) item;
        try {
            index = helper.getZonadeAtuacaoDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int update(Object item) {
        int index = -1;

        ZonadeAtuacao object = (ZonadeAtuacao) item;

        try {
            helper.getZonadeAtuacaoDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int delete(Object item) {
        int index = -1;

        ZonadeAtuacao object = (ZonadeAtuacao) item;

        try {
            helper.getZonadeAtuacaoDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(UUID id) {
        ZonadeAtuacao ZonadeAtuacao  = null;
        try {
            ZonadeAtuacao = helper.getZonadeAtuacaoDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ZonadeAtuacao;
    }

    @Override
    public List<?> findAll() {
        List<ZonadeAtuacao> items = new ArrayList<>();

        try {
            items = helper.getZonadeAtuacaoDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public List<ZonadeAtuacao> findByEquipe(UUID param) {
        List<ZonadeAtuacao> items = new ArrayList<>();
        try {
            QueryBuilder<ZonadeAtuacao, UUID> queryBuilder = helper.getZonadeAtuacaoDao().queryBuilder();
            queryBuilder.orderBy(ZonadeAtuacao.SECAOELEITORAL_ID, true);
            queryBuilder.where().like(ZonadeAtuacao.EQUIPE_ID, param);
            items = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public List<ZonadeAtuacao> findBySecao(UUID param) {
        List<ZonadeAtuacao> items = new ArrayList<>();
        try {
            QueryBuilder<ZonadeAtuacao, UUID> queryBuilder = helper.getZonadeAtuacaoDao().queryBuilder();
            queryBuilder.orderBy(ZonadeAtuacao.EQUIPE_ID, true);
            queryBuilder.where().like(ZonadeAtuacao.SECAOELEITORAL_ID, param);
            items = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }
    
}
