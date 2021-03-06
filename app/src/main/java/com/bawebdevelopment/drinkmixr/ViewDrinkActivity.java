package com.bawebdevelopment.drinkmixr;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

public class ViewDrinkActivity extends AppCompatActivity
{
    Drink drink;
    String s;
    List<String> ingredients;
    String ingredientsString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_drink);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        s = getIntent().getStringExtra("SELECTED_DRINK");
        drink = new Gson().fromJson(s, Drink.class);

        // TODO Pull this dynamically from the spinner control.
        this.setTitle(drink.getName());

        // Set the drink name.
//        TextView txtDrinkName = (TextView) findViewById(R.id.drinkName);
//        txtDrinkName.setText(drink.getName());

        // Set the ingredients.
        TextView txtDrinkIngredients = (TextView) findViewById(R.id.drinkIngredients);
        ingredients = drink.getIngredients();
        for (String ingredient : ingredients)
        {
            ingredientsString += ingredient + "\n";
        }
        txtDrinkIngredients.setText(ingredientsString);

        // Set the drink instructions.
        TextView txtDrinkInstructions = (TextView) findViewById(R.id.drinkInstructions);
        txtDrinkInstructions.setText(drink.getMixInstructions());
    }

    // Create the overflow menu.
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
