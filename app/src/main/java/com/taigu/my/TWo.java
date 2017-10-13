package com.taigu.my;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.taigu.my.greendao.gen.UserDao;
import com.taigu.my.sql.GreenDaoManger;
import com.taigu.my.sql.User;

import java.util.List;

public class TWo extends AppCompatActivity {
    private EditText etext;
    private List<User> list;
    private String image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        etext= (EditText) findViewById(R.id.etext);
        Intent it=getIntent();
        Bundle bundle = it.getExtras();
        image = bundle.getString("image");


        getinitData();
    }

    private void getinitData() {
        list = GreenDaoManger.getInstance().getDaoSession().getUserDao().queryBuilder().build().list();

    }
    //添加数据
    public void insert(Long id,String title,String image){
        UserDao userDao=GreenDaoManger.getInstance().getDaoSession().getUserDao();
        User user=new User(id,title,image);
        userDao.insert(user);
        etext.setText("");
        list.clear();
        list.addAll(userDao.queryBuilder().build().list());


    }
    //删除数据
    public void delete(String title){
        UserDao userDao = GreenDaoManger.getInstance().getDaoSession().getUserDao();
        List<User> dlist = userDao.queryBuilder().where(UserDao.Properties.Title.eq(title)).build().list();
        if (dlist!=null){
            for (User user: dlist) {
                userDao.deleteByKey(user.getId());
                list.remove(user);
            }
        }

    }
    //添加
    public void binto(View view) {
        insert(null,etext.getText().toString(),image);
    }
    //删除
    public void bdelete(View view) {
        delete(etext.getText().toString());
    }

    public void bfind(View view) {
    }

    public void bupdata(View view) {
    }
}
