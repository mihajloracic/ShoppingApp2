package com.shoppinglist.execom.shoppinglistapp.Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.shoppinglist.execom.shoppinglistapp.Utils.ConstantsDatabase;

/**
 * Created by mihajlo on 4/12/2017.
 */

@DatabaseTable(tableName = "ShoppingArticle")
public class ShoppingArticle  {


    @DatabaseField(columnName = ConstantsDatabase.ID_FIELD_NAME, generatedId = true)
    private int id;

    @DatabaseField(columnName = ConstantsDatabase.ARTICLE_FIELD_NAME, foreign = false)
    private String name;

    @DatabaseField(columnName = ConstantsDatabase.AMOUNT_FIELD_NAME, foreign = false)
    private int amount;

    @DatabaseField(columnName = ConstantsDatabase.COMPLETED_FIELD_NAME, foreign = false)
    private boolean completed;

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

}
