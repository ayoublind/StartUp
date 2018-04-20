package com.hitch.startup.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;


import com.hitch.startup.R;
import com.hitch.startup.fragment.QuotesFragment;
import com.hitch.startup.model.Quotes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XWSPH on 08/08/2017.
 */

public class QuotesFragmentPagerAdapter extends FragmentStatePagerAdapter implements QuotesAdapter {

    private List<Quotes> quotes;

    private List<QuotesFragment> fragments;
    private float baseElevation;

    public QuotesFragmentPagerAdapter(FragmentManager fm, float baseElevation) {
        super(fm);
        fragments = new ArrayList<>();
        this.baseElevation = baseElevation;
        quotes = getAllQuotes();

        for(int i = 0; i< quotes.size(); i++){
            QuotesFragment f = new QuotesFragment();

            Bundle args = new Bundle();

            args.putInt("position", i);
            args.putString("quotes", quotes.get(i).getContent());
            f.setArguments(args);

            addCardFragment(f );
        }
    }

    private List<Quotes> getAllQuotes() {
        List<Quotes> ls = new ArrayList<>();

        Quotes q = new Quotes("auteur"," Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n" +
                "      Quisque tincidunt leo vitae quam posuere mattis. Etiam egestas velit sit amet nisi viverra, et auctor ipsum ornare.\n" +
                "      Etiam pharetra, metus feugiat porttitor dapibus, est magna accumsan odio, sed tincidunt sapien tellus id sapien.\n" +
                "      Nulla non tincidunt massa. Curabitur tincidunt blandit consequat. Integer condimentum nunc a tempus viverra.\n" +
                "      Cras commodo velit elit, sit amet lobortis nisl accumsan a", "date");
        ls.add(q);

        q = new Quotes("auteur","Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n" +
                "      Quisque tincidunt leo vitae quam posuere mattis. Etiam egestas velit sit amet nisi viverra, et auctor ipsum ornare.\n" +
                "      Etiam pharetra, metus feugiat porttitor dapibus, est magna accumsan odio, sed tincidunt sapien tellus id sapien.\n" +
                "      Nulla non tincidunt massa. Curabitur tincidunt blandit consequat. Integer condimentum nunc a tempus viverra.\n" +
                "      Cras commodo velit elit, sit amet lobortis nisl accumsan a", "date");
        ls.add(q);

        q = new Quotes("auteur", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n" +
                "      Quisque tincidunt leo vitae quam posuere mattis. Etiam egestas velit sit amet nisi viverra, et auctor ipsum ornare.\n" +
                "      Etiam pharetra, metus feugiat porttitor dapibus, est magna accumsan odio, sed tincidunt sapien tellus id sapien.\n" +
                "      Nulla non tincidunt massa. Curabitur tincidunt blandit consequat. Integer condimentum nunc a tempus viverra.\n" +
                "      Cras commodo velit elit, sit amet lobortis nisl accumsan a", "date");
        ls.add(q);

        q = new Quotes("auteur", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n" +
                "      Quisque tincidunt leo vitae quam posuere mattis. Etiam egestas velit sit amet nisi viverra, et auctor ipsum ornare.\n" +
                "      Etiam pharetra, metus feugiat porttitor dapibus, est magna accumsan odio, sed tincidunt sapien tellus id sapien.\n" +
                "      Nulla non tincidunt massa. Curabitur tincidunt blandit consequat. Integer condimentum nunc a tempus viverra.\n" +
                "      Cras commodo velit elit, sit amet lobortis nisl accumsan a", "date");
        ls.add(q);

        q = new Quotes("auteur",String.valueOf(R.string.lorem_ipsum), "date");
        ls.add(q);

        q = new Quotes("auteur",String.valueOf(R.string.lorem_ipsum), "date");
        ls.add(q);

        q = new Quotes("auteur",String.valueOf(R.string.lorem_ipsum), "date");
        ls.add(q);

        q = new Quotes("auteur",String.valueOf(R.string.lorem_ipsum), "date");
        ls.add(q);

        q = new Quotes("auteur",String.valueOf(R.string.lorem_ipsum), "date");
        ls.add(q);

        q = new Quotes("auteur",String.valueOf(R.string.lorem_ipsum), "date");
        ls.add(q);

        return ls;
    }

    @Override
    public float getBaseElevation() {
        return baseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return fragments.get(position).getCardView();
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return QuotesFragment.getInstance(position, quotes.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object fragment = super.instantiateItem(container, position);
        fragments.set(position, (QuotesFragment) fragment);
        return fragment;
    }

    public void addCardFragment(QuotesFragment fragment) {
        fragments.add(fragment);
    }
}
