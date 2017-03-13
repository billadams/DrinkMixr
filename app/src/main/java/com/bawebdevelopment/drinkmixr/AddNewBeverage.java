package com.bawebdevelopment.drinkmixr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class AddNewBeverage extends AppCompatActivity
{
    private List<Beverage> beverages;
    private List<String> instructionsList;
    private Beverage beverage;
    private EditText name;
    private EditText ingredients;
    private EditText instructions;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_beverage);

        name = (EditText) findViewById(R.id.txtDrinkName);
        ingredients = (EditText) findViewById(R.id.txtIngredients);
        instructions = (EditText) findViewById(R.id.txtInstructions);
    }

    public void onClick(View view)
    {
        beverages = new ArrayList<Beverage>();
        instructionsList = new ArrayList<String>();

        String drinkName = name.getText().toString();
        String drinkIngredients = ingredients.getText().toString();
        String drinkInstructions = instructions.getText().toString();
        instructionsList.add(drinkInstructions);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String serializedBeverageList = sharedPref.getString("serializedBeverageList", "");
        beverages = new Gson().fromJson(serializedBeverageList, new TypeToken<List<Beverage>>(){}.getType());

        beverage = new Beverage();
        beverage.setName(drinkName);
        beverage.setIngredients(instructionsList);
        beverage.setMixInstructions(drinkInstructions);

        beverages.add(beverage);

        String serializedList = new Gson().toJson(beverages);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("serializedBeverageList", serializedList);
        editor.apply();

        Intent intent = new Intent(getBaseContext(), CategoryView.class);
        intent.putExtra("ADD_SUCCESS", "New drink added!");
        startActivity(intent);
    }
}
