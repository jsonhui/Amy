package com.chen.ellen.amy.activity.guide;

import com.chen.ellen.amy.basemvp.model.SimpleBaseModel;
import com.chen.ellen.amy.basemvp.presenter.BasePresenter;
import com.chen.ellen.amy.basemvp.view.BaseView;

public interface GuideAgree {

    String USER_FIRST_LAUNCHER_TAG = "user_first_launcher_tag";

    interface GuideModel extends SimpleBaseModel {
        //保存向导的首次启动的标记
        void save(boolean b);
    }

    interface GuideView extends BaseView{

    }

    abstract class GuidePresenter extends BasePresenter<GuideModel,GuideView>{

        //得到用户是否首次启动
        protected abstract boolean getIsFirstLauncher();
        //存储用户首次启动的标记
        protected abstract void saveFirstLauncher(boolean isFirst);

    }

}
