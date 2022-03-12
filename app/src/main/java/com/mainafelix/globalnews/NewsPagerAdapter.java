package com.mainafelix.globalnews;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.mainafelix.globalnews.models.Article;
import com.mainafelix.globalnews.ui.NewsFragment;

import java.util.List;

public class NewsPagerAdapter extends FragmentPagerAdapter {

        private List<Article> news;

        public NewsPagerAdapter(@NonNull FragmentManager fm, int behavior, List<Article> news1) {
            super(fm, behavior);
            news = news1;
        }

        @Override
        public Fragment getItem(int position) {
            return NewsFragment.newInstance(news.get(position));
        }

        @Override
        public int getCount() {
            return news.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return news.get(position).getTitle();
        }
    }

