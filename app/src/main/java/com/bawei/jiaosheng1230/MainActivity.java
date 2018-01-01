package com.bawei.jiaosheng1230;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bawei.jiaosheng1230.Bean.ShopBean;
import com.google.gson.Gson;
import com.youth.banner.Banner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends Activity implements MainView {
    private List<String> list;
    private MainPresent present;
    private MyAdapter adapter;
    private RecyclerView recyclerview;
    private Banner banner;
    private List<ShopBean.DataBean.SubjectsBean>ad1 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview = findViewById(R.id.recyclerview);
        banner = findViewById(R.id.banner);
        list = new ArrayList<>();
      //  getData();
        present = new MainPresent(this);
        present.get();
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerview.setLayoutManager(manager);
        adapter = new MyAdapter(this);
        recyclerview.setAdapter(adapter);

//        list.add("https://image.yunifang.com/yunifang/images/goods/temp/171011162655217457875119759.jpg");
//        list.add("https://image.yunifang.com/yunifang/images/goods/temp/17051609349138679665088294.jpg");
//        list.add("https://image.yunifang.com/yunifang/images/goods/temp/17101116265017851243534104.jpg");
//        list.add("https://image.yunifang.com/yunifang/images/goods/temp/17051612377286522760845671.jpg");
//        list.add("https://image.yunifang.com/yunifang/images/goods/temp/170516122967511806265329475.jpg");
//        banner.setImages(list);
//        banner.isAutoPlay(true);
//        //图片两秒切换
//        banner.setDelayTime(2000);
//        banner.setImageLoader(new GlideImageLoader());
//        banner.start();
    }
//
//    private void getData() {
//        OkHttpClient client=new OkHttpClient();
//        Request request=new Request.Builder()
//                .url("http://result.eolinker.com/umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage")
//                .build();
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                final String str=response.body().string();
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Gson gson=new Gson();
//                        ShopBean bean=gson.fromJson(str,ShopBean.class);
//                        ad1 = bean.getData().getSubjects();
//                        for (int i=0;i<ad1.size();i++){
//                            list.add(ad1.get(i).getImage());
//                        }
//                        banner.setImageLoader(new GlideImageLoader());
//                        //设置集合
//                        banner.setImages(list);
//                        //banner执行完方法之后调用
//                        banner.start();
//                    }
//                });
//            }
//        });
//    }

    @Override
    public void onSuccess(ShopBean bean) {
      adapter.addData(bean);

        ad1 = bean.getData().getSubjects();
        for (int i=0;i<ad1.size();i++){
            list.add(ad1.get(i).getImage());
        }
        banner.setImageLoader(new GlideImageLoader());
        //设置集合
        banner.setImages(list);
        //banner执行完方法之后调用
        banner.start();
    }

    @Override
    public void onFailure(Exception e) {

    }
}
