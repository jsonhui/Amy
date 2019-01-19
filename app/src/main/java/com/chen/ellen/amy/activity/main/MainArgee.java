package com.chen.ellen.amy.activity.main;

import android.content.Context;

import com.chen.ellen.amy.basemvp.model.BaseModel;
import com.chen.ellen.amy.basemvp.presenter.BasePresenter;
import com.chen.ellen.amy.basemvp.view.BaseView;
import com.chen.ellen.amy.bean.Music;

import java.util.List;

public interface MainArgee {

    interface MainModel extends BaseModel{

        List<Music> getLocalAllMusic(Context context);

    }

    interface MainView extends BaseView{

        void showMusicData(List<Music> musicList);

    }

    abstract class MainPresenter extends BasePresenter<MainModel,MainView>{

        public abstract void showMusicData(Context context);

    }
}
