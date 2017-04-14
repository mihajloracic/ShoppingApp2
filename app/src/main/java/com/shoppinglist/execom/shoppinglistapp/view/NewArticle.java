package com.shoppinglist.execom.shoppinglistapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shoppinglist.execom.shoppinglistapp.R;

import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_new_article)
public class NewArticle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_article);
    }
}
