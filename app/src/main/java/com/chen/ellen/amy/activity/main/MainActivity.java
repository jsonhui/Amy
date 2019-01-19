package com.chen.ellen.amy.activity.main;

import com.chen.ellen.amy.R;
import com.chen.ellen.amy.base.BaseActivity;

public class MainActivity extends BaseActivity<MainPresenter> implements MainArgee.MainView {
    @Override
    protected Boolean setOrientation() {
        return true;
    }

    @Override
    protected void initView() {

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
}
