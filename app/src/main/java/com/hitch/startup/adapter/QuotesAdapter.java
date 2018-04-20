package com.hitch.startup.adapter;


import android.support.v7.widget.CardView;

public interface QuotesAdapter {

    public final int MAX_ELEVATION_FACTOR = 8;

    float getBaseElevation();

    CardView getCardViewAt(int position);

    int getCount();
}
