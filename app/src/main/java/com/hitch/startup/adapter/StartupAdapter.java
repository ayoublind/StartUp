package com.hitch.startup.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hitch.startup.R;
import com.hitch.startup.activity.DetailsStartUp;
import com.hitch.startup.model.StartUp;

import java.util.List;

/**
 * Created by XWSPH on 08/08/2017.
 */

public class StartupAdapter extends RecyclerView.Adapter<StartupAdapter.MyViewHolder> {

    private Context mContext;
    private List<StartUp> list;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, hashtag, auteur;
        public ImageView images;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            hashtag = (TextView) view.findViewById(R.id.hashtag);
            auteur = (TextView) view.findViewById(R.id.auteur);
            images = (ImageView) view.findViewById(R.id.images);

        }
    }

    public StartupAdapter(Context mContext, List<StartUp> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public StartupAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.startup_item, parent, false);

        return new StartupAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final StartupAdapter.MyViewHolder holder, int position) {
        final StartUp b = list.get(position);

        holder.name.setText(b.getName());
        holder.hashtag.setText(b.getHashtag());
        holder.auteur.setText(b.getAuteur());

        // loading album cover using Glide library
        Glide.with(mContext).load(b.getImages()).into(holder.images);

        holder.images.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext, DetailsStartUp.class);

                //passing data
                mContext.startActivity(i);
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
}
