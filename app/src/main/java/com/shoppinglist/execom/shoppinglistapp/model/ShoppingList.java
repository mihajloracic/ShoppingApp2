package com.shoppinglist.execom.shoppinglistapp.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.shoppinglist.execom.shoppinglistapp.utils.ConstantsDatabase;

import java.util.ArrayList;

/**
 * Created by mihajlo on 4/12/2017.
 */
@DatabaseTable(tableName = "shopping_list")
public class ShoppingList {

    @DatabaseField(columnName = ConstantsDatabase.ARTICLE_LIST_ID, generatedId = true)
    private int id;

    @DatabaseField(columnName = ConstantsDatabase.ARTICLE_LIST_FIELD_NAME)
    String name;

    @DatabaseField(columnName = ConstantsDatabase.COMPLETED_SHOPPING_LIST)
    boolean completed;

    ArrayList<ShoppingArticle> shoppingItems;

    public ShoppingList(){ }

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

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ShoppingList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", completed=" + completed +
                ", shoppingItems=" + shoppingItems +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }
}
