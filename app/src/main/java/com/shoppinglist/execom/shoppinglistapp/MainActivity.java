package com.shoppinglist.execom.shoppinglistapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.shoppinglist.execom.shoppinglistapp.adapter.ShoppingArticleListAdapter;
import com.shoppinglist.execom.shoppinglistapp.database.DatabaseHelper;
import com.shoppinglist.execom.shoppinglistapp.database.dao.ShoppingArticleDAO;
import com.shoppinglist.execom.shoppinglistapp.model.ShoppingArticle;
import com.shoppinglist.execom.shoppinglistapp.reporitory.ArticleDAORepository;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.ViewById;
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



    @OrmLiteDao(helper = DatabaseHelper.class)
    ShoppingArticleDAO shoppingArticleDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Click(R.id.add_article)
    void addArticleClicked(){
        //NewArticle_.intent(this).startForResult(0);
    }


    @AfterViews
    void setActivity(){
        setupAdapter();
    }

    @OnActivityResult(0)
    void refreshListView(){
        setupAdapter();
    }

    @ItemClick(R.id.list_shopping_list)
    void itemClick(int position){
        ShoppingArticle shoppingArticle = (ShoppingArticle) shoppingListAdapter.getItem(position);
        Toast.makeText(this,shoppingArticle.getName().toString() , Toast.LENGTH_LONG).show();
    }

    void setupAdapter(){
        shoppingItemsList = new ArrayList<>(articleDAORepository.findAll());
        shoppingListAdapter.setItems(shoppingItemsList);
        shoppListView.setAdapter(shoppingListAdapter);

    }

    public Button getNewArticle() {
        return newArticle;
    }

    public void setNewArticle(Button newArticle) {
        this.newArticle = newArticle;
    }

    public ShoppingArticleListAdapter getShoppingListAdapter() {
        return shoppingListAdapter;
    }

    public void setShoppingListAdapter(ShoppingArticleListAdapter shoppingListAdapter) {
        this.shoppingListAdapter = shoppingListAdapter;
    }

    public ListView getShoppListView() {
        return shoppListView;
    }

    public void setShoppListView(ListView shoppListView) {
        this.shoppListView = shoppListView;
    }

    public ArticleDAORepository getArticleDAORepository() {
        return articleDAORepository;
    }

    public void setArticleDAORepository(ArticleDAORepository articleDAORepository) {
        this.articleDAORepository = articleDAORepository;
    }

    public ArrayList<ShoppingArticle> getShoppingItemsList() {
        return shoppingItemsList;
    }

    public void setShoppingItemsList(ArrayList<ShoppingArticle> shoppingItemsList) {
        this.shoppingItemsList = shoppingItemsList;
    }

    public ShoppingArticleDAO getShoppingArticleDAO() {
        return shoppingArticleDAO;
    }

    public void setShoppingArticleDAO(ShoppingArticleDAO shoppingArticleDAO) {
        this.shoppingArticleDAO = shoppingArticleDAO;
    }
}
