package com.chen.ellen.amy.fragment;

import android.annotation.SuppressLint;
import android.widget.TextView;

import com.chen.ellen.amy.R;
import com.chen.ellen.amy.base.BaseFragment;

import butterknife.BindView;

@SuppressLint("ValidFragment")
public class GuideFragment extends BaseFragment {

    @BindView(R.id.tv_guide)
    TextView textView;

    private int position;

    public GuideFragment(int position){
        this.position = position;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
       textView.setText(String.valueOf(position));
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_guide;
    }
}

