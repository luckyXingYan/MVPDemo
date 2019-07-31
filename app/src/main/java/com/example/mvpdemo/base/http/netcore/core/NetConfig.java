package com.example.mvpdemo.base.http.netcore.core;

import android.content.Context;

import com.example.mvpdemo.BuildConfig;
import com.example.mvpdemo.base.http.netcore.LogInterpector;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * <br>包名：com.netcore
 * <br>项目名称：JR
 * <br>描述：网络请求配置
 * <br>创建人：BaoZhi
 * <br>创建时间：2016/8/16 0016 17:51
 */
public class NetConfig {

    // httpheaders
    public Map<String, String> headers = new HashMap<>();

    private void setupHeaders() {

        headers.put("Accept-Charset", "UTF-8,*");
        headers.put("X-GFS-Plantform", "Android");
        headers.put("Content-Type", "application/x-www-form-urlencoded");
//        headers.put("X-GFS-Client-Version", BuildConfig.VERSION_NAME);
//        headers.put("X-GFS", "3c4f1a25870f926cacd14b6b1f4e35046149a40ca0f2fb65c2a0511eeaad8957");
//        headers.put("SKV", BuildConfig.SKV);
//        headers.put("CHANNEL", ChannelUtils.getChannel(CommonUtils.getApp()));
//        headers.put("distinct-id", SensorsManager.getNickNameId());

    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    // 超时时间
    public final long timeout = 20L * 1000L;

    // 时间单位
    public final TimeUnit timeoutUnit = TimeUnit.MILLISECONDS;

    // 服务器地址
    public final String BASE_URL = BuildConfig.SERVER_ADD;

    // 智能客服服务器地址
//    public final String KEFU_BASE_URL = BuildConfig.KEFU_SERVER_ADD;


    // 解析器
    public Converter.Factory gsonFactory = GsonConverterFactory.create(new GsonBuilder()
            .setLenient()
            .create());

    // 日志
    public LogInterpector logger;

    private void setupLogger() {
        logger = new LogInterpector();
    }


    public static NetConfig create(Context context) {

        NetConfig config = new NetConfig();
        config.setupHeaders();
        config.setupLogger();

        return config;
    }
}
