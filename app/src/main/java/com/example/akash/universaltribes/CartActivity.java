package com.example.akash.universaltribes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    public static int sumprice = 0;
    public static CartDataAdapter adapter;
    private RecyclerView recyclerView;
    public static TextView items,sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView = (RecyclerView) findViewById(R.id.cart_card_recycler_view);
        items =  findViewById(R.id.cartitemsxt);
        sum =  findViewById(R.id.cartsumtxt);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CartActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        calcprice();
        items.setText("Items : "+HomeActivity.cartdata.size());
        sum.setText("Total price : "+CartActivity.sumprice);
        adapter = new CartDataAdapter(HomeActivity.cartdata,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.cartmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_cart_clear:
                HomeActivity.cartdata.clear();
                CartActivity.sumprice = 0;
                Intent i = new Intent(this,HomeActivity.class);
                startActivity(i);
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
    void calcprice() {
        int sum = 0;
        for (int i = 0; i < HomeActivity.cartdata.size(); i++) {
            sum = sum + Integer.parseInt(HomeActivity.cartdata.get(i).getCartprice());
        }
        CartActivity.sumprice = sum;
    }

    public void placeOrder(View view) {
        Intent i = new Intent(this,EnquiryActivity.class);
        startActivity(i);
    }
}
