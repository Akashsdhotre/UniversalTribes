package com.example.akash.universaltribes;

/**
 * Created by Akash on 4/8/2018.
 */

public class CartClass {
    int cartimmg;
    String cartcat,cartsubcat,cartprice;

    public CartClass(int cartimmg, String cartcat, String cartsubcat, String cartprice) {
        this.cartimmg = cartimmg;
        this.cartcat = cartcat;
        this.cartsubcat = cartsubcat;
        this.cartprice = cartprice;
    }


    public void setCartimmg(int cartimmg) {
        this.cartimmg = cartimmg;
    }

    public void setCartcat(String cartcat) {
        this.cartcat = cartcat;
    }

    public void setCartsubcat(String cartsubcat) {
        this.cartsubcat = cartsubcat;
    }

    public void setCartprice(String cartprice) {
        this.cartprice = cartprice;
    }

    public int getCartimmg() {
        return cartimmg;
    }

    public String getCartcat() {
        return cartcat;
    }

    public String getCartsubcat() {
        return cartsubcat;
    }

    public String getCartprice() {
        return cartprice;
    }

}

