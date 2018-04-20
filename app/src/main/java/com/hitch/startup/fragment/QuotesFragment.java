package com.hitch.startup.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hitch.startup.R;
import com.hitch.startup.adapter.QuotesAdapter;
import com.hitch.startup.model.Quotes;

/**
 * Created by XWSPH on 08/08/2017.
 */

public class QuotesFragment extends Fragment {

    private CardView cardView;
    static Quotes q;

    public static Fragment getInstance(int position, Quotes q) {
        QuotesFragment f = new QuotesFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        args.putString("quotes", q.getContent());
        f.setArguments(args);

        return f;
    }

    @SuppressLint("DefaultLocale")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_quotes, container, false);

        cardView = (CardView) view.findViewById(R.id.cardView);
        cardView.setMaxCardElevation(cardView.getCardElevation() * QuotesAdapter.MAX_ELEVATION_FACTOR);

        TextView title = (TextView) view.findViewById(R.id.title);
        TextView content = (TextView) view.findViewById(R.id.content_quotes);

        ImageView copy_txt = view.findViewById(R.id.copy_text);
        ImageView share = view.findViewById(R.id.share_quotes);
        ImageView fav = view.findViewById(R.id.favourite_quotes);

        title.setText(String.format("Card %d", getArguments().getInt("position")));
        content.setText(getArguments().getString("quotes"));

        copy_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Copy", Toast.LENGTH_SHORT).show();
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Share", Toast.LENGTH_SHORT).show();
            }
        });

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Favourite", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    public CardView getCardView() {
        return cardView;
    }
}
