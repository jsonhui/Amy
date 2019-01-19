package com.chen.ellen.amy.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseDialogFragemnt extends DialogFragment {

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setLayout(),container,false);
        unbinder = ButterKnife.bind(this,view);
        return view;
    }

    protected abstract int setLayout();

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

}
