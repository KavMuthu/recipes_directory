package com.example.kavi.recipeslist;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Kavi on 1/27/16.
 * Recipe information is displayed
 */
public class Recipes extends MainActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipes_layout);

        Intent intent = new Intent();
        //recipe title
        TextView title = (TextView) findViewById(R.id.recipe_title);
        //recipe image
        ImageView image = (ImageView) findViewById(R.id.recipe_image);
        //recipe content
        TextView recipe = (TextView) findViewById(R.id.recipe_content);

        title.setText(getIntent().getExtras().getString("title"));
        title.setTextColor(Color.BLACK);
        image.setImageResource(getIntent().getExtras().getInt("image"));
        recipe.setText(getIntent().getExtras().getInt("recipe"));
        recipe.setTextSize(15);
        recipe.setTextColor(Color.BLACK);
    }
}
