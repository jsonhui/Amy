package com.chen.ellen.amy.activity.guide;

import android.widget.TextView;

import com.chen.ellen.amy.R;
import com.chen.ellen.amy.base.BaseActivity;
import com.chen.ellen.basemvp.base.BaseMvpActivity;

import butterknife.BindView;

public class GuideActivity extends BaseActivity<GuidePresenter> implements GuideView {

    @BindView(R.id.tv1)
    TextView textView;

    @Override
    protected Boolean setOrientation() {
        return true;
    }

    @Override
    protected void initView() {
      textView.setText("initView");
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
