package com.bawei.jiaosheng1230;


import com.bawei.jiaosheng1230.Bean.ShopBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Adminjs on 2017/12/30.
 */

public interface IGetDataBase {
    @GET("/umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage")
    Observable<ShopBean> get();
}
