package com.bawebdevelopment.drinkmixr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private Spinner spinner;
    private String categoryChoice;
    private List<Beverage> beverages;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPref = getSharedPreferences("serializedBeverageList", 0);

        if(!sharedPref.contains("serializedBeverageList"))
        {
            beverages = BeverageDB.getAllBeverages();
            String serializedList = new Gson().toJson(beverages);

            sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("serializedBeverageList", serializedList);
            editor.apply();
        }


        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categories_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    // Based on the spinner selection, display the correct category.
    public void onClick(View view)
    {
        categoryChoice = spinner.getSelectedItem().toString();
        Intent intent = new Intent(getBaseContext(), CategoryView.class);
        final String CATEGORY = "com.bawebdevelopment.CATEGORY";
        intent.putExtra("CATEGORY", categoryChoice);
        startActivity(intent);


//        Toast.makeText(this, categoryChoice, Toast.LENGTH_LONG).show();
    }
}
