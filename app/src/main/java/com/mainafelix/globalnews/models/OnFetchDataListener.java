package com.mainafelix.globalnews.models;

import com.mainafelix.globalnews.models.Article;

import java.util.List;

public interface OnFetchDataListener<NewsCollection> {
    void OnFetchData(List<Article>list,String message);
    void OnError (String message);
}