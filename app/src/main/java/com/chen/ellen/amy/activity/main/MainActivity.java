package com.chen.ellen.amy.activity.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chen.ellen.amy.R;
import com.chen.ellen.amy.adapter.LocalMusicAdapter;
import com.chen.ellen.amy.base.BaseActivity;
import com.chen.ellen.amy.bean.Music;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainArgee.MainView {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

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
        recyclerView.setAdapter(new LocalMusicAdapter(context,musicList));
    }
}
