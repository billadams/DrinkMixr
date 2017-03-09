package com.bawebdevelopment.drinkmixr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity
{
//    private RecyclerView mRecyclerView;
//    private LinearLayoutManager mLinearLayoutManager;
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

//        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        mLinearLayoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(mLinearLayoutManager);


    }

    public void onClick(View view)
    {
        categoryChoice = spinner.getSelectedItem().toString();
        Toast.makeText(this, categoryChoice, Toast.LENGTH_LONG).show();
    }
}
