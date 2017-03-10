package com.bawebdevelopment.drinkmixr;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Bill on 3/9/17.
 */

public class BeverageAdapter extends RecyclerView.Adapter<BeverageAdapter.ViewHolder>
{
    private List<String> mDataset;

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView txtDrinkName;

        public ViewHolder(View view)
        {
            super(view);
            txtDrinkName = (TextView) view.findViewById(R.id.drinkName);
        }
    }

    public void add(int position, String item)
    {
        mDataset.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(String item)
    {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    public BeverageAdapter(List<String> items)
    {
        mDataset = items;
    }

    @Override
    public BeverageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        // Create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_row, parent, false);

        // Set the view's size, margins, padding, and layout parameters
//        ViewHolder vh = new ViewHolder(v);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BeverageAdapter.ViewHolder holder, int position)
    {
        // - Get element from your dataset at this position
        // - Replace the contents of the view with that element
        final String name = mDataset.get(position);
        holder.txtDrinkName.setText(mDataset.get(position));
        holder.txtDrinkName.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                remove(name);
            }
        });

//        holder.txtFooter.setText("Footer: " + mDataset.get(position));
    }

    @Override
    public int getItemCount()
    {
        return null != mDataset ? mDataset.size() : 0;
    }
}
