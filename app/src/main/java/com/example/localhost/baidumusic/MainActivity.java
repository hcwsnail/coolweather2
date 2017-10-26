package com.example.localhost.baidumusic;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Iservice iservice;
    private Myconn conn;
    


    protected void onCreate(Bundle savedInstanceState) {
       
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //混合方式开启服务
        //【1】先调用startservice 目的是可以保证服务在后台长期运行
        Intent intent = new Intent(this, MusicService.class);
        startService(intent);
        //【2】调用bindservice 目的是获取中间人对象 间接调用服务里的方法
        conn = new Myconn();
        bindService(intent, conn, BIND_AUTO_CREATE);

    }

    //点击播放
    public void click1(View v) {
//        iservice.callPlayMusic();

    }

    //点击暂停
    public void click2(View v) {
//        iservice.callPauseMusic();
    }

    //点击继续播放
    public void click3(View v) {
//        iservice.callRePlayMusic();
    }

    //监听服务状态
    private class Myconn implements ServiceConnection {


        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //获取中间人对象
            Iservice iservice = (Iservice) service;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
    protected void onDestory()
    {
       unbindService(conn);
    }


}

