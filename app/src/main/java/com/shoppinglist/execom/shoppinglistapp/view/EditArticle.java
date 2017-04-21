package com.shoppinglist.execom.shoppinglistapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.shoppinglist.execom.shoppinglistapp.R;
import com.shoppinglist.execom.shoppinglistapp.model.ShoppingArticle;
import com.shoppinglist.execom.shoppinglistapp.model.ShoppingListArticle;
import com.shoppinglist.execom.shoppinglistapp.reporitory.ArticleDAORepository;
import com.shoppinglist.execom.shoppinglistapp.reporitory.ShoppingListArticleDAORepository;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_edit_article)
public class EditArticle extends AppCompatActivity {

    @Bean
    ShoppingListArticleDAORepository shoppingListArticleDAORepository;

    @Bean
    ArticleDAORepository articleDAORepository;

    @ViewById(R.id.edit_article_name)
    EditText articleName;

    @ViewById(R.id.edit_article_amount)
    EditText articleAmount;

    @Extra
    int shoppingArticle;

    @Click(R.id.edit_delete_article)
    void delete(){
        shoppingListArticleDAORepository.delete(shoppingArticle);
        Toast.makeText(this,"Article deleted from list",Toast.LENGTH_LONG).show();
        finish();
    }

    @Click(R.id.edit_complete_article)
    void complete(){
        shoppingListArticleDAORepository.setCompleted(shoppingArticle);
        Toast.makeText(this,"Completed status changed",Toast.LENGTH_LONG).show();
        finish();
    }

    @AfterViews
    void setView(){
        String myArticleId = Integer.toString(shoppingListArticleDAORepository.getById(shoppingArticle).getId());
        String myAmount = Integer.toString(shoppingListArticleDAORepository.getById(shoppingArticle).getAmount());
        articleName.setText(articleDAORepository.getNameById(myArticleId));
        articleAmount.setText(myAmount);
    }

    @Click(R.id.edit_submit_article)
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
        shoppingListArticleDAORepository.edit(shoppingArticle,articleAmount.getText().toString());
        int editArticle = shoppingListArticleDAORepository.getById(shoppingArticle).getArticleId();
        articleDAORepository.edit(editArticle,articleName.getText().toString());
        Toast.makeText(this,"Article: " +articleName.getText().toString() + " sucesfully edited",Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
