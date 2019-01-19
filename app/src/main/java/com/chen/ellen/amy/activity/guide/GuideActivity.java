package com.chen.ellen.amy.activity.guide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.chen.ellen.amy.R;
import com.chen.ellen.amy.activity.guide.GuideAgree.GuideView;
import com.chen.ellen.amy.activity.main.MainActivity;
import com.chen.ellen.amy.activity.splash.SplashActivity;
import com.chen.ellen.amy.base.BaseActivity;
import com.chen.ellen.amy.util.MMKVUtils;
import com.chen.ellen.amy.util.ToastUtils;

import butterknife.BindView;

public class GuideActivity extends BaseActivity<GuidePresenter> implements GuideView {

    @BindView(R.id.vp_guide)
    ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!mPresenter.getIsFirstLauncher()) {
           jumpToActivvity(SplashActivity.class);
        }
    }

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
        return R.layout.activity_guide;
    }

    @Override
    protected void initMvp() {
        mPresenter = new GuidePresenter();
        mPresenter.mModel = new GuideModel();
        mPresenter.mView = this;
    }
}
