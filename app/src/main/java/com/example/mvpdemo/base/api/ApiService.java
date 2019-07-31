package com.example.mvpdemo.base.api;

import com.example.mvpdemo.base.bean.HttpBean;
import com.example.mvpdemo.home.bean.HomeDataBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * <br>包名：com.netcore
 * <br>项目名称：JR
 * <br>描述：服务器api
 * <br>创建人：BaoZhi
 * <br>创建时间：2016/8/16 0016 16:10
 */
public interface ApiService {

    // 获取首页红包状态
    //#https://douban.uieee.com/v2/movie/top250?start=0&count=10即可。
    @FormUrlEncoded
    @POST(ApiRoute.PRODUCT.GET_HOMEPAGE_REDPACKETS_STATUS)
    Call<HttpBean<List<HomeDataBean>>> getHomePageData(@Field(ApiKeys.START) String start, @Field(ApiKeys.COUNT) String count);
}