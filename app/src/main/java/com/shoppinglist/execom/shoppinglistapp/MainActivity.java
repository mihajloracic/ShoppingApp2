package com.shoppinglist.execom.shoppinglistapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.shoppinglist.execom.shoppinglistapp.Adapter.ShoppingListAdapter;
import com.shoppinglist.execom.shoppinglistapp.Model.ShoppingList;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.list_shopping_list)
    ListView shoppListView;


    ArrayList<ShoppingList> shoppingItemsList  = new ArrayList<ShoppingList>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @AfterViews
    void setActivity(){
        //setUpDatabase();
        //populateData();
        //setupAdapter();
    }

    void setUpDatabase(){
        //DatabaseHelper databaseHelper = new DatabaseHelper(this);
    }

    void setupAdapter(){

        ShoppingListAdapter shoppingListAdapter = new ShoppingListAdapter(shoppingItemsList,this);
        shoppingListAdapter.setItems(shoppingItemsList);
        shoppListView.setAdapter(shoppingListAdapter);
    }

    void populateData(){
        for (int i = 0;i < 50;i++){
            shoppingItemsList.add(new ShoppingList("Rucak" + i,false));
        }
    }
}
