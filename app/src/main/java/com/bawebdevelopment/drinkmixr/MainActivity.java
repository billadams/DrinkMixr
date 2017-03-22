package com.bawebdevelopment.drinkmixr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private Spinner spinner;
    private String categoryChoice;
    private List<Drink> drinks;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create and get the drink list from the device.
        SharedPreferences sharedPref = getSharedPreferences("serializedBeverageList", 0);

        // Check if the key exists in prefs, if it doesn't create it.
        // Once the app has run once and a new drink has been added, this
        // will override any new drinks upon app initialization. Until a DB
        // is implemented, simply disable this code after the app has run once
        // to persist new drinks.
        if(!sharedPref.contains("serializedBeverageList"))
        {
            // Create the list of drinks.
            drinks = DrinkDB.getAllBeverages();

            // Serialize the list of drinks into a preferences string.
            String serializedList = new Gson().toJson(drinks);

            sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("serializedBeverageList", serializedList);
            editor.apply();
        }

        // Set up the spinner to display a list of categories.
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categories_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    // Create the overflow menu.
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    // Based on the spinner selection, display the correct category.
    public void onClick(View view)
    {
        // Display the Category View Activity.
        categoryChoice = spinner.getSelectedItem().toString();
        Intent intent = new Intent(getBaseContext(), ViewAllDrinksActivity.class);
        final String CATEGORY = "com.bawebdevelopment.CATEGORY";
        intent.putExtra("CATEGORY", categoryChoice);
        startActivity(intent);
    }
}
