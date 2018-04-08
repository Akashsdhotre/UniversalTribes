package com.example.akash.universaltribes;

/**
 * Created by Akash on 4/7/2018.
 */

public class HomeCatagoriesClass {

     int imagepath;
     String categoryName;

    public HomeCatagoriesClass(int imagepath, String categoryName) {
        this.imagepath = imagepath;
        this.categoryName = categoryName;
    }

    public int getImagepath() {
        return imagepath;
    }

    public void setImagepath(int imagepath) {
        this.imagepath = imagepath;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
