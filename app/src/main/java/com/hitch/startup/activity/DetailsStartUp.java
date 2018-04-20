package com.hitch.startup.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.hitch.startup.R;
import com.hitch.startup.adapter.GalleryAdapter;
import com.hitch.startup.model.Image;

import java.util.ArrayList;

/**
 * Created by XWSPH on 08/08/2017.
 */

public class DetailsStartUp extends AppCompatActivity {

    ImageView logo;

    RecyclerView prjs;
    GalleryAdapter adapter;
    ArrayList<Image> images;

    FloatingActionButton shareStup;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_startup);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //init comps
        prjs = (RecyclerView) findViewById(R.id.prjs);
        shareStup = (FloatingActionButton) findViewById(R.id.shareStup);

        shareStup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailsStartUp.this, "Share Content", Toast.LENGTH_SHORT).show();
            }
        });

        //recycler
        images = new ArrayList<>();
        adapter = new GalleryAdapter(getApplicationContext(), images);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 3);
        prjs.setLayoutManager(mLayoutManager);
        prjs.setItemAnimator(new DefaultItemAnimator());
        prjs.setAdapter(adapter);

        prjs.addOnItemTouchListener(new GalleryAdapter.RecyclerTouchListener(getApplicationContext(), prjs, new GalleryAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("images", images);
                bundle.putInt("position", position);

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                SlideshowDialogFragment newFragment = SlideshowDialogFragment.newInstance();
                newFragment.setArguments(bundle);
                newFragment.show(ft, "slideshow");
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        fetchImages();
    }

    private void fetchImages() {
        Image image = new Image("name", R.drawable.image7, R.drawable.image7, R.drawable.image7, "timestamp");
        images.add(image);

        image = new Image("name 1", R.drawable.image6, R.drawable.image6, R.drawable.image6, "timestamp");
        images.add(image);

        image = new Image("name 2", R.drawable.image1, R.drawable.image1, R.drawable.image1, "timestamp");
        images.add(image);

        image = new Image("name 3", R.drawable.image10, R.drawable.image10, R.drawable.image10, "timestamp");
        images.add(image);

        image = new Image("name 4", R.drawable.logo, R.drawable.logo, R.drawable.logo, "timestamp");
        images.add(image);

        image = new Image("name 5", R.drawable.crew, R.drawable.crew, R.drawable.crew, "timestamp");
        images.add(image);

        image = new Image("name 6", R.drawable.common_full_open_on_phone, R.drawable.common_full_open_on_phone, R.drawable.common_full_open_on_phone, "timestamp");
        images.add(image);

        adapter.notifyDataSetChanged();
    }
}
