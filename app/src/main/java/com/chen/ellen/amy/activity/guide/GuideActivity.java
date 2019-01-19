package com.chen.ellen.amy.activity.guide;

import android.support.v4.view.ViewPager;

import com.chen.ellen.amy.R;
import com.chen.ellen.amy.activity.guide.GuideAgree.GuideView;
import com.chen.ellen.amy.base.BaseActivity;
import com.chen.ellen.basemvp.view.BaseView;

import butterknife.BindView;

public class GuideActivity extends BaseActivity<GuidePresenter> implements GuideView {

    @BindView(R.id.vp_guide)
    ViewPager viewPager;

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
        mPresenter = new GuidePresenter();
        mPresenter.mModel = new GuideModel();
        mPresenter.mView = this;
    }
}
