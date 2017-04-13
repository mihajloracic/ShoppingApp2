package com.shoppinglist.execom.shoppinglistapp.Model;

import com.shoppinglist.execom.shoppinglistapp.Interfaces.AddValue;

import java.util.HashMap;

/**
 * Created by mihajlo on 4/12/2017.
 */

public class ShoppingArticle implements AddValue{
    String name;
    int amount;
    boolean completed;

    public ShoppingArticle(String name, int amount, boolean completed) {
        this.name = name;
        this.amount = amount;
        this.completed = completed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    @Override
    public HashMap<String,Object> toDictinaory(){
        HashMap<String,Object> shopingArticleDictinaory = new HashMap<String, Object>();
        shopingArticleDictinaory.put("Name", this.name);
        shopingArticleDictinaory.put("Amout" , this.amount);
        shopingArticleDictinaory.put("Completed", completed);

        return shopingArticleDictinaory;
    }
}
