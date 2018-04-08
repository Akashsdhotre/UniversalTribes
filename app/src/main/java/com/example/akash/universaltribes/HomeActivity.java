package com.example.akash.universaltribes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    public static HomeDataAdapter adapter;
    RecyclerView recyclerView;
    public static int imageArray[] = {R.drawable.unisplash1, R.drawable.unisplash1, R.drawable.unisplash1, R.drawable.unisplash1, R.drawable.unisplash1,  R.drawable.unisplash1};
    public static String titleArray[] = {"title1","title2","title3","title4","title5","title6"};
    public static int descArray[] = {R.string.app_name,R.string.app_name,R.string.app_name,R.string.app_name,R.string.app_name,R.string.app_name};
    private ArrayList<HomeCatagoriesClass> alldata = new ArrayList<>();
    public static ArrayList<CartClass> cartdata = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HomeActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        prepareMovieData();

        adapter = new HomeDataAdapter(alldata,this);
        recyclerView.setAdapter(adapter);
    }


    private void prepareMovieData() {
        HomeCatagoriesClass category = new HomeCatagoriesClass(imageArray[0], titleArray[0]);
        alldata.add(category);

        category = new HomeCatagoriesClass(imageArray[1], titleArray[1]);
        alldata.add(category);

        category = new HomeCatagoriesClass(imageArray[2], titleArray[2]);
        alldata.add(category);

        category = new HomeCatagoriesClass(imageArray[3], titleArray[3]);
        alldata.add(category);

        category = new HomeCatagoriesClass(imageArray[4], titleArray[4]);
        alldata.add(category);

        category = new HomeCatagoriesClass(imageArray[5], titleArray[5]);
        alldata.add(category);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_cart:
                if(HomeActivity.cartdata.size()!=0) {
                    Intent i = new Intent(this, CartActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(this,"Cart is Empty",Toast.LENGTH_LONG).show();}
                return true;
            case R.id.menu_about:
                Intent i1 = new Intent(this, AboutUsActivity.class);
                startActivity(i1);
                return true;
            case R.id.menu_contact:
                Intent i2 = new Intent(this, ContactUsActivity.class);
                startActivity(i2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}


