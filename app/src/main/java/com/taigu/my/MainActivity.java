package com.taigu.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.taigu.my.data.Data;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements XRecyclerView.LoadingListener,MyBaseAdapter.OnItemClickListener{
    private static final String TAG = "TAG";
    private TextView tv1;
    private XRecyclerView xrview;
    private MyBaseAdapter adapter;
    private List<Data.DataBean.ReturnDataBean.ComicsBean> list=new ArrayList<>();
    String path="http://app.u17.com/v3/appV3_3/android/phone/list/commonComicList?argValue=23&argName=sort&argCon=0&android_id=4058040115108878&v=3330110&model=GT-P5210&come_from=Tg002&page=";
    int paga=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1= (TextView) findViewById(R.id.tv1);

        try {
            Class<?> acat = Class.forName("com.taigu.my.ReflictionCat");
            Method[] declaredMethods = acat.getDeclaredMethods();
            for (Method method : declaredMethods) {
                System.out.print(method.toString());
                Toast.makeText(this, ""+method, Toast.LENGTH_SHORT).show();
//                Logger.e("-----------"+method.getName().toString()+"----------");
                Log.e(TAG,"---------"+method.toString());
                tv1.setText("点击将要加入数据库的图片");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        xrview= (XRecyclerView) findViewById(R.id.xrview);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        xrview.setLayoutManager(manager);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        xrview.setLoadingListener(this);
        xrview.setPullRefreshEnabled(true);
        xrview.setLoadingMoreProgressStyle(ProgressStyle.BallPulseRise);
        adapter=new MyBaseAdapter(list,this);
        xrview.setAdapter(adapter);
        adapter.setListener(this);
        getHttp();
    }

    private void getHttp() {
        RequestParams params=new RequestParams(path+paga);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Data data = new Gson().fromJson(result, Data.class);
                list.addAll(data.getData().getReturnData().getComics());
                adapter=new MyBaseAdapter(list,MainActivity.this);
//                xrview.setAdapter(adapter);
//                adapter.notifyDataSetChanged();
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }
            @Override
            public void onCancelled(CancelledException cex) {

            }
            @Override
            public void onFinished() {

            }
        });
    }
    @Override
    public void onRefresh() {
        list.clear();
        paga=1;
        getHttp();
        adapter.notifyDataSetChanged();
        xrview.refreshComplete();
    }

    @Override
    public void onLoadMore() {
        paga++;
        getHttp();
        adapter.notifyDataSetChanged();
        xrview.loadMoreComplete();
    }

    @Override
    public void onItemClick(View var2, int var3) {
        Intent it=new Intent(this, TWo.class);
        it.putExtra("image",list.get(var3).getCover());
        startActivity(it);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
