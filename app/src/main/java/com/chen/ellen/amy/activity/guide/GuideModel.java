package com.chen.ellen.amy.activity.guide;

import com.chen.ellen.amy.util.MMKVUtils;

public class GuideModel implements GuideAgree.GuideModel {

    @Override
    public void save(boolean b) {
        MMKVUtils.getInstance().save(GuideAgree.USER_FIRST_LAUNCHER_TAG,b);
    }
}
