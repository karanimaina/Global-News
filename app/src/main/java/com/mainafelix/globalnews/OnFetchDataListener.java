package com.mainafelix.globalnews;

import com.mainafelix.globalnews.models.Article;

import java.util.List;

public interface OnFetchDataListener {
    void OnFetchData(List<Article>list,String message);
    void OnError (String message);
}
