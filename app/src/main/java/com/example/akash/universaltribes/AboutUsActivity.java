package com.example.akash.universaltribes;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class AboutUsActivity extends AppCompatActivity {
ImageView img ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        img = findViewById(R.id.aboutusimg);

         String s="https://drive.google.com/file/d/1Shde16fPuqPOC99mRZJ_K358rblUjDr0/view";
         String[] p=s.split("/");
         String imageLink="https://drive.google.com/uc?export=download&id="+p[5];
         Picasso.with(this).load(imageLink).into(img);

//        Picasso.with(this)
//                .load("https://drive.google.com/file/d/1Shde16fPuqPOC99mRZJ_K358rblUjDr0/view")
////                .placeholder(R.drawable.placeholder)   // optional
////                .error(R.drawable.error)      // optional
//                .resize(500,500)                 // optional
//                .into(img);

//        Picasso.with(this)
//                .load(Uri.parse(getItem(position).getStoryBigThumbUrl()))
//                .networkPolicy(NetworkPolicy.OFFLINE)
//                .into(holder.storyBigThumb, new Callback() {
//                    @Override
//                    public void onSuccess() {
//
//                    }
//                    @Override
//                    public void onError() {
//                        // Try again online if cache failed
//                                               Picasso.with(context)
//                                                     .load(Uri.parse(getItem(position)
//                                                                  .getStoryBigThumbUrl()))
//                                          .placeholder(R.drawable.user_placeholder)
//                                   .error(R.drawable.user_placeholder_error)
//                                     .into(holder.storyBigThumb);
//                         }
//                             });

    }
}
