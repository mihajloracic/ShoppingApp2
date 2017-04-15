package com.shoppinglist.execom.shoppinglistapp.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.shoppinglist.execom.shoppinglistapp.utils.ConstantsDatabase;

/**
 * Created by mihajlo on 4/12/2017.
 */

@DatabaseTable(tableName = "shopping_article")
public class ShoppingArticle  {

    @DatabaseField(columnName = ConstantsDatabase.ID_FIELD_NAME, generatedId = true)
    private int id;

    @DatabaseField(columnName = ConstantsDatabase.ARTICLE_FIELD_NAME, foreign = false)
    private String name;

    public ShoppingArticle() {
    }

    public ShoppingArticle(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ShoppingArticle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
