package com.chen.ellen.amy.basemvp.presenter;

import com.chen.ellen.amy.basemvp.model.BaseModel;
import com.chen.ellen.amy.basemvp.view.BaseView;

public abstract class BasePresenter<M extends BaseModel,V extends BaseView> {
    public M mModel;
    public V mView;
}
