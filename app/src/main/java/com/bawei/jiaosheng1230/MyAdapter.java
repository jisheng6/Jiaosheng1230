package com.bawei.jiaosheng1230;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.jiaosheng1230.Bean.ShopBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adminjs on 2017/12/30.
 */

public class MyAdapter extends RecyclerView.Adapter{
    Context context;
    List<ShopBean.DataBean.DefaultGoodsListBean>list;

    public MyAdapter(Context context) {
        this.context = context;
    }
    public void addData(ShopBean bean){
        if (list == null){
            list = new ArrayList<>();
        }
        list.addAll(bean.getData().getDefaultGoodsList());
        notifyDataSetChanged();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder holder = null;
        switch (viewType){
            case 0:
                view = View.inflate(context,R.layout.item_layout,null);
                holder = new MyHolder(view);
                break;
            case 1:
                view = View.inflate(context,R.layout.layout_item,null);
                holder = new MyHolder1(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
       switch (getItemViewType(position)){
           case 0:
               MyHolder holder1 = (MyHolder)holder;
               holder1.si.setImageURI(list.get(position).getGoods_img());
               holder1.title.setText(list.get(position).getGoods_name());
               break;
           case 1:
               MyHolder1 myHolder1 = (MyHolder1) holder;
               myHolder1.image.setImageURI(list.get(position).getGoods_img());
               myHolder1.name.setText(list.get(position).getGoods_name());
               break;
       }
    }
    @Override
    public int getItemViewType(int position) {
        if(position%2 == 0){
            return 0;
        }else {
            return 1;
        }
    }
    @Override
    public int getItemCount() {
        return list== null ? 0 : list.size();
    }
    class MyHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView si;
         TextView title;

        public MyHolder(View itemView) {
            super(itemView);
            si = itemView.findViewById(R.id.simple);
            title = itemView.findViewById(R.id.title);
        }
    }
    class MyHolder1 extends RecyclerView.ViewHolder {
        SimpleDraweeView image;
        TextView name;
        public MyHolder1(View itemView) {
            super(itemView);
            image =itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
        }
    }
}
