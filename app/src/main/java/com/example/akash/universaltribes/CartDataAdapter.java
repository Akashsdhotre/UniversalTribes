package com.example.akash.universaltribes;

/**
 * Created by akashsdhotre on 12/03/18.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CartDataAdapter extends RecyclerView.Adapter<CartDataAdapter.ViewHolder> implements Filterable {
    private ArrayList<CartClass> mArrayList;
    private ArrayList<CartClass> mFilteredList;
    Context context;

    public CartDataAdapter(ArrayList<CartClass> arrayList, Context ctx) {

        mArrayList = arrayList;
        mFilteredList = arrayList;
        context=ctx;
    }

    @Override
    public CartDataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cartrow, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CartDataAdapter.ViewHolder viewHolder, final int i) {



        // qImageView.setImageResource(R.drawable.img2);

        viewHolder.cartimg.setImageResource(mFilteredList.get(i).getCartimmg());
        viewHolder.categoryname.setText(mFilteredList.get(i).getCartcat());
        viewHolder.subcategoryname.setText(mFilteredList.get(i).getCartsubcat());
        viewHolder.cartprice.setText(mFilteredList.get(i).getCartprice());
        viewHolder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeActivity.cartdata.remove(i);
                calcprice();
                CartActivity.adapter.notifyDataSetChanged();
                CartActivity.items.setText("Items : "+HomeActivity.cartdata.size());
                CartActivity.sum.setText("Total price : "+CartActivity.sumprice);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFilteredList.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {

                    mFilteredList = mArrayList;
                } else {

                    ArrayList<CartClass> filteredList = new ArrayList<>();

                    for (CartClass catagories : mArrayList) {

                        if (catagories.getCartsubcat().toLowerCase().contains(charString) ) {

                            filteredList.add(catagories);
                        }
                    }

                    mFilteredList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<CartClass>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView cartimg;
        TextView  categoryname;
        TextView  subcategoryname;
        TextView  cartprice;
        Button remove;
        public ViewHolder(View view) {
            super(view);

            cartimg=(ImageView)view.findViewById(R.id.cartimg);
            categoryname=(TextView) view.findViewById(R.id.cartcategoryname);
            subcategoryname=(TextView) view.findViewById(R.id.cartsubcategoryname);
            cartprice=(TextView) view.findViewById(R.id.cartprice);
            remove=(Button) view.findViewById(R.id.remove);


        }
    }
    void calcprice() {
        int sum = 0;
        for (int i = 0; i < HomeActivity.cartdata.size(); i++) {
            sum = sum + Integer.parseInt(HomeActivity.cartdata.get(i).getCartprice());
        }
        CartActivity.sumprice = sum;
    }
}