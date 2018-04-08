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
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SubCategoryDataAdapter extends RecyclerView.Adapter<SubCategoryDataAdapter.ViewHolder> implements Filterable {
    private ArrayList<SubCategoryClass> mArrayList;
    private ArrayList<SubCategoryClass> mFilteredList;
    Context context;
    String catname;
    int catimg,catindex;

    public SubCategoryDataAdapter(ArrayList<SubCategoryClass> arrayList, Context ctx,String catname,int catimg,int catindex) {

        mArrayList = arrayList;
        mFilteredList = arrayList;
        context=ctx;
        this.catname = catname;
        this.catimg = catimg;
        this.catindex = catindex;
    }

    @Override
    public SubCategoryDataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sub_category_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SubCategoryDataAdapter.ViewHolder viewHolder, final int i) {



        // qImageView.setImageResource(R.drawable.img2);

        viewHolder.subcategoryimg.setImageResource(mFilteredList.get(i).getImagepath());
        viewHolder.subcategoryname.setText(mFilteredList.get(i).getCategoryName());

        final String subcatname=mFilteredList.get(i).getCategoryName();
        final int subcatimg = mFilteredList.get(i).getImagepath();
        final int subcatindex=i;


        viewHolder.subcategoryClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context,""+catname,Toast.LENGTH_SHORT).show();
                Toast.makeText(context,""+catname+" "+i,Toast.LENGTH_SHORT).show();
                Intent i=new Intent(context,DetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("catInfoTitle", catname);
                bundle.putInt("catInfoIndex", catindex);
                bundle.putInt("catInfoImg", catimg);
                bundle.putString("subcatInfoTitle", subcatname);
                bundle.putInt("subcatInfoIndex", subcatindex);
                bundle.putInt("subcatInfoImg", subcatimg);
                bundle.putInt("subcatInfoDesc", mFilteredList.get(subcatindex).getCategoryDesc());
                bundle.putString("subcatInfoPrice", mFilteredList.get(subcatindex).getPrice());
                i.putExtras(bundle);

                context.startActivity(i);
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

                    ArrayList<SubCategoryClass> filteredList = new ArrayList<>();

                    for (SubCategoryClass catagories : mArrayList) {

                        if (catagories.getCategoryName().toLowerCase().contains(charString) ) {

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
                mFilteredList = (ArrayList<SubCategoryClass>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView subcategoryimg;
        TextView  subcategoryname;
        LinearLayout subcategoryClick;
        public ViewHolder(View view) {
            super(view);

            subcategoryimg=(ImageView)view.findViewById(R.id.subcategoryimg);
            subcategoryname=(TextView) view.findViewById(R.id.subcategoryname);
            subcategoryClick=(LinearLayout)view.findViewById(R.id.subcategoryClick);


        }
    }

}