package com.shoppinglist.execom.shoppinglistapp.Model;

import com.shoppinglist.execom.shoppinglistapp.Interfaces.AddValue;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mihajlo on 4/12/2017.
 */

public class ShoppingList implements AddValue{
    String name;
    boolean completed;
    ArrayList<ShoppingArticle> shoppingItems;

    public ShoppingList(String name, boolean completed, ArrayList<ShoppingArticle> shoppingItems) {
        this.name = name;
        this.completed = completed;
        this.shoppingItems = shoppingItems;
    }
    public ShoppingList(String name, boolean completed) {
        this.name = name;
        this.completed = completed;
        this.shoppingItems = new ArrayList<ShoppingArticle>();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public ArrayList<ShoppingArticle> getShoppingItems() {
        return shoppingItems;
    }

    public void setShoppingItems(ArrayList<ShoppingArticle> shoppingItems) {
        this.shoppingItems = shoppingItems;
    }
    @Override
    public HashMap<String,Object> toDictinaory(){
        HashMap<String,Object> shoppingListArticleDictinaory = new HashMap<String, Object>();
        shoppingListArticleDictinaory.put("Name", this.name);
        shoppingListArticleDictinaory.put("Completed", completed);
        return shoppingListArticleDictinaory;
    }
}
