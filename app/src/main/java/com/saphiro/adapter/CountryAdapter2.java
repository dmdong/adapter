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
public class CountryAdapter2 extends BaseAdapter {

    Context context;
    int layoutItem;

    public CountryAdapter2(Context context, List<Country> countries, int layoutItem) {
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

        ViewHolder viewHolder = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layoutItem, parent, false);

            viewHolder = new ViewHolder();


            viewHolder.en = (TextView) convertView.findViewById(R.id.en_text);
            viewHolder.vi = (TextView) convertView.findViewById(R.id.vi_text);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.en.setText(countries.get(position).getEn());
        viewHolder.vi.setText(countries.get(position).getVi());

        return convertView;
    }

    class ViewHolder {
        TextView vi;
        TextView en;
    }
}
