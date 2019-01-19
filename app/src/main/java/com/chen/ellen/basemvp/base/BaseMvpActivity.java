package com.chen.ellen.basemvp.base;

import android.support.v7.app.AppCompatActivity;

import com.chen.ellen.basemvp.presenter.BasePresenter;
import com.chen.ellen.basemvp.view.BaseView;

public class BaseMvpActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {
    protected P mPresenter;
}
