package com.shoppinglist.execom.shoppinglistapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

import com.shoppinglist.execom.shoppinglistapp.adapter.ShoppingArticleListAdapter;
import com.shoppinglist.execom.shoppinglistapp.database.DatabaseHelper;
import com.shoppinglist.execom.shoppinglistapp.database.dao.ShoppingArticleDAO;
import com.shoppinglist.execom.shoppinglistapp.model.ShoppingArticle;
import com.shoppinglist.execom.shoppinglistapp.reporitory.ArticleDAORepository;
import com.shoppinglist.execom.shoppinglistapp.utils.Preferences_;
import com.shoppinglist.execom.shoppinglistapp.view.NewArticle_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;
import org.androidannotations.ormlite.annotations.OrmLiteDao;

import java.util.ArrayList;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.add_article)
    Button newArticle;

    @Bean
    ShoppingArticleListAdapter shoppingListAdapter;

    @ViewById(R.id.list_shopping_list)
    ListView shoppListView;

    @Bean
    ArticleDAORepository articleDAORepository;

    ArrayList<ShoppingArticle> shoppingItemsList;

    @Pref
    Preferences_ prefs;

    @OrmLiteDao(helper = DatabaseHelper.class)
    ShoppingArticleDAO shoppingArticleDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Click(R.id.add_article)
    void addArticleClicked(){
        NewArticle_.intent(this).start();
    }

    @AfterViews
    void setActivity(){
        setupAdapter();
    }

    void setupAdapter(){
        shoppingItemsList = new ArrayList<>(articleDAORepository.findAll());
        shoppingListAdapter.setItems(shoppingItemsList);
        shoppListView.setAdapter(shoppingListAdapter);
    }

}
