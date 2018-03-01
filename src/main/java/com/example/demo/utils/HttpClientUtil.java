package com.example.demo.utils;

/**
 * Created by chuguoying on 2018/2/27.
 */

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * HttpClientUtil
 */
public class HttpClientUtil {

    // 连接主机超时时间
    public static final int HTTP_CONNECT_TIMEOUT = 2 * 1000;

    // 从主机读取数据超时
    public static final int HTTP_READ_TIMEOUT = 3 * 1000;

    /**
     * httpPost
     */
    public static String httpPost(String url, String jsonParam) throws ClientProtocolException, IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        // 设置请求头和请求参数
        if (null != jsonParam && !"".equals(jsonParam)) {
            StringEntity entity = new StringEntity(jsonParam, "utf-8");
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
        }

        // 超时时间设置
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(HTTP_READ_TIMEOUT)
                .setConnectTimeout(HTTP_CONNECT_TIMEOUT).build();
        httpPost.setConfig(requestConfig);

        // 发送请求
        CloseableHttpResponse response = httpclient.execute(httpPost);

        // 获取返回内容
        try {
            HttpEntity entity = response.getEntity();
            String str = EntityUtils.toString(entity);
            EntityUtils.consume(entity); // 此句关闭了流
            return str;
        } finally {
            response.close();
        }
    }

    /**
     * httpPost get Cookies
     */
    public static Map<String, Object> httpPostGetCookies(String url, String jsonParam) throws ClientProtocolException,
            IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        // 设置请求头和请求参数
        if (null != jsonParam && !"".equals(jsonParam)) {
            StringEntity entity = new StringEntity(jsonParam, "utf-8");
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
        }

        // 超时时间设置
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(HTTP_READ_TIMEOUT)
                .setConnectTimeout(HTTP_CONNECT_TIMEOUT).build();
        httpPost.setConfig(requestConfig);

        // 发送请求
        CloseableHttpResponse response = httpclient.execute(httpPost);

        // 获取返回内容
        try {
            HttpEntity entity = response.getEntity();
            String str = EntityUtils.toString(entity);
            EntityUtils.consume(entity); // 此句关闭了流

            // 获取数据内容
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("result", str);

            // 获取返回到额Cookies
            Header[] headers = response.getHeaders("Set-Cookie");
            map.put("cookies", headers);

            return map;
        } finally {
            response.close();
        }
    }

    /**
     * httpGet
     */
    public static String httpGet(String url) throws ClientProtocolException, IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);

        // 超时时间设置
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(HTTP_READ_TIMEOUT)
                .setConnectTimeout(HTTP_CONNECT_TIMEOUT).build();
        httpGet.setConfig(requestConfig);

        // 发送请求
        CloseableHttpResponse response = httpclient.execute(httpGet);

        // 获取返回内容
        try {
            HttpEntity entity = response.getEntity();
            String strResult = EntityUtils.toString(entity);
            return strResult;
        } finally {
            response.close();
        }
    }

    /**
     * httpGet with Cookies
     */
    public static String httpGetWithCookies(String url, Header[] headers) throws ClientProtocolException, IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);

        // 超时时间设置
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(HTTP_READ_TIMEOUT)
                .setConnectTimeout(HTTP_CONNECT_TIMEOUT).build();
        httpGet.setConfig(requestConfig);

        // 设置请求头
        if (headers != null && headers.length > 0) {
            httpGet.setHeaders(headers);
        }

        // 发送请求
        CloseableHttpResponse response = httpclient.execute(httpGet);

        // 获取返回内容
        try {
            HttpEntity entity = response.getEntity();
            String strResult = EntityUtils.toString(entity);
            return strResult;
        } finally {
            response.close();
        }
    }

}