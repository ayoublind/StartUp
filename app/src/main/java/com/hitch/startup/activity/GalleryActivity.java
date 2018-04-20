package com.hitch.startup.activity;

import android.app.ProgressDialog;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.hitch.startup.R;
import com.hitch.startup.adapter.GalleryAdapter;
import com.hitch.startup.model.Image;

import java.util.ArrayList;

/**
 * Created by XWSPH on 08/08/2017.
 */
public class GalleryActivity extends AppCompatActivity {

    private ArrayList<Image> images;
    private ProgressDialog pDialog;
    private GalleryAdapter mAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_layout);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        pDialog = new ProgressDialog(this);
        images = new ArrayList<>();
        mAdapter = new GalleryAdapter(getApplicationContext(), images);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new GalleryAdapter.RecyclerTouchListener(getApplicationContext(), recyclerView, new GalleryAdapter.ClickListener() {
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

        mAdapter.notifyDataSetChanged();
    }

}
