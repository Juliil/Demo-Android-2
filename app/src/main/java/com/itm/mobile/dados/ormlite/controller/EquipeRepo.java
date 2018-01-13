package com.itm.mobile.dados.ormlite.controller;

import android.content.Context;

import com.itm.mobile.dados.ormlite.DatabaseHelper;
import com.itm.mobile.dados.ormlite.DatabaseManager;
import com.itm.mobile.dados.ormlite.model.Equipe;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EquipeRepo implements Crud{

    private DatabaseHelper helper;

    public EquipeRepo(Context context) {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item) {
        int index = -1;

        Equipe object = (Equipe) item;
        try {
            index = helper.getEquipeDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int update(Object item) {
        int index = -1;

        Equipe object = (Equipe) item;

        try {
            helper.getEquipeDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int delete(Object item) {
        int index = -1;

        Equipe object = (Equipe) item;

        try {
            helper.getEquipeDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(UUID id) {
        Equipe Equipe  = null;
        try {
            Equipe = helper.getEquipeDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Equipe;
    }

    @Override
    public List<?> findAll() {
        List<Equipe> items = new ArrayList<>();

        try {
            items = helper.getEquipeDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public List<Equipe> findByCordenador(UUID user_id) {
        List<Equipe> items = new ArrayList<>();
        try {
            QueryBuilder<Equipe, UUID> queryBuilder = helper.getEquipeDao().queryBuilder();
            queryBuilder.where().eq(Equipe.USUARIO_ID, user_id);
            items = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

}
