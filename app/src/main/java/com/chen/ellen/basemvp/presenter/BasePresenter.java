package com.chen.ellen.basemvp.presenter;

import com.chen.ellen.basemvp.model.BaseModel;
import com.chen.ellen.basemvp.view.BaseView;

public abstract class BasePresenter<M extends BaseModel,V extends BaseView> {
    public M mModel;
    public V mView;
}
