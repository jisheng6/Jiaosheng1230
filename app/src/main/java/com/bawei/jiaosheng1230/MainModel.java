package com.bawei.jiaosheng1230;

import com.bawei.jiaosheng1230.Bean.ShopBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Adminjs on 2017/12/30.
 */

public class MainModel {
    public void getData(final ModelCallBack callBack){
        IApplication.iGetDataBase.get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShopBean>() {
                    @Override
                    public void accept(ShopBean bean) throws Exception {
                        callBack.onSuccess(bean);
                    }
                });
    }

    public interface ModelCallBack {
        public void onSuccess(ShopBean bean);
        public void onFailure();
    }
}
