package com.bawebdevelopment.drinkmixr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class AddDrinkActivity extends AppCompatActivity
{
    private List<Drink> drinks;
    private List<String> instructionsList;
    private Drink drink;
    private EditText name;
    private EditText ingredients;
    private EditText instructions;
    SharedPreferences sharedPref;
    String serializedBeverageList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_drink);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        this.setTitle("Add New Drink");

        name = (EditText) findViewById(R.id.txtDrinkName);
        ingredients = (EditText) findViewById(R.id.txtIngredients);
        instructions = (EditText) findViewById(R.id.txtInstructions);
    }

    public void onClick(View view)
    {
        drinks = new ArrayList<Drink>();
        instructionsList = new ArrayList<String>();

        String drinkName = name.getText().toString();
        String drinkIngredients = ingredients.getText().toString();
        String drinkInstructions = instructions.getText().toString();
        instructionsList.add(drinkInstructions);

        // Instantiate the PreferenceManager and get the list of drink objects from
        // Shared Preferences.
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        serializedBeverageList = sharedPref.getString("serializedBeverageList", "");
        drinks = new Gson().fromJson(serializedBeverageList, new TypeToken<List<Drink>>(){}.getType());

        // Create the object based on user input.
        drink = new Drink();
        drink.setName(drinkName);
        drink.setIngredients(instructionsList);
        drink.setMixInstructions(drinkInstructions);

        drinks.add(drink);

        // Serialize the drinks list object and store it in Shared Preferences.
        serializedBeverageList = new Gson().toJson(drinks);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("serializedBeverageList", serializedBeverageList);
        editor.apply();

        // Redirect the user back to the category view listing. The putExtra() is ignored for
        // in the ViewAllDrinksActivity.
        Intent intent = new Intent(getBaseContext(), ViewAllDrinksActivity.class);
        intent.putExtra("ADD_SUCCESS", "New drink added!");
        startActivity(intent);
    }

    // Create the overflow menu.
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

}
