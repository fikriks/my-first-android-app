package com.fikri.footballapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {
    public static final String NAME = "name";
    public static final String IMAGE = "image";
    public static final String ABOUT = "about";
    public static final String COACH = "coach";
    public static final String TITLE = "title";
    TextView tvTitle,tvName,tvAbout,tvCoach;
    ImageView ivImage;
    String name,about,coach;
    int img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvTitle = findViewById(R.id.tv_item_title_detail);
        tvName = findViewById(R.id.tv_item_name_detail);
        tvAbout = findViewById(R.id.tv_about);
        tvCoach = findViewById(R.id.tv_coach);
        ivImage = findViewById(R.id.img_item_detail);

        name = getIntent().getStringExtra(NAME);
        about = getIntent().getStringExtra(ABOUT);
        coach = getIntent().getStringExtra(COACH);
        img = getIntent().getIntExtra(IMAGE,0);

        setActionBarTitle(name);

        tvTitle.setText(name);
        tvName.setText(name);
        tvAbout.setText(about);
        tvCoach.setText(coach);

        Glide.with(this).load(img).into(ivImage);
    }

    private void setActionBarTitle(String title){
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}
