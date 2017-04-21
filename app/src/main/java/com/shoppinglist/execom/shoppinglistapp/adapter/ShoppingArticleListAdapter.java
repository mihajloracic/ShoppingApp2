package com.shoppinglist.execom.shoppinglistapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.shoppinglist.execom.shoppinglistapp.model.ShoppingArticle;
import com.shoppinglist.execom.shoppinglistapp.R;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

/**
 * Created by mihajlo on 4/14/2017.
 */
@EBean
public class ShoppingArticleListAdapter extends BaseAdapter{


    private ArrayList<ShoppingArticle> items;

    private Context context;

    public ShoppingArticleListAdapter(Context context) {
        this.context = context;
        items = new ArrayList<ShoppingArticle>();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ShoppingArticle shoppingList = (ShoppingArticle) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.shopping_article, parent, false);
        }

        TextView itemName = (TextView) convertView.findViewById(R.id.article_name);

        itemName.setText(shoppingList.getName());

        return convertView;
    }

    public ArrayList<ShoppingArticle> getItems() {
        return items;
    }

    public void setItems(ArrayList<ShoppingArticle> items) {
        this.items = items;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
