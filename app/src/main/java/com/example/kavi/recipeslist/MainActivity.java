package com.example.kavi.recipeslist;
/**
 * All the images and contents used in this application are taken from the allrecipes.com.
 */
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    int i;
    //array of recipe titles,icons and images
    String[] titles = {"Chocolate cake", "Red velvet cake", "Raspberry cake", "Carrot cake", "Cheesecake","Eclair cake","Walnut cake"};
    int[] recipes = {R.string.chococake_recipe, R.string.redvelvet_recipe, R.string.raspberrycake_recipe, R.string.carrotcake_recipe, R.string.cheesecake_recipe,R.string.eclaircake_recipe,R.string.walnutcake_recipe};
    int[] icons = {R.drawable.chococake_icon, R.drawable.redvelvet_icon, R.drawable.raspberrycake_icon, R.drawable.carrotcake_icon, R.drawable.cheesecake_icon,R.drawable.eclair_icon,R.drawable.walnutcake_icon};
    int[] images = {R.drawable.chococake, R.drawable.redvelvet, R.drawable.raspberrycake, R.drawable.carrotcake, R.drawable.cheesecake,R.drawable.eclaircake,R.drawable.walnutcake};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        //recipe title and images are added to the listview
        ListView listview = (ListView) findViewById(R.id.listView);
        listview.setAdapter(new CustomAdapter(this, R.layout.row_layout, titles, icons));

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == (titles.length - 1)) {
                    i = position;
                    //alert box pops up for the last recipe
                    showAlertDialog(MainActivity.this);

                } else {
                    //title,recipe and image are put in the intent
                    Intent intent = new Intent(MainActivity.this, Recipes.class);
                    intent.putExtra("title", titles[position]);
                    intent.putExtra("recipe", recipes[position]);
                    intent.putExtra("image", images[position]);
                    startActivity(intent);
                }
            }
        });
    }

    //alert dialog box
    public void showAlertDialog(MainActivity mainactivity) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(mainactivity);
        alertDialog.setTitle("Nut Allergy Caution");
        alertDialog.setMessage("This recipe contains nuts. Click yes to proceed");
        //positive response
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity.this, Recipes.class);
                intent.putExtra("title", titles[i]);
                intent.putExtra("recipe", recipes[i]);
                intent.putExtra("image", images[i]);
                startActivity(intent);
            }
        });
        //negative response
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alertDialog.create().show();

    }

    //menu items(info,uninstall) are inflated in the menu inflater
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //info menu item
        if (id == R.id.action_info) {
            Intent intent = new Intent(MainActivity.this, About.class);
            startActivity(intent);
        }else{
            //uninstall menu item
            if (id == R.id.action_uninstall) {
                Uri packageURI = Uri.parse("package:com.example.kavi.recipeslist");
                Intent intent = new Intent(Intent.ACTION_DELETE, packageURI);
                startActivity(intent);
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
