package com.bawebdevelopment.drinkmixr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryView extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<String> datasetItems;

    private Beverage beverage;
    private List<Beverage> beverages;
    private List<String> beverageTitles;
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_view);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String serializedBeverageList = sharedPref.getString("serializedBeverageList", "");
        beverages = new Gson().fromJson(serializedBeverageList, new TypeToken<List<Beverage>>(){}.getType());

        // Get the category that was selected.
        category = getIntent().getStringExtra("CATEGORY");
        this.setTitle(category);

        recyclerView = (RecyclerView) findViewById(R.id.category_recycler_view);
        recyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

//        beverages = BeverageDB.getAllBeverages();
        beverageTitles = new ArrayList<String>();
        for (Beverage beverage : beverages)
        {
            beverageTitles.add(beverage.getName());
        }

//        for (int i = 0; i < 100; i++)
//        {
//            beverage = new Beverage();
//            beverage.setName(category + i);
//            beverages.add(beverage.getName());
//        }

        ArrayList<String> values = new ArrayList<String>();
        for (int i = 0; i < 100; i++)
        {
            values.add("Test" + i);
        }

        // Specify an adapter
        mAdapter = new BeverageAdapter(beverageTitles);
        recyclerView.setAdapter(mAdapter);
    }

    public void onClick(View view)
    {
        Intent intent = new Intent(getBaseContext(), AddNewBeverage.class);
        String serializedList = new Gson().toJson(beverages);
        intent.putExtra("BEVERAGE_LIST", serializedList);
        startActivity(intent);
    }
}
