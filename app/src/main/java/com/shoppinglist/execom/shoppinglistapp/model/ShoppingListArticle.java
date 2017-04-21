package com.shoppinglist.execom.shoppinglistapp.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.shoppinglist.execom.shoppinglistapp.utils.ConstantsDatabase;

/**
 * Created by mihajlo on 4/16/2017.
 */
@DatabaseTable(tableName = "shopping_list_article")
public class ShoppingListArticle {
    @DatabaseField(columnName = ConstantsDatabase.ID_FIELD_NAME, generatedId = true)
    private int id;

    @DatabaseField(columnName = ConstantsDatabase.ARTICLE_ID)
    int articleId;

    @DatabaseField(columnName = ConstantsDatabase.ARTICLE_LIST_ID)
    int listId;

    @DatabaseField(columnName = ConstantsDatabase.AMOUNT_FIELD_NAME)
    int amount;

    @DatabaseField(columnName = ConstantsDatabase.COMPLETED_FIELD_NAME)
    boolean completed;

    public ShoppingListArticle(){

    }
    public ShoppingListArticle(int articleId, int listId, int amount, boolean completed) {
        this.articleId = articleId;
        this.listId = listId;
        this.amount = amount;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
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
