package com.chen.ellen.amy.activity.main;

import android.content.Context;

import com.chen.ellen.amy.bean.Music;
import com.chen.ellen.amy.util.ContentProviderUtils;

import java.util.List;

public class MainModel implements MainArgee.MainModel {

    @Override
    public List<Music> getLocalAllMusic(Context context) {
        return ContentProviderUtils.getInstance(context).getMusics();
    }
}
