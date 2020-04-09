package com.example.mvpdemo.base.http.netcore.core;

import com.example.mvpdemo.base.http.netcore.api.ApiService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;

/**
 * <br>包名：com.netcore.core
 * <br>项目名称：JR
 * <br>描述：网络引擎
 * <br>创建人：BaoZhi
 * <br>创建时间：2016/8/16 0016 17:49
 */
public class NetEngine {

    private volatile static NetEngine instance = null;

    private NetEngine(NetConfig config) {
        this.config = config;
    }

    private NetConfig config;           // 配置实例
    public OkHttpClient okHttpClient;  // httpClient实例
    private Retrofit retrofit;          // retrofit实例
    private ApiService apiService;      // serverApi 实例


    public static void init(NetConfig config) {

        if (instance == null) {
            synchronized (NetEngine.class) {
                if (instance == null) {
                    instance = new NetEngine(config);
                    instance.setupOkHttpClient();
                    instance.setupRetrofit();
                    instance.setupApiService();
                }

            }

        }

    }

    public static ApiService getServerApi() {
        if (instance == null) {
            throw new RuntimeException("Net Engin Not Initialized");
        }

        return instance.getApiService();
    }

    public Map<String, String> headers_ = new HashMap<>();

    private void setupOkHttpClient() {
        okhttp3.OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(config.timeout, config.timeoutUnit);
        /**
         * 兼容  我的账单页 socket读取超时
         */
        builder.readTimeout(60 * 1000L, config.timeoutUnit);
        headers_.putAll(config.headers);
        if (headers_ != null && !headers_.isEmpty()) {
            builder.addInterceptor(new Interceptor() {
                @Override
                public okhttp3.Response intercept(Chain chain) throws IOException {
                    Request.Builder builder = chain.request().newBuilder();
                    /**
                     * 唯一的该设备的标识
                     * 若极光功能弃用 该字段不可删除，已用于其他功能作为设备识别 - 2018-05-21 by Fu
                     */
//                    headers_.put("jg-pid", PushManager.getRegistrationID());
                    headerSetup(builder, headers_);
                    return chain.proceed(builder.build());
                }
            });
        }
        if (config.logger != null) {
            builder.addInterceptor(config.logger);
        }
        okHttpClient = builder.build();
    }

    private void headerSetup(Request.Builder builder, Map<String, String> headers) {
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            builder.addHeader(entry.getKey(), entry.getValue());
        }
    }

    private void setupRetrofit() {
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(config.BASE_URL)
                .addConverterFactory(config.gsonFactory)
                .build();  
    }

    private void setupApiService() {
        apiService = retrofit.create(ApiService.class);   
    }

    protected ApiService getApiService() {
        return apiService;
    }

}
