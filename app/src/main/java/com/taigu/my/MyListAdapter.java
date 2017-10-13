package com.taigu.my;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.taigu.my.sql.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/13 0013.
 */

public class MyListAdapter extends BaseAdapter {
    private Context context;
    private List<User> list=new ArrayList<>();

    public MyListAdapter(Context context, List<User> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView==null){
            holder=new ViewHolder();
            convertView=View.inflate(context,R.layout.listitme,null);
            holder.listimage=convertView.findViewById(R.id.listimage);
            holder.listtv=convertView.findViewById(R.id.listtv);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        //咕咕咕咕
        Picasso.with(context)
                .load(list.get(position).getImage())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.drawable.gg)
                .resize(400,500)
//                .rotate(180)
//                .transform(new BlurTransformation(context))
//                .transform(new CircleTransform())
                .transform(new RangleTransFrom(160))
                .into(holder.listimage);
        holder.listtv.setText(list.get(position).getTitle());

        return convertView;
    }
    class ViewHolder{
        private TextView listtv;
        private ImageView listimage;
    }
}
