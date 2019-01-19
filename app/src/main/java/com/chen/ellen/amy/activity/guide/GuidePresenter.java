package com.chen.ellen.amy.activity.guide;

import com.chen.ellen.amy.basemvp.presenter.BasePresenter;
import com.chen.ellen.amy.util.MMKVUtils;

public class GuidePresenter extends GuideAgree.GuidePresenter {
    @Override
    protected boolean getIsFirstLauncher() {
        return (boolean) MMKVUtils.getInstance().get(GuideAgree.USER_FIRST_LAUNCHER_TAG,false);
    }

    @Override
    protected void saveFirstLauncher(boolean isFirst) {
            mModel.save(isFirst);
    }
}
