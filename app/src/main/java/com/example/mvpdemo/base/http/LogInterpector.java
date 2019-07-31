package com.example.mvpdemo.base.http;

import android.util.Log;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * 作者： 钟雄辉
 * 时间： 2018/9/21
 * 描述： htpp请求拦截器
 **/
public class LogInterpector implements Interceptor {
    private final Charset UTF8 = Charset.forName("UTF-8");

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        RequestBody requestBody = request.body();
        String body = null;
        if (requestBody != null) {
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);

            Charset charset = UTF8;
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(UTF8);
            }
            body = buffer.readString(charset);
        }
        Log.i("LOG_HTTP", "Request:" + request.url());
        Log.i("LOG_HTTP", "Request:" + body);

        Response response = chain.proceed(request);
        ResponseBody responseBody = response.body();

        BufferedSource source = responseBody.source();
        source.request(Long.MAX_VALUE);
        Buffer buffer = source.buffer();
        String str_body = buffer.clone().readString(UTF8);

        Log.i("LOG_HTTP", "Response:" + request.url());
        Log.i("LOG_HTTP", "Response:" + str_body);

        return response;
    }
}
