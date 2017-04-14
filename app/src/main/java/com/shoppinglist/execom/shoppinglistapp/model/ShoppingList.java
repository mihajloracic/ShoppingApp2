package com.shoppinglist.execom.shoppinglistapp.model;

import java.util.ArrayList;

/**
 * Created by mihajlo on 4/12/2017.
 */

public class ShoppingList {
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

}
