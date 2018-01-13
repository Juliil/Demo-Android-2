package com.itm.mobile.dados.ormlite.controller;

import android.content.Context;

import com.itm.mobile.dados.ormlite.DatabaseHelper;
import com.itm.mobile.dados.ormlite.DatabaseManager;
import com.itm.mobile.dados.ormlite.model.UsuarioAtividade;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UsuarioAtividadeRepo implements Crud{

    private DatabaseHelper helper;

    public UsuarioAtividadeRepo(Context context) {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item) {
        int index = -1;

        UsuarioAtividade object = (UsuarioAtividade) item;
        try {
            index = helper.getUsuarioAtividadeDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int update(Object item) {
        int index = -1;

        UsuarioAtividade object = (UsuarioAtividade) item;

        try {
            helper.getUsuarioAtividadeDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int delete(Object item) {
        int index = -1;

        UsuarioAtividade object = (UsuarioAtividade) item;

        try {
            helper.getUsuarioAtividadeDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(UUID id) {
        UsuarioAtividade UsuarioAtividade  = null;
        try {
            UsuarioAtividade = helper.getUsuarioAtividadeDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return UsuarioAtividade;
    }

    @Override
    public List<?> findAll() {
        List<UsuarioAtividade> items = new ArrayList<>();

        try {
            items = helper.getUsuarioAtividadeDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public List<UsuarioAtividade> findByUser(UUID param) {
        List<UsuarioAtividade> items = new ArrayList<>();
        try {
            QueryBuilder<UsuarioAtividade, UUID> queryBuilder = helper.getUsuarioAtividadeDao().queryBuilder();
            queryBuilder.orderBy(UsuarioAtividade.DT_REG, true);
            queryBuilder.where().like(UsuarioAtividade.USUARIO_ID, param);
            items = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

}
