package com.SelvaBalajiOutlookCom.SelvaBalajiOutlookComS73X;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodMenuActivity extends Activity {
    SimpleAdapter simpleAdpt;

    
    @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.food_menu);

            initList();
            ListView lv = (ListView) findViewById(R.id.listView);
            simpleAdpt = new SimpleAdapter(this, foodList, android.R.layout.simple_list_item_1, new String[] {"foodmenu"}, new int[] {android.R.id.text1});

            lv.setAdapter(simpleAdpt);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
                                    long id) {
                TextView clickedView = (TextView) view;
                Toast.makeText(FoodMenuActivity.this, "Item with id [" + id + "] - Position [" + position + "] - Menu [" + clickedView.getText() + "]", Toast.LENGTH_SHORT).show();
            }
        });
        registerForContextMenu(lv);

    }

    List<Map<String, String>> foodList = new ArrayList<Map<String,String>>();

    private void initList() {
// We populate the Food List

        foodList.add(createFoodmenu("foodmenu", "Plain Tea"));
        foodList.add(createFoodmenu("foodmenu", "Ginger tea"));
        foodList.add(createFoodmenu("foodmenu", "Filter coffee"));
        foodList.add(createFoodmenu("foodmenu", "Plain Noodles"));
        foodList.add(createFoodmenu("foodmenu", "Egg Noodles"));
        foodList.add(createFoodmenu("foodmenu", "Boiled Eggs"));
        foodList.add(createFoodmenu("foodmenu", "Egg Fry"));

    }

    private HashMap<String, String> createFoodmenu(String key, String name) {
        HashMap<String, String> foods = new HashMap<String, String>();
        foods.put(key, name);

        return foods;
    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo aInfo = (AdapterView.AdapterContextMenuInfo) menuInfo;

// We know that each row in the adapter is a Map
        HashMap map = (HashMap) simpleAdpt.getItem(aInfo.position);

        menu.setHeaderTitle("Options for " + map.get("foodmenu"));
        menu.add(1, 1, 1, "Details");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int itemId = item.getItemId();
// Implements our logic
        Toast.makeText(this, "Item id ["+itemId+"]", Toast.LENGTH_SHORT).show();
        return true;
    }

}
