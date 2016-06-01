package com.saphiro.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Saphiro on 5/9/2016.
 */
public class CountryAdapter extends BaseAdapter {

    Context context;
    int layoutItem;

    public CountryAdapter(Context context, List<Country> countries, int layoutItem) {
        this.context = context;
        this.countries = countries;
        this.layoutItem = layoutItem;
    }

    List<Country> countries;


    @Override
    public int getCount() {
        return countries.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = null;

        view = inflater.inflate(layoutItem, parent, false);

        TextView en = (TextView) view.findViewById(R.id.en_text);
        TextView vi = (TextView) view.findViewById(R.id.vi_text);

        en.setText(countries.get(position).getEn());
        vi.setText(countries.get(position).getVi());

        return view;
    }
}
