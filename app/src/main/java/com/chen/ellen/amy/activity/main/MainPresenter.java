package com.chen.ellen.amy.activity.main;

import android.content.Context;

import com.chen.ellen.amy.bean.Music;
import com.chen.ellen.amy.util.ToastUtils;

import java.util.List;

public class MainPresenter extends MainArgee.MainPresenter {
    @Override
    public void showMusicData(Context context) {
        List<Music> musicList = mModel.getLocalAllMusic(context);
        mView.showMusicData(musicList);
    }
}
