package com.shoppinglist.execom.shoppinglistapp.database.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.shoppinglist.execom.shoppinglistapp.model.ShoppingListArticle;

/**
 * Created by mihajlo on 4/16/2017.
 */

public class ShoppingListArticleDAO extends RuntimeExceptionDao<ShoppingListArticle, Long> {
    public ShoppingListArticleDAO(Dao<ShoppingListArticle, Long> dao) {
        super(dao);
    }
}
