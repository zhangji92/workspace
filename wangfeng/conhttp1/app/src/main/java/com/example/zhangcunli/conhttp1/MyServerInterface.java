package com.example.zhangcunli.conhttp1;



import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by zhangcunli on 2016/5/12.
 */
public interface MyServerInterface {
//    @GET("/BookServlet")
//    Call<List<Book>> bookDetais();



//    @GET("/book/{bookname}bk.con")
//    //将这个参数传给服务器
//    Call<List<Book>> bookDetais(@Path("bookname") String bookname);


    //连接数据库获取数据
    @GET("/book/list.con")
    Call<List<Book>> bookDetais_lj();

    //通过连接数据库 查询指定数据
    @GET("/book/{bookname}list.con")
    Call<List<Book>> bookDetais_cx(@Path("bookname") String bookname);
}
