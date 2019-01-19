package com.chen.ellen.amy.activity.guide;

import com.chen.ellen.basemvp.model.BaseModel;

public interface GuideAgree {

    interface GuideModel extends BaseModel{
        //保存向导的首次启动的标记
        void save();
    }

}
