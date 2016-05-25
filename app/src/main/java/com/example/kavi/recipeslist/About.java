package com.example.kavi.recipeslist;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Kavi on 1/27/16.
 * About page for the app
 */
public class About extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_layout);

        final String phone = "888-8888";
        //name of the app
        TextView name = (TextView) findViewById(R.id.info_title);
        name.setTextColor(Color.BLACK);
        //info about the app
        TextView info_detail = (TextView) findViewById(R.id.info_detail);
        info_detail.setTextSize(15);
        info_detail.setTextColor(Color.BLACK);
        //contact - call button
        Button call_button = (Button) findViewById(R.id.call_button);

        name.setText("Recipes Directory");
        info_detail.setText(getString(R.string.cakeRecpies_info));
        call_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call action intent
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
                startActivity(intent);
            }
        });


    }
}