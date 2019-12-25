package com.duynam.myapplication.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.duynam.myapplication.R;
import com.duynam.myapplication.model.Country;

import java.util.List;

public class CountryAdapter implements SpinnerAdapter {

    private Context context;
    private List<Country> countryList;

    public CountryAdapter(Context context, List<Country> countryList) {
        this.context = context;
        this.countryList = countryList;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.image3, parent, false);
        TextView tv_country = convertView.findViewById(R.id.tv_name_country);
        ImageView img_countrty = convertView.findViewById(R.id.img_country);
        tv_country.setText(countryList.get(position).getName()+"");
        img_countrty.setImageResource(countryList.get(position).getImage());
        return convertView;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return countryList.size();
    }

    @Override
    public Object getItem(int position) {
        return countryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.image3, parent, false);
        TextView tv_country = convertView.findViewById(R.id.tv_name_country);
        ImageView img_countrty = convertView.findViewById(R.id.img_country);
        tv_country.setText(countryList.get(position).getName()+"");
        Glide.with(context).load(countryList.get(position).getImage()).into(img_countrty);
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
