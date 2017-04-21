package com.shoppinglist.execom.shoppinglistapp.reporitory;

import com.shoppinglist.execom.shoppinglistapp.database.DatabaseHelper;
import com.shoppinglist.execom.shoppinglistapp.database.dao.ShoppingArticleDAO;
import com.shoppinglist.execom.shoppinglistapp.model.ShoppingArticle;
import com.shoppinglist.execom.shoppinglistapp.utils.ConstantsDatabase;

import org.androidannotations.annotations.EBean;
import org.androidannotations.ormlite.annotations.OrmLiteDao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mihajlo on 4/13/2017.
 */
@EBean
public class ArticleDAORepository {

    @OrmLiteDao(helper = DatabaseHelper.class)
    public ShoppingArticleDAO shoppingArticleDAO;


    public void create(ShoppingArticle shoppingArticle) {
        shoppingArticleDAO.create(shoppingArticle);
    }

    public List<ShoppingArticle> findAll(){
        final List<ShoppingArticle> articles = shoppingArticleDAO.queryForAll();
        return articles;
    }

    public String getNameById(String articleId){
        try {
            ShoppingArticle shoppingArticle = shoppingArticleDAO.queryBuilder().where().eq(ConstantsDatabase.ARTICLE_ID,articleId).queryForFirst();
            if(shoppingArticle != null){
                return shoppingArticle.getName();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(int articleId){
        ShoppingArticle shoppingArticle = shoppingArticleDAO.queryForId(new Long(articleId));
        shoppingArticleDAO.delete(shoppingArticle);
    }

    public int getIdByName(String articleId){
        try {
            ShoppingArticle shoppingArticle = shoppingArticleDAO.queryBuilder().where().eq(ConstantsDatabase.ARTICLE_FIELD_NAME,articleId).queryForFirst();
            if(shoppingArticle != null){
                return shoppingArticle.getId();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public void edit(int articleID, String name){
        ShoppingArticle shoppingArticle = shoppingArticleDAO.queryForId(new Long(articleID));
        shoppingArticle.setName(name);
        shoppingArticleDAO.update(shoppingArticle);
    }
    public ShoppingArticleDAO getShoppingArticleDAO() {
        return shoppingArticleDAO;
    }

    public void setShoppingArticleDAO(ShoppingArticleDAO shoppingArticleDAO) {
        this.shoppingArticleDAO = shoppingArticleDAO;
    }
}
