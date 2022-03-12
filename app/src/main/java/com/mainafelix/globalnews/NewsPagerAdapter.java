package com.mainafelix.globalnews;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.mainafelix.globalnews.models.Article;
import com.mainafelix.globalnews.ui.NewsFragment;

import java.util.List;

public class NewsPagerAdapter extends FragmentPagerAdapter {

        private List<Article>headlines;

        public NewsPagerAdapter(@NonNull FragmentManager fm, int behavior, List<Article> article) {
            super(fm, behavior);
           headlines = article;
        }

        @Override
        public Fragment getItem(int position) {
            return NewsFragment.newInstance(headlines.get(position));
        }

        @Override
        public int getCount() {
            Log.d("debug ",headlines.toString());
            return headlines.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return headlines.get(position).getTitle();
        }
    }

