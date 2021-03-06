package com.chen.ellen.amy.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.chen.ellen.amy.basemvp.base.BaseMvpActivity;
import com.chen.ellen.amy.basemvp.presenter.BasePresenter;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter> extends BaseMvpActivity<P> {

    protected Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        ButterKnife.bind(this);
        context = this;
        initMvp();
        initView();
        initData();
        if(setOrientation() != null){
            if(setOrientation()){
                //设置竖屏
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }else {
                //设置横屏
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }
        }
    }

    protected abstract Boolean setOrientation();
    protected abstract void initView();
    protected abstract void initData();
    protected abstract int setLayout();
    protected abstract void initMvp();

    protected void jumpToActivity(Class activityClass){
        Intent intent = new Intent(context,activityClass);
        startActivity(intent);
    }

    protected void jumpToActivirtAndDestory(Class activityClass){
        Intent intent = new Intent(context,activityClass);
        startActivity(intent);
        finish();
    }
}
