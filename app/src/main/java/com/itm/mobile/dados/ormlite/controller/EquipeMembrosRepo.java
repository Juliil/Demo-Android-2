package com.itm.mobile.dados.ormlite.controller;

import android.content.Context;

import com.itm.mobile.dados.ormlite.DatabaseHelper;
import com.itm.mobile.dados.ormlite.DatabaseManager;
import com.itm.mobile.dados.ormlite.model.EquipeMembros;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EquipeMembrosRepo implements Crud{

    private DatabaseHelper helper;

    public EquipeMembrosRepo(Context context) {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item) {
        int index = -1;

        EquipeMembros object = (EquipeMembros) item;
        try {
            index = helper.getEquipeMembrosDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int update(Object item) {
        int index = -1;

        EquipeMembros object = (EquipeMembros) item;

        try {
            helper.getEquipeMembrosDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int delete(Object item) {
        int index = -1;

        EquipeMembros object = (EquipeMembros) item;

        try {
            helper.getEquipeMembrosDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(UUID id) {
        EquipeMembros EquipeMembros  = null;
        try {
            EquipeMembros = helper.getEquipeMembrosDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return EquipeMembros;
    }

    @Override
    public List<?> findAll() {
        List<EquipeMembros> items = new ArrayList<>();

        try {
            items = helper.getEquipeMembrosDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public List<EquipeMembros> findByEquipe(UUID equipe_id) {
        List<EquipeMembros> items = new ArrayList<>();
        try {
            QueryBuilder<EquipeMembros, UUID> queryBuilder = helper.getEquipeMembrosDao().queryBuilder();
            queryBuilder.where().eq(EquipeMembros.EQUIPE_ID, equipe_id);
            items = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

}
