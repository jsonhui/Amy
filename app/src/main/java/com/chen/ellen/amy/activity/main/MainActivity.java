package com.chen.ellen.amy.activity.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chen.ellen.amy.R;
import com.chen.ellen.amy.adapter.LocalMusicAdapter;
import com.chen.ellen.amy.base.BaseActivity;
import com.chen.ellen.amy.bean.Music;
import com.chen.ellen.amy.util.MediaPlayerUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements MainArgee.MainView {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.tv_paly_name)
    TextView name;
    @BindView(R.id.tv_play_singer_name)
    TextView singerName;
    @BindView(R.id.tv_start_pause)
    TextView startPause;


    @OnClick({R.id.tv_start_pause,R.id.tv_next})
    void onClick(View view){
        switch (view.getId()) {
            case R.id.tv_start_pause:
            boolean isPlaying = MediaPlayerUtils.getInstance(this).startAndPause();
            if (isPlaying) {
                startPause.setText("暂停");
            } else {
                startPause.setText("播放");
            }
            break;
            case R.id.tv_next:
                MediaPlayerUtils.getInstance(this).next();
                break;
        }
    }

    @Override
    protected Boolean setOrientation() {
        return true;
    }

    @Override
    protected void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        mPresenter.showMusicData(context);
    }

    @Override
    protected void initData() {

    }

    public void updatePlay(Music music){
        name.setText(music.getName());
        singerName.setText(music.getSingerName());
        if(MediaPlayerUtils.getInstance(this).isPlaying()){
            startPause.setText("暂停");
        }else {
            startPause.setText("播放");
        }
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initMvp() {
       mPresenter = new MainPresenter();
       mPresenter.mModel = new MainModel();
       mPresenter.mView = this;
    }

    @Override
    public void showMusicData(List<Music> musicList) {
        recyclerView.setAdapter(new LocalMusicAdapter(context,this,musicList));
    }
}
