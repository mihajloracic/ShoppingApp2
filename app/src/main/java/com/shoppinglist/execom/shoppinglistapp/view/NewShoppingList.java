package com.shoppinglist.execom.shoppinglistapp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.shoppinglist.execom.shoppinglistapp.R;
import com.shoppinglist.execom.shoppinglistapp.model.ShoppingList;
import com.shoppinglist.execom.shoppinglistapp.reporitory.ArticleDAORepository;
import com.shoppinglist.execom.shoppinglistapp.reporitory.ShoppingListDAORespository;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_new_shopping_list)
public class NewShoppingList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @ViewById(R.id.shopping_list_name)
    EditText shoppingListName;

    @Bean
    ShoppingListDAORespository shoppingListDAORespository;



    @Click(R.id.add_shopping_list)
    void addShoppingList(){
        String text = shoppingListName.getText().toString();

        if(!text.equals("")){
            shoppingListDAORespository.create(new ShoppingList(text,false));
            Toast.makeText(this, "Shopping list " + text + " was creted", Toast.LENGTH_LONG).show();
            finish();
        }else{
            Toast.makeText(this,"Shopping list name can't be empty" , Toast.LENGTH_LONG).show();
        }
    }
}
