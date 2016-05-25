package com.example.kavi.recipeslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Kavi on 1/27/16.
 */
public class CustomAdapter extends ArrayAdapter<String> {

    Context context;
    String[] titles;
    int[] icons;


    public CustomAdapter(Context context, int layout, String[] titles, int[] images) {
        super(context, R.layout.row_layout, titles);
        this.context = context;
        this.titles = titles;
        this.icons = images;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //the rwo layout is inflated
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_layout, parent, false);

        //recipe title
        TextView title = (TextView) view.findViewById(R.id.row_text);
        title.setText(titles[position]);

        //recipe image
        ImageView icon = (ImageView) view.findViewById(R.id.row_image);
        icon.setImageResource(icons[position]);
        return view;

    }

}
