package com.taigu.my.sql;

import com.taigu.my.App;
import com.taigu.my.greendao.gen.DaoMaster;
import com.taigu.my.greendao.gen.DaoSession;

/**
 * Created by Administrator on 2017/10/13 0013.
 */

public class GreenDaoManger {

    private  DaoMaster daoMaster;
    private  DaoSession daoSession;
    public static GreenDaoManger mInstance;
    private static GreenDaoManger manger;

    public GreenDaoManger(){
        DaoMaster.DevOpenHelper devOpenHelper=new DaoMaster.DevOpenHelper(App.getContext(),"taigu.db",null);
        daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        daoSession = daoMaster.newSession();
    }
    public static GreenDaoManger getInstance(){
        if(mInstance == null){
            mInstance = new GreenDaoManger();
        }
        return mInstance;
    }

    public DaoMaster getDaoMaster() {
        return daoMaster;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
    public  DaoSession getNewSession(){
        daoSession = daoMaster.newSession();
        return daoSession;
    }
}
