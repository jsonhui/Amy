package com.chen.ellen.amy.activity.splash;

import com.chen.ellen.amy.basemvp.model.SimpleBaseModel;
import com.chen.ellen.amy.basemvp.presenter.BasePresenter;
import com.chen.ellen.amy.basemvp.view.BaseView;

public interface SplashArgee {

    interface SplashModel extends SimpleBaseModel {

    }

    interface SplashView extends BaseView{

    }

    abstract class SplashPresenter extends BasePresenter<SplashModel,SplashView>{

    }
}
