package com.example.akash.universaltribes;

/**
 * Created by Akash on 4/7/2018.
 */

public class SubCategoryClass {

    int imagepath;
    String categoryName;
    int categoryDesc;
    String price;

    public SubCategoryClass(int imagepath, String categoryName, int categoryDesc,String price) {
        this.imagepath = imagepath;
        this.categoryName = categoryName;
        this.categoryDesc = categoryDesc;
        this.price = price;
    }

    public int getImagepath() {
        return imagepath;
    }

    public String getPrice() {
        return price;
    }

    public void setImagepath(int imagepath) {
        this.imagepath = imagepath;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public void setCategoryDesc(int categoryDesc) {
        this.categoryDesc = categoryDesc;
    }
}
