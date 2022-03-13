package com.mainafelix.globalnews.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.mainafelix.globalnews.models.Article;
import com.mainafelix.globalnews.ui.NewsFragmen;

import java.util.List;

public class NewsViewPagerAdapter extends FragmentPagerAdapter {

    private List<Article> headlines;

    public NewsViewPagerAdapter(@NonNull FragmentManager fm, int behavior, List<Article> articles) {
        super(fm, behavior);
        headlines = articles;
    }

    @Override
    public Fragment getItem(int position) {
        return NewsFragmen.newInstance(headlines.get(position));
    }

    @Override
    public int getCount() {
        return headlines.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return headlines.get(position).getTitle();
    }
}
