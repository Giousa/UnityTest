package com.zmm.unitytest;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2017/8/2
 * Time:下午2:34
 */

public class UntiyRunningActivity extends AppCompatActivity {

    private PermanentUnityPlayer mUnityPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unity);

        init();
    }

    private void init() {
        FrameLayout frameLayoutUnity = (FrameLayout) findViewById(R.id.frame_layout_unity);
        Button back = (Button) findViewById(R.id.btn_back);

        mUnityPlayer = new PermanentUnityPlayer(this);
        frameLayoutUnity.addView(mUnityPlayer);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mUnityPlayer == null) {
            return;
        }
        this.mUnityPlayer.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnityPlayer != null) {
            this.mUnityPlayer.quit();
            this.mUnityPlayer = null;
        }
    }

    public void onConfigurationChanged(Configuration var1) {
        super.onConfigurationChanged(var1);
        if (mUnityPlayer == null) {
            return;
        }
        this.mUnityPlayer.configurationChanged(var1);
    }

    public void onWindowFocusChanged(boolean var1) {
        super.onWindowFocusChanged(var1);
        if (mUnityPlayer == null) {
            return;
        }
        this.mUnityPlayer.windowFocusChanged(var1);
    }

    public boolean dispatchKeyEvent(KeyEvent var1) {
        return var1.getAction() == 2 ? this.mUnityPlayer.injectEvent(var1) : super.dispatchKeyEvent(var1);
    }

    public boolean onKeyUp(int var1, KeyEvent var2) {

        return this.mUnityPlayer.injectEvent(var2);
    }


    public boolean onKeyDown(int var1, KeyEvent var2) {
        return this.mUnityPlayer.injectEvent(var2);
    }

    public boolean onTouchEvent(MotionEvent var1) {
        return this.mUnityPlayer.injectEvent(var1);
    }

    public boolean onGenericMotionEvent(MotionEvent var1) {
        return this.mUnityPlayer.injectEvent(var1);
    }
}
