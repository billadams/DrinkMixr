package com.bawebdevelopment.drinkmixr;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Bill on 3/9/17.
 */

public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.ViewHolder>
{
    private List<Drink> mDrinks;
    private Context mContext;

    // Provide a direct reference to each of the views within a data item.
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private Context context;
        public TextView txtDrinkName;

        public ViewHolder(Context context, View itemView)
        {
            super(itemView);

            this.txtDrinkName = (TextView) itemView.findViewById(R.id.drinkName);

            this.context = context;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION)
            {
                Drink drink = mDrinks.get(position);
                List<String> ingredients = drink.getIngredients();
                Intent intent = new Intent(mContext, DrinkViewActivity.class);
                String s = (new Gson().toJson(drink));
                intent.putExtra("SELECTED_DRINK", s);
                mContext.startActivity(intent);
            }
        }
    }

    public DrinkAdapter(Context context, List<Drink> drinks)
    {
        mContext = context;
        mDrinks = drinks;
    }

    private Context getContext()
    {
        return mContext;
    }

    public void add(int position, Drink drink)
    {
        mDrinks.add(position, drink);
        notifyItemInserted(position);
    }

    public void remove(Drink drink)
    {
        int position = mDrinks.indexOf(drink);
        mDrinks.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public DrinkAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Create a new view
        View drinkView = inflater.inflate(R.layout.item_drink, parent, false);

        // Set the view's size, margins, padding, and layout parameters
//        ViewHolder vh = new ViewHolder(v);

        return new ViewHolder(context, drinkView);
    }

    @Override
    public void onBindViewHolder(DrinkAdapter.ViewHolder holder, int position)
    {
        // Get the data model based on position.
        Drink drink = mDrinks.get(position);

        // Set item views based on the defined views and data model.
        holder.txtDrinkName.setText(drink.getName());
        holder.txtDrinkName.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
//                remove(name);
            }
        });

//        holder.txtFooter.setText("Footer: " + mDrinks.get(position));
    }

    @Override
    public int getItemCount()
    {
        return null != mDrinks ? mDrinks.size() : 0;
    }
}
