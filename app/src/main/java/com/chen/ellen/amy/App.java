package com.chen.ellen.amy;

import android.app.Application;

import com.tencent.mmkv.MMKV;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //MMKV初始化
        MMKV.initialize(this);
    }
}
