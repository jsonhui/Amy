package com.chen.ellen.amy.activity.main;

import com.chen.ellen.amy.basemvp.model.BaseModel;
import com.chen.ellen.amy.basemvp.presenter.BasePresenter;
import com.chen.ellen.amy.basemvp.view.BaseView;

public interface MainArgee {

    interface MainModel extends BaseModel{

    }

    interface MainView extends BaseView{

    }

    abstract class MainPresenter extends BasePresenter<MainModel,MainView>{

    }
}
