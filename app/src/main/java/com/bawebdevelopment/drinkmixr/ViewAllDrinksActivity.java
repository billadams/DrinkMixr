package com.bawebdevelopment.drinkmixr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

public class ViewAllDrinksActivity extends AppCompatActivity
{
//    private RecyclerView recyclerView;
//    private RecyclerView.Adapter mAdapter;
//    private RecyclerView.LayoutManager mLayoutManager;
//    private List<String> datasetItems;

//    private Drink drink;
    private List<Drink> drinks;
//    private List<String> beverageTitles;
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_drinks);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        // Get the category that was selected.
        category = getIntent().getStringExtra("CATEGORY");
        this.setTitle(category);

        // Initialize the list of drinks.
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String serializedBeverageList = sharedPref.getString("serializedBeverageList", "");
        drinks = new Gson().fromJson(serializedBeverageList, new TypeToken<List<Drink>>(){}.getType());

        // Look up the recyclerview in activity layout.
        RecyclerView rvDrinks = (RecyclerView) findViewById(R.id.all_drinks_recycler_view);

//        rvDrinks.setHasFixedSize(true);

        // Attach the RecyclerView adapter up to the list of drinks.
        DrinkAdapter adapter = new DrinkAdapter(this, drinks);
        rvDrinks.setAdapter(adapter);

        // Set layout manager to position the items.
        rvDrinks.setLayoutManager(new LinearLayoutManager(this));

        // Displays a border between drinks in the Recyclerview View.
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvDrinks.addItemDecoration(itemDecoration);

        // Adds an animation if there is a longer list present while sliding up.
        rvDrinks.setItemAnimator(new SlideInUpAnimator());
    }

    // Create the overflow menu.
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void onClick(View view)
    {
        // Go to the Add Drink Activity.
        Intent intent = new Intent(getBaseContext(), AddDrinkActivity.class);
        String serializedList = new Gson().toJson(drinks);
        intent.putExtra("BEVERAGE_LIST", serializedList);
        startActivity(intent);
    }
}
