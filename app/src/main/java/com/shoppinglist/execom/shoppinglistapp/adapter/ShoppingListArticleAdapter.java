package com.shoppinglist.execom.shoppinglistapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shoppinglist.execom.shoppinglistapp.R;
import com.shoppinglist.execom.shoppinglistapp.model.ShoppingListArticle;
import com.shoppinglist.execom.shoppinglistapp.reporitory.ArticleDAORepository;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

/**
 * Created by mihajlo on 4/16/2017.
 */
@EBean
public class ShoppingListArticleAdapter extends BaseAdapter{

    private ArrayList<ShoppingListArticle> items;

    private Context context;

    @Bean
    ArticleDAORepository articleDAORepository;

    public ShoppingListArticleAdapter(Context context) {
        this.context = context;
        this.items = new ArrayList<ShoppingListArticle>();
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
        ShoppingListArticle shoppingListArticle = (ShoppingListArticle) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.shopping_article, parent, false);
        }

        TextView itemName = (TextView) convertView.findViewById(R.id.article_name);


        TextView itemAmount = (TextView) convertView.findViewById(R.id.article_amount);

        ImageView completedImage = (ImageView) convertView.findViewById(R.id.article_completed_image);

        itemName.setText("Name: " + articleDAORepository.getNameById(Integer.toString(shoppingListArticle.getArticleId())));
        itemAmount.setText("Amount: " + Integer.toString(shoppingListArticle.getAmount()));
        completedImage.setImageResource(shoppingListArticle.isCompleted() ? R.drawable.ic_check_black_24dp : R.drawable.ic_clear_black_24dp);
        return convertView;
    }

    public ArrayList<ShoppingListArticle> getItems() {
        return items;
    }

    public void setItems(ArrayList<ShoppingListArticle> items) {
        this.items = items;
    }
}
