package com.itm.mobile.dados.ormlite.controller;

import android.content.Context;

import com.itm.mobile.dados.ormlite.DatabaseHelper;
import com.itm.mobile.dados.ormlite.DatabaseManager;
import com.itm.mobile.dados.ormlite.model.LocalVotacao;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LocalVotacaoRepo implements Crud{

    private DatabaseHelper helper;

    public LocalVotacaoRepo(Context context) {
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item) {
        int index = -1;

        LocalVotacao object = (LocalVotacao) item;
        try {
            index = helper.getLocalVotacaoDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int update(Object item) {
        int index = -1;

        LocalVotacao object = (LocalVotacao) item;

        try {
            helper.getLocalVotacaoDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int delete(Object item) {
        int index = -1;

        LocalVotacao object = (LocalVotacao) item;

        try {
            helper.getLocalVotacaoDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(UUID id) {
        LocalVotacao LocalVotacao  = null;
        try {
            LocalVotacao = helper.getLocalVotacaoDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return LocalVotacao;
    }

    @Override
    public List<?> findAll() {
        List<LocalVotacao> items = new ArrayList<>();

        try {
            items = helper.getLocalVotacaoDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public List<LocalVotacao> findByCodTre(int cod_tre) {
        List<LocalVotacao> items = new ArrayList<>();
        try {
            QueryBuilder<LocalVotacao, UUID> queryBuilder = helper.getLocalVotacaoDao().queryBuilder();
            queryBuilder.where().eq(LocalVotacao.COD_TRE, cod_tre);
            items = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public List<LocalVotacao> listByNome(String nome) {
        List<LocalVotacao> items = new ArrayList<>();
        try {
            QueryBuilder<LocalVotacao, UUID> queryBuilder = helper.getLocalVotacaoDao().queryBuilder();
            queryBuilder.orderBy(LocalVotacao.NOME, true);
            queryBuilder.where().like(LocalVotacao.NOME, nome);
            items = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public List<LocalVotacao> listByEnd(String end) {
        List<LocalVotacao> items = new ArrayList<>();
        try {
            QueryBuilder<LocalVotacao, UUID> queryBuilder = helper.getLocalVotacaoDao().queryBuilder();
            queryBuilder.orderBy(LocalVotacao.NOME, true);
            queryBuilder.where().like(LocalVotacao.ENDERECO, end);
            items = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public List<LocalVotacao> listByBairro(String bairro) {
        List<LocalVotacao> items = new ArrayList<>();
        try {
            QueryBuilder<LocalVotacao, UUID> queryBuilder = helper.getLocalVotacaoDao().queryBuilder();
            queryBuilder.orderBy(LocalVotacao.NOME, true);
            queryBuilder.where().like(LocalVotacao.BAIRRO, bairro);
            items = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

}
