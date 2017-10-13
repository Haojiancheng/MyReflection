package com.taigu.my;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.taigu.my.data.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/12 0012.
 */

public class MyBaseAdapter extends RecyclerView.Adapter<MyBaseAdapter.MyViewHolder> {
    private List<Data.DataBean.ReturnDataBean.ComicsBean> list=new ArrayList<>();
    private Context context;
    OnItemClickListener listener;

    public MyBaseAdapter(List<Data.DataBean.ReturnDataBean.ComicsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itme,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
//        holder.tv2.setText(list.get(position).getName());
//        x.image().bind(holder.iv1,list.get(position).getCover());
        holder.tv2.setText(list.get(position).getName());
        Picasso.with(context)
                .load(list.get(position).getCover())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.drawable.gg)
                .resize(400,500)
//                .rotate(180)
//                .transform(new BlurTransformation(context))
//                .transform(new CircleTransform())
                .transform(new RangleTransFrom(160))
                .into(holder.iv1);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener!=null){
                    listener.onItemClick(v,position);
                }
            }
        });

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv1;
        private TextView tv2;
        public MyViewHolder(View itemView) {
            super(itemView);
            iv1= itemView.findViewById(R.id.iv1);
            tv2=itemView.findViewById(R.id.vt2);

        }
    }
    public interface OnItemClickListener {
        void onItemClick(View var2, int var3);
    }
}
