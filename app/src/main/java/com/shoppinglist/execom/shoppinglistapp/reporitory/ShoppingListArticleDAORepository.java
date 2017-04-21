package com.shoppinglist.execom.shoppinglistapp.reporitory;

import com.shoppinglist.execom.shoppinglistapp.database.DatabaseHelper;
import com.shoppinglist.execom.shoppinglistapp.database.dao.ShoppingArticleDAO;
import com.shoppinglist.execom.shoppinglistapp.database.dao.ShoppingListArticleDAO;
import com.shoppinglist.execom.shoppinglistapp.model.ShoppingArticle;
import com.shoppinglist.execom.shoppinglistapp.model.ShoppingList;
import com.shoppinglist.execom.shoppinglistapp.model.ShoppingListArticle;
import com.shoppinglist.execom.shoppinglistapp.utils.ConstantsDatabase;

import org.androidannotations.annotations.EBean;
import org.androidannotations.ormlite.annotations.OrmLiteDao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mihajlo on 4/16/2017.
 */
@EBean
public class ShoppingListArticleDAORepository {

    @OrmLiteDao(helper = DatabaseHelper.class)
    public ShoppingListArticleDAO shoppingListArticleDAO;



    public void crate(ShoppingListArticle shoppingListArticle){
        shoppingListArticleDAO.create(shoppingListArticle);
    }

    public List<ShoppingListArticle> findAll(int listId){
        try {
            return shoppingListArticleDAO.queryBuilder().where().eq(ConstantsDatabase.ARTICLE_LIST_ID,listId).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<ShoppingListArticle> findAll(){
        return shoppingListArticleDAO.queryForAll();
    }

    public ShoppingListArticle getById(int id){
        return shoppingListArticleDAO.queryForId(new Long(id));
    }

    public void edit(int articleId,String amount){
        ShoppingListArticle shoppingListArticle = shoppingListArticleDAO.queryForId(new Long(articleId));
        shoppingListArticle.setAmount(Integer.parseInt(amount));
        shoppingListArticleDAO.update(shoppingListArticle);
    }

    public void setCompltedByListId(int id) {
        List<ShoppingListArticle> items = null;
        try {
            items = shoppingListArticleDAO.queryBuilder().where().eq(ConstantsDatabase.ARTICLE_LIST_ID,id).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(ShoppingListArticle shoppingListArticle : items){
            shoppingListArticle.setCompleted(true);
            shoppingListArticleDAO.update(shoppingListArticle);
        }
    }

    public void setCompleted(int id){
        ShoppingListArticle shoppingListArticle = shoppingListArticleDAO.queryForId(new Long(id));
        shoppingListArticle.setCompleted(true);
        shoppingListArticleDAO.update(shoppingListArticle);
    }
    public void delete(int id){
        ShoppingListArticle shoppingListArticle = shoppingListArticleDAO.queryForId(new Long(id));
        shoppingListArticleDAO.delete(shoppingListArticle);
    }

    public ShoppingListArticleDAO getShoppingListArticleDAO() {
        return shoppingListArticleDAO;
    }

    public void setShoppingListArticleDAO(ShoppingListArticleDAO shoppingListArticleDAO) {
        this.shoppingListArticleDAO = shoppingListArticleDAO;
    }

}
