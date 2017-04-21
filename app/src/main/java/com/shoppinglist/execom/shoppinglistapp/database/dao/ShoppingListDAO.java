package com.shoppinglist.execom.shoppinglistapp.database.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.shoppinglist.execom.shoppinglistapp.model.ShoppingList;

/**
 * Created by mihajlo on 4/15/2017.
 */

public class ShoppingListDAO extends RuntimeExceptionDao<ShoppingList, Long> {
    public ShoppingListDAO(Dao<ShoppingList, Long> dao) {
        super(dao);
    }
}
