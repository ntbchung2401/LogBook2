package com.example.logbook2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button backward, forward,add_URL;
    ImageView imageView;
    ArrayList<String> imageList;
    private  int index = 0;
    EditText inputURL;
    public String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.img_view);
        imageList = new ArrayList<>();

        backward = findViewById(R.id.backward);
        forward = findViewById(R.id.forward);
        inputURL = findViewById(R.id.inputURL);
        add_URL = findViewById(R.id.add_URL);

        imageList.add(0,"https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/golden-retriever-royalty-free-image-506756303-1560962726.jpg");
        imageList.add(1,"https://ggsc.s3.amazonaws.com/images/uploads/The_Science-Backed_Benefits_of_Being_a_Dog_Owner.jpg");
        imageList.add(2,"https://www.princeton.edu/sites/default/files/styles/half_2x/public/images/2022/02/KOA_Nassau_2697x1517.jpg");
        imageList.add(3,"https://media-cldnry.s-nbcnews.com/image/upload/rockcms/2022-08/220805-border-collie-play-mn-1100-82d2f1.jpg");


        add_URL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = inputURL.getText().toString().trim();
                if(url.length() !=0 ) {
                    Glide.with(MainActivity.this)
                            .load(url)
                            .apply(new RequestOptions().transform(new CenterCrop()).transform(new RoundedCorners(12)))
                            .into(imageView);
                imageList.add((url));
                Toast.makeText(MainActivity.this, "Add successfully!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void previousImage(View view) {
        index++;
        if(index >= imageList.size()){
            index = 0;
        }
        loadImage();
    }

    public void nextImage(View view) {
        index --;
        if(index <= -1){
            index = imageList.size() - 1;
        }
        loadImage();
    }

    private void loadImage(){
        Glide.with(MainActivity.this)
                .load(imageList.get(index))
                .apply(new RequestOptions().transform(new CenterCrop()).transform(new RoundedCorners(12)))
                .into(imageView);
    }
}