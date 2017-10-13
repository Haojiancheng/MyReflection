package com.taigu.my;

import android.content.Context;

import com.taigu.my.sql.GreenDaoManger;

import org.xutils.x;

/**
 * Created by Administrator on 2017/10/11 0011.
 */

public class App extends com.andy.share.App{
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);

        context=getApplicationContext();
        GreenDaoManger.getInstance();

    }
    public static Context getContext(){
        return context;
    }
}
