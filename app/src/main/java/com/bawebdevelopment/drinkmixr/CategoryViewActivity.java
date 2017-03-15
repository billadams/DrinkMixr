package com.bawebdevelopment.drinkmixr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

public class CategoryViewActivity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<String> datasetItems;

    private Drink drink;
    private List<Drink> drinks;
    private List<String> beverageTitles;
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        // Get the category that was selected.
        category = getIntent().getStringExtra("CATEGORY");
        this.setTitle(category);

        // Initialize the list of drinks.
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String serializedBeverageList = sharedPref.getString("serializedBeverageList", "");
        drinks = new Gson().fromJson(serializedBeverageList, new TypeToken<List<Drink>>(){}.getType());

        // Look up the recyclerview in activity layout.
        RecyclerView rvDrinks = (RecyclerView) findViewById(R.id.category_recycler_view);

        rvDrinks.setHasFixedSize(true);

        DrinkAdapter adapter = new DrinkAdapter(this, drinks);
        rvDrinks.setAdapter(adapter);

        // Set layout manager to position the items.
        rvDrinks.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvDrinks.addItemDecoration(itemDecoration);

        rvDrinks.setItemAnimator(new SlideInUpAnimator());
    }

    public void onClick(View view)
    {
        Intent intent = new Intent(getBaseContext(), AddDrinkActivity.class);
        String serializedList = new Gson().toJson(drinks);
        intent.putExtra("BEVERAGE_LIST", serializedList);
        startActivity(intent);
    }
}
