package com.example.localhost.baidumusic;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by localhost on 2017/10/7.
 */

public class MusicService extends Service {

    //把我们定义的中间人返回
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyIBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    //播放音乐的方法
    public void playMusic() {
        Log.d("MainActivity", "音乐播放了");
    }

    //暂停的方法
    public void pauseMusic() {
        Log.d("MainActivity", "音乐暂停了");
    }

    //继续播放的方法
    public void replayMusic() {
        Log.d("MainActivity", "音乐继续播放！");
    }

    //【1】在服务的内部定义一中间人对象(IBinder)
    private class MyIBinder extends Binder implements Iservice {
        @Override
        public void callPlayMusic() {
            playMusic();
        }

        @Override
        public void callPauseMusic() {
            pauseMusic();

        }

        @Override
        public void callRePlayMusic() {
            replayMusic();
        }
    }

}
