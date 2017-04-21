package com.shoppinglist.execom.shoppinglistapp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.shoppinglist.execom.shoppinglistapp.R;
import com.shoppinglist.execom.shoppinglistapp.adapter.ShoppingListAdapter;
import com.shoppinglist.execom.shoppinglistapp.model.ShoppingList;
import com.shoppinglist.execom.shoppinglistapp.reporitory.ShoppingListDAORespository;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

@EActivity(R.layout.activity_shopping_list)
public class ShoppingLists extends AppCompatActivity {

    @ViewById(R.id.shopping_lists)
    ListView listView;

    @Bean
    ShoppingListAdapter shoppingListAdapter;

    @Bean
    ShoppingListDAORespository shoppingListDAORespository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    @UiThread
    void setAdapter(){
        ArrayList<ShoppingList> articles = new ArrayList<ShoppingList>(shoppingListDAORespository.findAll());
        ArrayList<ShoppingList> sortedArticles = new ArrayList<ShoppingList>();
        for (ShoppingList i : articles){
            if(i.isCompleted()){
                sortedArticles.add(i);
            }else{
                sortedArticles.add(0,i);
            }
        }
        shoppingListAdapter.setItems(sortedArticles);
        listView.setAdapter(shoppingListAdapter);
    }

    @Click(R.id.add_shopping_list)
    void addShoppingList(){
        NewShoppingList_.intent(this).startForResult(0);
    }

    @OnActivityResult(0)
    void onResult(){
        setAdapter();
    }

    @ItemClick(R.id.shopping_lists)
    void itemClick(int position){
        ShoppingList shoppingList = (ShoppingList) shoppingListAdapter.getItem(position);
        int shopingListId = shoppingList.getId();
        ArticleList_.intent(this).thisListId(shopingListId).startForResult(0);
    }
}
