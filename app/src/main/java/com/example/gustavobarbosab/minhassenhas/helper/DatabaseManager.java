package com.example.gustavobarbosab.minhassenhas.helper;

import android.content.Context;
import android.util.Log;

import com.example.gustavobarbosab.minhassenhas.domain.Site;

import java.util.List;

/**
 * Created by gustavobarbosab on 18/03/18.
 */

public class DatabaseManager {
    private static DatabaseManager instance;
    private DatabaseHelper helper;

    public static void init(Context ctx) {
        if (null == instance) {
            instance = new DatabaseManager(ctx);
        }
    }

    public static DatabaseManager getInstance() {
        return instance;
    }

    private DatabaseManager(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public List<Site> findAllBook() {
        List<Site> list = null;

        try {
            list = getHelper().getSiteDao().queryBuilder()
                    .orderBy("id", false).query();
        } catch (java.sql.SQLException e) {
            Log.d(this.getClass().getName(),e.getMessage());
        }

        return list;
    }
}
