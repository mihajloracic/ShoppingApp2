package com.shoppinglist.execom.shoppinglistapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.shoppinglist.execom.shoppinglistapp.R;
import com.shoppinglist.execom.shoppinglistapp.adapter.ShoppingArticleListAdapter;
import com.shoppinglist.execom.shoppinglistapp.model.ShoppingArticle;
import com.shoppinglist.execom.shoppinglistapp.reporitory.ArticleDAORepository;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_new_article)
public class NewArticle extends AppCompatActivity {

    @Bean
    ArticleDAORepository articleDAORepository;

    @ViewById(R.id.article_name)
    EditText articleName;

    @Bean
    ShoppingArticleListAdapter shoppingArticleListAdapter;

    @Click(R.id.add_article)
    void addArticle(){
        Log.e("TEXT FROM articleName: ", articleName.getText().toString());
        String text = articleName.getText().toString();
        if(text.equals("")){
            int a = 5;
        }
        if(!text.equals("")){
            articleDAORepository.create(new ShoppingArticle(text));
            Toast.makeText(this, "Article " + text + "was creted", Toast.LENGTH_LONG).show();
            shoppingArticleListAdapter.notifyDataSetChanged();
            finish();
        }else{
            Toast.makeText(this,"Article name can't be empty" , Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_article);
    }
}
