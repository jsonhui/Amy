package com.chen.ellen.amy.activity.guide;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.chen.ellen.amy.R;
import com.chen.ellen.amy.activity.guide.GuideAgree.GuideView;
import com.chen.ellen.amy.activity.main.MainActivity;
import com.chen.ellen.amy.activity.splash.SplashActivity;
import com.chen.ellen.amy.base.BaseActivity;
import com.chen.ellen.amy.fragment.GuideFragment;
import com.chen.ellen.amy.util.MMKVUtils;
import com.chen.ellen.amy.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class GuideActivity extends BaseActivity<GuidePresenter> implements GuideView {

    @BindView(R.id.vp_guide)
    ViewPager viewPager;
    @BindView(R.id.bt_guide)
    Button btGuide;

    @OnClick(R.id.bt_guide)
    void onClick(View view){
        mPresenter.saveFirstLauncher(true);
        jumpToActivirtAndDestory(MainActivity.class);
    }

    private List<Integer> integerList;

    private String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    //请求状态码
    private int REQUEST_PERMISSION_CODE = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(mPresenter.getIsFirstLauncher()) {
           jumpToActivirtAndDestory(SplashActivity.class);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkPermission();
    }

    private void checkPermission() {
        //检测app需要的权限
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_PERMISSION_CODE);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            int sum = 0;
            for (int i = 0; i < permissions.length; i++) {
                if(grantResults[i] == 0){
                    sum++;
                }
            }
            if(sum == 2){
                //已经获取了权限
            }else {
                finish();
            }
        }
    }

    @Override
    protected Boolean setOrientation() {
        return true;
    }

    @Override
    protected void initView() {
        integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return new GuideFragment(i);
            }

            @Override
            public int getCount() {
                return integerList.size();
            }
        });
       viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int i, float v, int i1) {

           }

           @Override
           public void onPageSelected(int i) {
               if(i == integerList.size() - 1){
                   btGuide.setVisibility(View.VISIBLE);
               }else {
                   btGuide.setVisibility(View.GONE);
               }
           }

           @Override
           public void onPageScrollStateChanged(int i) {

           }
       });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int setLayout() {
        return R.layout.activity_guide;
    }

    @Override
    protected void initMvp() {
        mPresenter = new GuidePresenter();
        mPresenter.mModel = new GuideModel();
        mPresenter.mView = this;
    }
}
