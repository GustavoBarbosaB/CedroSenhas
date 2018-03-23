package com.example.gustavobarbosab.minhassenhas.helper;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.gustavobarbosab.minhassenhas.domain.Site;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gustavobarbosab on 18/03/18.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String dataBaseName = "cedroSenhas.sqlite";

    private static final int dataBaseVersion = 2;

    private Dao<Site, Integer> siteDao = null;

    public DatabaseHelper(Context context) {
        super(context, dataBaseName, null, dataBaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Site.class);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "exception during onCreate ",
                    e);        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            List<String> allSql = new ArrayList<>();
            switch (oldVersion) {
                case 1:
                // allSql.add("alter table AdData add column `new_col` VARCHAR");
                // allSql.add("alter table AdData add column `new_col2` VARCHAR");
            }
            for (String sql : allSql) {
                database.execSQL(sql);
            }
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "exception during onUpgrade  ",
                    e);
            throw new RuntimeException(e);
        }
    }

    public Dao<Site, Integer> getSiteDao() {
        if (null == siteDao) {
            try {
                siteDao = getDao(Site.class);
            } catch (java.sql.SQLException e) {
                Log.e(DatabaseHelper.class.getName(), "exception during getSiteDao ",
                        e);            }
        }
        return siteDao;
    }
}

