package com.SelvaBalajiOutlookCom.SelvaBalajiOutlookComS73X;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class FoodMenuListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu_list);

        String[] menuList  = new String[]{"Plain Tea", " Ginger tea", " Filter coffee", " Plain Noodles", " Egg Noodles" , " Boiled Eggs", " Egg Fry"};

        ListAdapter theListAdapter = new ArrayAdapter<String>(this, R.layout.row_layout,
                menuList);

        ListView listView = (ListView) findViewById(R.id.foodListView);

        listView.setAdapter(theListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
              String foodName = String.valueOf(adapterView.getItemAtPosition(position));

            }
        });


    }

}
