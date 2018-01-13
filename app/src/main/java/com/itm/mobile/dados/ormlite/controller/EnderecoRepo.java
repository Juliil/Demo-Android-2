package com.itm.mobile.dados.ormlite.controller;

import android.content.Context;

import com.itm.mobile.dados.ormlite.DatabaseHelper;
import com.itm.mobile.dados.ormlite.DatabaseManager;
import com.itm.mobile.dados.ormlite.model.Endereco;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EnderecoRepo implements Crud{

    private DatabaseHelper helper;

    public EnderecoRepo(Context context) {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item) {
        int index = -1;

        Endereco object = (Endereco) item;
        try {
            index = helper.getEnderecoDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int update(Object item) {
        int index = -1;

        Endereco object = (Endereco) item;

        try {
            helper.getEnderecoDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int delete(Object item) {
        int index = -1;

        Endereco object = (Endereco) item;

        try {
            helper.getEnderecoDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(UUID id) {
        Endereco Endereco  = null;
        try {
            Endereco = helper.getEnderecoDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Endereco;
    }

    @Override
    public List<?> findAll() {
        List<Endereco> items = new ArrayList<>();

        try {
            items = helper.getEnderecoDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public List<Endereco> findByBairro(String nome) {
        List<Endereco> items = new ArrayList<>();
        try {
            QueryBuilder<Endereco, UUID> queryBuilder = helper.getEnderecoDao().queryBuilder();
            queryBuilder.where().eq(Endereco.BAIRRO, nome);
            items = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

}
