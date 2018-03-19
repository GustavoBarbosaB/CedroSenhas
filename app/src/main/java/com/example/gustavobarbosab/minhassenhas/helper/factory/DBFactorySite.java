package com.example.gustavobarbosab.minhassenhas.helper.factory;

import android.content.Context;
import android.util.Log;

import com.example.gustavobarbosab.minhassenhas.domain.Site;
import com.example.gustavobarbosab.minhassenhas.helper.db.DatabaseHelper;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by gustavobarbosab on 18/03/18.
 */

public class DBFactorySite {

    private static DBFactorySite instance;
    private DatabaseHelper helper;

    public static void init(Context ctx) {
        if (null == instance) {
            instance = new DBFactorySite(ctx);
        }
    }

    public static DBFactorySite getInstance() {
        return instance;
    }

    private DBFactorySite(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public List<Site> findAllSite() {
        List<Site> list = null;

        try {
            list = getHelper().getSiteDao().queryBuilder()
                    .orderBy("id", false).query();
        } catch (java.sql.SQLException e) {
            Log.d(this.getClass().getName(),e.getMessage());
        }

        return list;
    }

    public Site findOneSiteById(int id) {
        Site site = null;

        try {
            site = getHelper().getSiteDao().queryForId(id);
        } catch (java.sql.SQLException e) {
            Log.d(this.getClass().getName(),e.getMessage());
        }

        return site;
    }

    public void createOrUpdateSite(Site site){
        try{
            getHelper().getSiteDao().createOrUpdate(site);
        }catch (SQLException e){
            Log.d(this.getClass().getName(),e.getMessage());
        }
    }

    public void deleteSiteById(int id){
        try{
            getHelper().getSiteDao().deleteById(id);
        } catch (SQLException e) {
            Log.d(this.getClass().getName(),e.getMessage());
        }
    }

    public void deleteSite(Site site){
        try{
            getHelper().getSiteDao().delete(site);
        } catch (SQLException e) {
            Log.d(this.getClass().getName(),e.getMessage());
        }
    }

}
