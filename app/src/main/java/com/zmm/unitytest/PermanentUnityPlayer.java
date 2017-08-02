package com.zmm.unitytest;

import android.content.ContextWrapper;
import android.util.Log;

import com.unity3d.player.UnityPlayer;


/**
 * Description:
 * Author:zhangmengmeng
 * Date:2017/4/14
 * Time:上午11:32
 */

public class PermanentUnityPlayer extends UnityPlayer {

    public PermanentUnityPlayer(ContextWrapper contextWrapper) {
        super(contextWrapper);
    }

    @Override
    protected void kill() {
        Log.d("TAG","this unity has killed.");
    }
}
