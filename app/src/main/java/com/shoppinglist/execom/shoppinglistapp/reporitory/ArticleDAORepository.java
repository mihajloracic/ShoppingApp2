package com.shoppinglist.execom.shoppinglistapp.reporitory;

import com.shoppinglist.execom.shoppinglistapp.database.DatabaseHelper;
import com.shoppinglist.execom.shoppinglistapp.database.dao.ShoppingArticleDAO;
import com.shoppinglist.execom.shoppinglistapp.model.ShoppingArticle;
import com.shoppinglist.execom.shoppinglistapp.utils.Preferences_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.sharedpreferences.Pref;
import org.androidannotations.ormlite.annotations.OrmLiteDao;

import java.util.List;

/**
 * Created by mihajlo on 4/13/2017.
 */
@EBean
public class ArticleDAORepository {

    @Pref
    Preferences_ preferences;


    @OrmLiteDao(helper = DatabaseHelper.class)
    ShoppingArticleDAO shoppingArticleDAO;


    public void create(ShoppingArticle shoppingArticle) {
        shoppingArticleDAO.create(shoppingArticle);
        preferences.id().put(shoppingArticle.getId());
    }
    public List<ShoppingArticle> findAll(){
        final List<ShoppingArticle> articles = shoppingArticleDAO.queryForAll();
        return articles;
    }
}
