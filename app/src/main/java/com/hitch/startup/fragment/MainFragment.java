package com.hitch.startup.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


import com.hitch.startup.R;
import com.hitch.startup.activity.GalleryActivity;
import com.hitch.startup.activity.QuotesActivity;
import com.hitch.startup.activity.TestActivity;
import com.hitch.startup.adapter.StartupAdapter;
import com.hitch.startup.model.StartUp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XWSPH on 08/08/2017.
 */

public class MainFragment extends Fragment {

    RecyclerView recyclerView;
    StartupAdapter adapter;
    List<StartUp> startUpList;

    FloatingActionButton fab, fab_images, fab_quotes, fab_q;

    Animation fabOpen, fabClose, fabClockView, fabRotateClick;

    boolean isOpen = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        startUpList = new ArrayList<>();
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        adapter = new StartupAdapter(getActivity(), startUpList);

        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab_images = (FloatingActionButton) view.findViewById(R.id.fab_images);
        fab_quotes = (FloatingActionButton) view.findViewById(R.id.fab_quotes);
        fab_q = (FloatingActionButton) view.findViewById(R.id.fab_q);

        //animation
        fabOpen = AnimationUtils.loadAnimation(getContext(), R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(getContext(), R.anim.fab_close);
        fabClockView = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_clock);
        fabRotateClick = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_anticlock);

        //config recycler

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        loadData();


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isOpen){
                    closeFabs();
                }else{
                    openFabs();
                }
            }
        });

        fab_images.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeFabs();
                //rderict to the activity gallery
                Intent i = new Intent(getContext(), GalleryActivity.class);
                startActivity(i);
            }
        });
        fab_quotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeFabs();
                //rderict to the quotes activity
                Intent i = new Intent(getContext(), QuotesActivity.class);
                startActivity(i);
            }
        });
        fab_q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeFabs();
                //rderict to the quotes activity
                Intent i = new Intent(getContext(), TestActivity.class);
                startActivity(i);
            }
        });
    }
    public void loadData(){
        startUpList.clear();

        StartUp startUp = new StartUp(1,"getting","#hash","ayoub","www.moul.com",R.drawable.logo);
        startUpList.add(startUp);

        startUp = new StartUp(1,"getting","#hash","ayoub","www.moul.com",R.drawable.image6);
        startUpList.add(startUp);

        startUp = new StartUp(2,"getting","#hash","ayoub","www.moul.com",R.drawable.image10);
        startUpList.add(startUp);

        startUp = new StartUp(3,"getting","#hash","ayoub","www.moul.com",R.drawable.image1);
        startUpList.add(startUp);

        startUp = new StartUp(4,"getting","#hash","ayoub","www.moul.com",R.drawable.image7);
        startUpList.add(startUp);

        startUp = new StartUp(5,"getting","#hash","ayoub","www.moul.com",R.drawable.crew);
        startUpList.add(startUp);

        adapter.notifyDataSetChanged();
    }

    //methode to close the fabs
    public void closeFabs(){
        fab_images.startAnimation(fabClose);
        fab_quotes.startAnimation(fabClose);
        fab_q.startAnimation(fabClose);

        fab.startAnimation(fabRotateClick);

        fab_images.setClickable(false);
        fab_quotes.setClickable(false);

        fab_images.setVisibility(View.GONE);
        fab_quotes.setVisibility(View.GONE);
        fab_q.setVisibility(View.GONE);

        isOpen = false;
    }
    //open the fabs
    public void openFabs(){
        fab_images.startAnimation(fabOpen);
        fab_quotes.setAnimation(fabOpen);
        fab_q.setAnimation(fabOpen);

        fab.startAnimation(fabClockView);

        fab_images.setClickable(true);
        fab_quotes.setClickable(true);
        fab_q.setClickable(true);

        fab_images.setVisibility(View.VISIBLE);
        fab_quotes.setVisibility(View.VISIBLE);
        fab_q.setVisibility(View.VISIBLE);

        isOpen = true;
    }

}
