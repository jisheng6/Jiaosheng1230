package com.bawei.jiaosheng1230;

import com.bawei.jiaosheng1230.Bean.ShopBean;

/**
 * Created by Adminjs on 2017/12/30.
 */

public interface MainView {
    public void onSuccess(ShopBean bean);
    public void onFailure(Exception e);
}
