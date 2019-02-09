package com.chen.ellen.amy.activity.splash;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.chen.ellen.amy.R;
import com.chen.ellen.amy.activity.main.MainActivity;
import com.chen.ellen.amy.base.BaseActivity;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.OnClick;

public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashArgee.SplashView {

    private final int SPLASH_TIME = 3;
    private SplashHandler splashHandler;
    private boolean isUserClick = false;

    @BindView(R.id.tv_splash)
    TextView tvSplash;

    @OnClick(R.id.tv_splash)
    void onClick(View view) {
        isUserClick = true;
        jumpToActivirtAndDestory(MainActivity.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new SplashThread(this).start();
    }

    @Override
    protected Boolean setOrientation() {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        splashHandler = new SplashHandler(this);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initMvp() {
        mPresenter = new SplashPresenter();
        mPresenter.mModel = new SplashModel();
        mPresenter.mView = this;
    }

    static class SplashThread extends Thread {

        private WeakReference<SplashActivity> weakReference;

        public SplashThread(SplashActivity activity) {
            weakReference = new WeakReference<>(activity);
        }

        @Override
        public void run() {
            super.run();
            SplashActivity activity = weakReference.get();
            for (int i = weakReference.get().SPLASH_TIME; i >= 0 && !activity.isUserClick; i--) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                activity.splashHandler.sendEmptyMessage(i);
            }
        }
    }

    static class SplashHandler extends Handler {

        private WeakReference<SplashActivity> weakReference;

        public SplashHandler(SplashActivity activity) {
            weakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            SplashActivity activity = weakReference.get();
            activity.tvSplash.setText("跳过" + String.valueOf(msg.what));
            if (msg.what == 0 && !activity.isUserClick) {
                activity.jumpToActivirtAndDestory(MainActivity.class);
            }
            removeMessages(msg.what);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
