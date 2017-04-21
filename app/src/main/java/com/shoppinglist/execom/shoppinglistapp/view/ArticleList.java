package com.shoppinglist.execom.shoppinglistapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.shoppinglist.execom.shoppinglistapp.R;
import com.shoppinglist.execom.shoppinglistapp.adapter.ShoppingListArticleAdapter;
import com.shoppinglist.execom.shoppinglistapp.model.ShoppingArticle;
import com.shoppinglist.execom.shoppinglistapp.model.ShoppingListArticle;
import com.shoppinglist.execom.shoppinglistapp.reporitory.ShoppingListArticleDAORepository;
import com.shoppinglist.execom.shoppinglistapp.reporitory.ShoppingListDAORespository;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

@EActivity(R.layout.activity_article_list)
public class ArticleList extends AppCompatActivity {

    @Extra
    int thisListId;

    @Bean
    ShoppingListArticleAdapter shoppingListArticleAdapter;

    @Bean
    ShoppingListArticleDAORepository shoppingListArticleDAORepository;

    @Bean
    ShoppingListDAORespository shoppingListDAORespository;

    @ViewById(R.id.article_list_view)
    ListView listView;

    @AfterViews
    @UiThread
    void setAdapter(){
        ArrayList<ShoppingListArticle> articles = new ArrayList<ShoppingListArticle>(shoppingListArticleDAORepository.findAll(thisListId));
        ArrayList<ShoppingListArticle> sortedArticles = new ArrayList<ShoppingListArticle>();
        for (ShoppingListArticle i : articles){
            if(i.isCompleted()){
                sortedArticles.add(i);
            }else{
                sortedArticles.add(0,i);
            }
        }
        shoppingListArticleAdapter.setItems(sortedArticles);
        listView.setAdapter(shoppingListArticleAdapter);
    }

    @Click(R.id.article_add_article)
    void addArticle(){
        NewArticle_.intent(this).listId(thisListId).startForResult(0);
    }

    @Click(R.id.article_list_complete)
    void markCompleted(){
        shoppingListDAORespository.setCompleted(thisListId);
        shoppingListArticleDAORepository.setCompltedByListId(thisListId);
        Toast.makeText(this,"List marked as completed",Toast.LENGTH_LONG).show();
        finish();
    }
    @Click(R.id.article_delete_list)
    void delete(){
        shoppingListDAORespository.delete(thisListId);
        Toast.makeText(this,"List has been deleted",Toast.LENGTH_LONG).show();
        finish();
    }

    @ItemClick(R.id.article_list_view)
    void itemClick(int position){
        ShoppingListArticle shoppingListArticle = (ShoppingListArticle) shoppingListArticleAdapter.getItem(position);
        EditArticle_.intent(this).shoppingArticle(shoppingListArticle.getId()).startForResult(0);
    }
    @OnActivityResult(0)
    void onFinish(){
        setAdapter();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
