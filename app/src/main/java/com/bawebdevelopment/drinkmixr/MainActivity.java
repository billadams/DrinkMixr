package com.bawebdevelopment.drinkmixr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private Spinner spinner;
    private String categoryChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
