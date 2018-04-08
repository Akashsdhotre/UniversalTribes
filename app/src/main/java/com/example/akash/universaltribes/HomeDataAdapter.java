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

public class HomeDataAdapter extends RecyclerView.Adapter<HomeDataAdapter.ViewHolder> implements Filterable {
    private ArrayList<HomeCatagoriesClass> mArrayList;
    private ArrayList<HomeCatagoriesClass> mFilteredList;
    Context context;

    public HomeDataAdapter(ArrayList<HomeCatagoriesClass> arrayList, Context ctx) {

        mArrayList = arrayList;
        mFilteredList = arrayList;
         context=ctx;
    }

    @Override
    public HomeDataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeDataAdapter.ViewHolder viewHolder, final int i) {



       // qImageView.setImageResource(R.drawable.img2);

        viewHolder.categoryimg.setImageResource(mFilteredList.get(i).getImagepath());
        viewHolder.categoryname.setText(mFilteredList.get(i).getCategoryName());
        final int img = mFilteredList.get(i).getImagepath();
        final String catname=mFilteredList.get(i).getCategoryName();
        final int index=i;

       viewHolder.categoryClick.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Toast.makeText(context,""+catname+" "+i,Toast.LENGTH_SHORT).show();
               Intent i=new Intent(context,SubCategoryActivity.class);
               Bundle bundle = new Bundle();
               bundle.putString("catInfoTitle", catname);
               bundle.putInt("catInfoIndex", index);
               bundle.putInt("catInfoImg", img);
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

                    ArrayList<HomeCatagoriesClass> filteredList = new ArrayList<>();

                    for (HomeCatagoriesClass catagories : mArrayList) {

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
                mFilteredList = (ArrayList<HomeCatagoriesClass>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    ImageView categoryimg;
    TextView  categoryname;
    LinearLayout categoryClick;
        public ViewHolder(View view) {
            super(view);

          categoryimg=(ImageView)view.findViewById(R.id.categoryimg);
            categoryname=(TextView) view.findViewById(R.id.categoryname);
            categoryClick=(LinearLayout)view.findViewById(R.id.categoryClick);


        }
    }

}