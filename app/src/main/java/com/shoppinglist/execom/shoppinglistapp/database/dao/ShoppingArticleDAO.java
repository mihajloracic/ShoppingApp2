package com.shoppinglist.execom.shoppinglistapp.database.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.shoppinglist.execom.shoppinglistapp.model.ShoppingArticle;

/**
 * Created by mihajlo on 4/13/2017.
 */

public class ShoppingArticleDAO extends RuntimeExceptionDao<ShoppingArticle,Long> {

    public ShoppingArticleDAO(Dao<ShoppingArticle, Long> dao) {
        super(dao);
    }
}
