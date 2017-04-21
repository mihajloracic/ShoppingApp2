package com.shoppinglist.execom.shoppinglistapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shoppinglist.execom.shoppinglistapp.model.ShoppingList;
import com.shoppinglist.execom.shoppinglistapp.R;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

/**
 * Created by mihajlo on 4/12/2017.
 */
@EBean
public class ShoppingListAdapter extends BaseAdapter {

    private ArrayList<ShoppingList> items;

    private Context context;

    public ShoppingListAdapter(Context context) {
        this.context = context;
        items = new ArrayList<ShoppingList>();
    }

    public ArrayList<ShoppingList> getItems() {
        return items;
    }

    public void setItems(ArrayList<ShoppingList> items) {
        this.items = items;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
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
        ShoppingList shoppingList = (ShoppingList) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.shoppig_list, parent, false);
        }

        TextView itemName = (TextView) convertView.findViewById(R.id.ad_shopping_list_name);
        ImageView completedImage = (ImageView) convertView.findViewById(R.id.ad_list_completed_image);
        itemName.setText(shoppingList.getName());
        completedImage.setImageResource(shoppingList.isCompleted() ? R.drawable.ic_check_black_24dp : R.drawable.ic_clear_black_24dp);
        return convertView;
    }

}
