package com.shoppinglist.execom.shoppinglistapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.shoppinglist.execom.shoppinglistapp.R;
import com.shoppinglist.execom.shoppinglistapp.database.dao.ShoppingListArticleDAO;
import com.shoppinglist.execom.shoppinglistapp.model.ShoppingArticle;
import com.shoppinglist.execom.shoppinglistapp.model.ShoppingListArticle;
import com.shoppinglist.execom.shoppinglistapp.reporitory.ArticleDAORepository;
import com.shoppinglist.execom.shoppinglistapp.reporitory.ShoppingListArticleDAORepository;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.IntegerRes;

@EActivity(R.layout.activity_new_article)
public class NewArticle extends AppCompatActivity {

    @Bean
    ShoppingListArticleDAORepository shoppingListArticleDAORepository;

    @Bean
    ArticleDAORepository articleDAORepository;

    @ViewById(R.id.new_article_article_name)
    EditText articleName;

    @ViewById(R.id.new_article_article_amount)
    EditText articleAmount;

    @Extra
    int listId;

    @Click(R.id.new_article_add_article)
    void addArticle(){
        if(articleName.getText().toString().equals("")){
            Toast.makeText(this,"Please type name of article",Toast.LENGTH_LONG).show();
            return;
        }
        int amount;
        try{
             amount = Integer.parseInt(articleAmount.getText().toString());
        }
        catch (NumberFormatException e) {
            Toast.makeText(this,"Amount must be integer",Toast.LENGTH_SHORT).show();
            return;
        }

        articleDAORepository.create(new ShoppingArticle(articleName.getText().toString()));
        int articleId = articleDAORepository.getIdByName(articleName.getText().toString());

        ShoppingListArticle shoppingListArticle = new ShoppingListArticle(articleId,listId,amount,false);
        shoppingListArticleDAORepository.crate(shoppingListArticle);
        Toast.makeText(this,"Article: " +articleName.getText().toString() + " s sucesfully added",Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
