package com.taigu.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.taigu.my.greendao.gen.UserDao;
import com.taigu.my.sql.GreenDaoManger;
import com.taigu.my.sql.User;

import java.util.List;

public class TWo extends AppCompatActivity {
    private EditText etext,etext2;
    private List<User> list;
    private String image;
    private MyListAdapter adapter;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        etext= (EditText) findViewById(R.id.etext);
        etext2= (EditText) findViewById(R.id.etext2);
        lv= (ListView) findViewById(R.id.lv);
        Intent it=getIntent();
        Bundle bundle = it.getExtras();
        image = bundle.getString("image");


        getinitData();
    }

    private void getinitData() {
        list = GreenDaoManger.getInstance().getDaoSession().getUserDao().queryBuilder().build().list();
        adapter=new MyListAdapter(TWo.this,list);
        lv.setAdapter(adapter);

    }
    //添加数据
    public void insert(Long id,String title,String image){
        UserDao userDao=GreenDaoManger.getInstance().getDaoSession().getUserDao();
        User user=new User(id,title,image);
        if (TextUtils.isEmpty(etext.getText().toString().trim())){
            Toast.makeText(this,"数据为空，请重新输入",Toast.LENGTH_LONG).show();
        }else{
            userDao.insert(user);
            etext.setText("");
            list.clear();
            list.addAll(userDao.queryBuilder().build().list());
            adapter.notifyDataSetChanged();
        }
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
            adapter.notifyDataSetChanged();
        }

    }
    //更改
    public void updata(String oldname,String newname){
        UserDao userDao = GreenDaoManger.getInstance().getDaoSession().getUserDao();
        List<User> list3 = userDao.queryBuilder().where(UserDao.Properties.Title.eq(oldname)).build().list();
        if (list3!=null){
            for (User user:list3) {
                user.setTitle(newname);
                userDao.update(user);
            }
            adapter.notifyDataSetChanged();
            Toast.makeText(TWo.this, "修改成功", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(TWo.this, "修改失败", Toast.LENGTH_SHORT).show();
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
   //查找
    public void bfind(View view) {

    }
    //更改
    public void bupdata(View view) {
        updata(etext.getText().toString(),etext2.getText().toString());
    }
}
