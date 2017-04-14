package com.shoppinglist.execom.shoppinglistapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.shoppinglist.execom.shoppinglistapp.model.ShoppingArticle;

import java.sql.SQLException;

/**
 * Created by mihajlo on 4/13/2017.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

   private static final String TAG = DatabaseHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "shoppinglist.db";

    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, ShoppingArticle.class);
        } catch (SQLException e) {
            Log.e(TAG,e.getMessage(),e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource,ShoppingArticle.class,true);
        } catch (SQLException e) {
            Log.e(TAG,e.getMessage(),e);
        }
    }

}
