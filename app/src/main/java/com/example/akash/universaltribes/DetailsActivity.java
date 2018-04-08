package com.example.akash.universaltribes;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {
String catname,subcatname,price;
int catindex,catimg,subcatindex,subcatimg,subcatdesc;
ImageView detailsimg;
TextView detailstitletxt,detailsdesctxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detailstoolbar);
        Bundle bundle = getIntent().getExtras();
        catname = bundle.getString("catInfoTitle");
        catindex = bundle.getInt("catInfoIndex", 0);
        catimg = bundle.getInt("catInfoImg", R.drawable.unisplash1);
        subcatname = bundle.getString("subcatInfoTitle");
        subcatindex = bundle.getInt("subcatInfoIndex", 0);
        subcatimg = bundle.getInt("subcatInfoImg", R.drawable.unisplash1);
        subcatdesc = bundle.getInt("subcatInfoDesc", R.string.app_name);
        price = bundle.getString("subcatInfoPrice", "0");
        toolbar.setTitle(subcatname);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }else{ Toast.makeText(this,"nil",Toast.LENGTH_LONG).show();}
         detailsimg = findViewById(R.id.detailsimg);
         //detailstitletxt = findViewById(R.id.detailstxt);
         detailsdesctxt = findViewById(R.id.detailsdesctxt);

         detailsimg.setImageResource(subcatimg);
        // detailstitletxt.setText(subcatname);
         detailsdesctxt.setText(getString(subcatdesc));


    }

    public void addToCart(View view) {
        Toast.makeText(this,"added",Toast.LENGTH_SHORT).show();
        HomeActivity.cartdata.add(new CartClass(subcatimg, catname, subcatname, price));
    }


//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//
//        Intent i=new Intent(this,SubCategoryActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putString("catInfoTitle", catname);
//        bundle.putInt("catInfoIndex", catindex);
//        bundle.putInt("catInfoImg", catimg);
//        i.putExtras(bundle);
//        startActivity(i);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
//            case android.R.id.home:
//                Intent i=new Intent(this,SubCategoryActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("catInfoTitle", catname);
//                bundle.putInt("catInfoIndex", catindex);
//                bundle.putInt("catInfoImg", catimg);
//                i.putExtras(bundle);
//                startActivity(i);
//                return true;
                        case R.id.menu_cart:
                            if(HomeActivity.cartdata.size()!=0) {
                                Intent in = new Intent(this, CartActivity.class);
                                startActivity(in);
                            }
                            else {
                                Toast.makeText(this,"Cart is Empty",Toast.LENGTH_LONG).show();}
                            return true;
                        case R.id.menu_about:

                            return true;
                        case R.id.menu_contact:

                            return true;
                        default:
                            return super.onOptionsItemSelected(menuItem);
                    }
                }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
