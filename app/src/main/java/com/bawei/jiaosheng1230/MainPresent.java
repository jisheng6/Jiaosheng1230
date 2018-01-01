package com.bawei.jiaosheng1230;

import com.bawei.jiaosheng1230.Bean.ShopBean;

/**
 * Created by Adminjs on 2017/12/30.
 */

public class MainPresent {
    private MainView view;
    private MainModel model;

    public MainPresent(MainView view) {
        this.view = view;
        this.model = new MainModel();
    }
    public void get(){
        model.getData(new MainModel.ModelCallBack() {
            @Override
            public void onSuccess(ShopBean bean) {
                if (view != null){
                    view.onSuccess(bean);
                }
            }

            @Override
            public void onFailure() {

            }
        });
    }
}
