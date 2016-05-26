package com.saphiro.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Saphiro on 5/25/2016.
 */
public class CountryDBAdapter extends ArrayAdapter<CountryDB> {

    Context context;
    int resource;
    List<CountryDB> countries;

    public CountryDBAdapter(Context context, int resource, List<CountryDB> countries) {
        super(context, resource, countries);
        this.context = context;
        this.resource = resource;
        this.countries = countries;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resource, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.ivFlag = (ImageView) convertView.findViewById(R.id.ivFlag);
            viewHolder.tvEName = (TextView) convertView.findViewById(R.id.tvenName);
            viewHolder.tvVName = (TextView) convertView.findViewById(R.id.tvviName);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvEName.setText(countries.get(position).getEnName());
        viewHolder.tvVName.setText(countries.get(position).getViName());

        return convertView;
    }

    class ViewHolder {
        TextView tvEName;
        TextView tvVName;
        ImageView ivFlag;
    }
}
