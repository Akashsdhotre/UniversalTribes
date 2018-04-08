package com.example.akash.universaltribes;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SubCategoryActivity extends AppCompatActivity {
    String catInfoTitle;
    int catInfoIndex, catInfoImg;
    public static SubCategoryDataAdapter adapter;
    RecyclerView recyclerView;
    NestedScrollView nested;
    AppBarLayout appBarLayout;
    int selectedImageArray[];
    public static int imageArray1[] = {R.drawable.unisplash1, R.drawable.unisplash1, R.drawable.unisplash1, R.drawable.unisplash1, R.drawable.unisplash1,
            R.drawable.unisplash1, R.drawable.unisplash1, R.drawable.unisplash1, R.drawable.unisplash1, R.drawable.unisplash1};
    public static int imageArray2[] = {R.drawable.unisplash1, R.drawable.unisplash1, R.drawable.unisplash1, R.drawable.unisplash1, R.drawable.unisplash1};
    public static int imageArray3[] = {R.drawable.unisplash1, R.drawable.unisplash1, R.drawable.unisplash1, R.drawable.unisplash1, R.drawable.unisplash1};
    public static int imageArray4[] = {R.drawable.unisplash1, R.drawable.unisplash1, R.drawable.unisplash1, R.drawable.unisplash1, R.drawable.unisplash1};
    public static int imageArray5[] = {R.drawable.unisplash1, R.drawable.unisplash1, R.drawable.unisplash1, R.drawable.unisplash1, R.drawable.unisplash1};
    public static int imageArray6[] = {R.drawable.unisplash1, R.drawable.unisplash1, R.drawable.unisplash1, R.drawable.unisplash1, R.drawable.unisplash1};
    String selectedTitleArray[];
    public static String titleArray1[] = {"subcat11", "subcat11", "subcat11", "subcat11", "subcat11","subcat11", "subcat11", "subcat11", "subcat11", "subcat11"};
    public static String titleArray2[] =  {"subcat12", "subcat12", "subcat12", "subcat12", "subcat12"};
    public static String titleArray3[] = {"subcat13", "subcat13", "subcat13", "subcat13", "subcat13"};
    public static String titleArray4[] =  {"subcat14", "subcat14", "subcat14", "subcat14", "subcat14"};
    public static String titleArray5[] = {"subcat15", "subcat15", "subcat15", "subcat15", "subcat15"};
    public static String titleArray6[] =  {"subcat16", "subcat16", "subcat16", "subcat16", "subcat16"};
    int selectedDescArray[];
    public static int desctitleArray1[] = {R.string.app_name,R.string.app_name,R.string.app_name,R.string.app_name,R.string.app_name,R.string.app_name,R.string.app_name,R.string.app_name,R.string.app_name,R.string.app_name,R.string.app_name,R.string.app_name};
    public static int desctitleArray2[] =  {R.string.app_name,R.string.app_name,R.string.app_name,R.string.app_name,R.string.app_name,R.string.app_name};
    public static int desctitleArray3[] = {R.string.app_name,R.string.app_name,R.string.app_name,R.string.app_name,R.string.app_name,R.string.app_name};
    public static int desctitleArray4[] =  {R.string.app_name,R.string.app_name,R.string.app_name,R.string.app_name,R.string.app_name,R.string.app_name};
    public static int desctitleArray5[] = {R.string.app_name,R.string.app_name,R.string.app_name,R.string.app_name,R.string.app_name,R.string.app_name};
    public static int desctitleArray6[] =  {R.string.app_name,R.string.app_name,R.string.app_name,R.string.app_name,R.string.app_name,R.string.app_name};
    String selectedPriceArray[];
    public static String priceArray1[] = {"100", "100", "100", "100", "100","100", "100", "100", "100", "100"};
    public static String priceArray2[] =  {"100", "100", "100", "100", "100"};
    public static String priceArray3[] = {"100", "100", "100", "100", "100"};
    public static String priceArray4[] =  {"100", "100", "100", "100", "100"};
    public static String priceArray5[] = {"100", "100", "100", "100", "100"};
    public static String priceArray6[] =  {"100", "100", "100", "100", "100"};

    private ArrayList<SubCategoryClass> alldata = new ArrayList<>();

    private ImageView subTitleImg ;
    private TextView subTitleDesc ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category3);
        System.out.println("reached");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Bundle bundle = getIntent().getExtras();
        catInfoTitle = bundle.getString("catInfoTitle");
        catInfoIndex = bundle.getInt("catInfoIndex");
        catInfoImg = bundle.getInt("catInfoImg");
        toolbar.setTitle(catInfoTitle);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
         subTitleImg = findViewById(R.id.subtitlecategoryimg);
         subTitleDesc = findViewById(R.id.subtitlecategorydesc);
         subTitleImg.setImageResource(catInfoImg);
//        nested = findViewById(R.id.nestedscroll);
//        appBarLayout = findViewById(R.id.appbarlayout);
//        getActionBar().setTitle(catInfoTitle);
        subTitleDesc.setText(getString(HomeActivity.descArray[catInfoIndex]));
//nested.fullScroll(View.FOCUS_UP);
//nested.scrollTo(0,0);
//appBarLayout.setExpanded(true);
//        int toolbarHeight = toolbar.getHeight();
//        nested.startNestedScroll(ViewCompat.SCROLL_AXIS_VERTICAL);
//        nested.dispatchNestedPreScroll(0, toolbarHeight, null, null);
//        nested.dispatchNestedScroll(0, 0, 0, 0, new int[]{0, -toolbarHeight});
//        nested.scrollTo(0, nested.getBottom());
         recyclerView = findViewById(R.id.sub_card_recycler_view);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(SubCategoryActivity.this, 2);
        recyclerView.setLayoutManager(mGridLayoutManager);

        prepareMovieData();

        adapter = new SubCategoryDataAdapter(alldata,this,catInfoTitle,catInfoImg,catInfoIndex);
        recyclerView.setAdapter(adapter);
    }

    private void prepareMovieData() {
        switch(catInfoIndex)
        {
            case 0: selectedImageArray = imageArray1;selectedTitleArray = titleArray1;
                selectedDescArray = desctitleArray1;
                selectedPriceArray = priceArray1;
                break;

            case 1:  selectedImageArray = imageArray2;selectedTitleArray = titleArray2;
            selectedDescArray = desctitleArray2;
                selectedPriceArray = priceArray2;
                break;

            case 2:  selectedImageArray = imageArray3;selectedTitleArray = titleArray3;
            selectedDescArray = desctitleArray3;
                selectedPriceArray = priceArray3;
                break;

            case 3:  selectedImageArray = imageArray4;selectedTitleArray = titleArray4;
            selectedDescArray = desctitleArray4;
                selectedPriceArray = priceArray4;
                break;

            case 4:  selectedImageArray = imageArray5;selectedTitleArray = titleArray5;
            selectedDescArray = desctitleArray5;
                selectedPriceArray = priceArray5;
                break;

            case 5:  selectedImageArray = imageArray6;selectedTitleArray = titleArray6;
            selectedDescArray = desctitleArray6;
                selectedPriceArray = priceArray6;
                break;

        }

        SubCategoryClass category;

        if(selectedImageArray.length == selectedTitleArray.length) {
        for(int i=0;i<selectedImageArray.length;i++)
        {
            category = new SubCategoryClass(selectedImageArray[i], selectedTitleArray[i],selectedDescArray[i],selectedPriceArray[i]);
            alldata.add(category);
        }
        }

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
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
