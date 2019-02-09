package com.chen.ellen.amy.basemvp.model;

//LR模式 -> 本地 & 远程Model模式
public abstract class LRBaseModel<L extends LocalModel,R extends RemoteModel> implements BaseModel {
    L lModel;
    R rModel;
}
