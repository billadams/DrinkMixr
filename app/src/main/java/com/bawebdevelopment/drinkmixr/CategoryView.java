package com.bawebdevelopment.drinkmixr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_view);

        // Get the category that was selected.
        String category = getIntent().getStringExtra("CATEGORY");
        this.setTitle(category);

        recyclerView = (RecyclerView) findViewById(R.id.category_recycler_view);
        recyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        beverages = BeverageDB.getAllBeverages();
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

        // Specify an adapter (see also next example???)
        mAdapter = new BeverageAdapter(beverageTitles);
        recyclerView.setAdapter(mAdapter);
    }
}
