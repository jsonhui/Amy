package com.chen.ellen.amy.basemvp.base;

import android.support.v7.app.AppCompatActivity;

import com.chen.ellen.amy.basemvp.presenter.BasePresenter;
import com.chen.ellen.amy.basemvp.view.BaseView;

public class BaseMvpActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {
    protected P mPresenter;
}
