package com.shoppinglist.execom.shoppinglistapp.reporitory;

import com.shoppinglist.execom.shoppinglistapp.database.DatabaseHelper;
import com.shoppinglist.execom.shoppinglistapp.database.dao.ShoppingListDAO;
import com.shoppinglist.execom.shoppinglistapp.model.ShoppingList;

import org.androidannotations.annotations.EBean;
import org.androidannotations.ormlite.annotations.OrmLiteDao;

import java.util.List;

/**
 * Created by mihajlo on 4/15/2017.
 */
@EBean
public class ShoppingListDAORespository {

    @OrmLiteDao(helper = DatabaseHelper.class)
    public ShoppingListDAO shoppingListDAO;

    public void create(ShoppingList shoppingList) {
        shoppingListDAO.create(shoppingList);
    }


    public List<ShoppingList> findAll(){
        final List<ShoppingList> items = shoppingListDAO.queryForAll();
        return items;
    }

    public void setCompleted(int listId){
        ShoppingList shoppingList = shoppingListDAO.queryForId(new Long(listId));
        shoppingList.setCompleted(true);
        shoppingListDAO.update(shoppingList);
    }

    public void delete(int listId){
        ShoppingList shoppingList = shoppingListDAO.queryForId(new Long(listId));
        //shoppingList.setCompleted(true);
        shoppingListDAO.delete(shoppingList);
    }

    public ShoppingListDAO getShoppingListDAO() {
        return shoppingListDAO;
    }

    public void setShoppingListDAO(ShoppingListDAO shoppingListDAO) {
        this.shoppingListDAO = shoppingListDAO;
    }
}
