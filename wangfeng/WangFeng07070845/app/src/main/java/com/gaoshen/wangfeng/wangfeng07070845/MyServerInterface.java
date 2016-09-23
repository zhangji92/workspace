package com.gaoshen.wangfeng.wangfeng07070845;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by Administrator on 2016/7/6.
 */
public interface MyServerInterface {



    //通过连接数据库 查询指定数据
    @GET("/bk/{str}list.con")
    Call<List<Book>> bookDetais_cx(@Path("str") String str);
}


