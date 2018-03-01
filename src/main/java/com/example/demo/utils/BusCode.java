package com.example.demo.utils;

/**
 * Created by yuanyuzhao on 2017/10/11.
 */
public interface BusCode {
    /**
     * 未知异常，请联系管理员
     */
    int SC_INTERNAL_SERVER_ERROR = 500;
    /**
     * 新增应用记录失败
     */
    int APP_RECORD_ADD_FAIL = 10001;
    /**
     * 删除应用记录失败
     */
    int APP_RECORD_DEL_FAIL = 10002;
    /**
     * 查询应用记录失败
     */
    int APP_RECORD_QUERY_FAIL = 10003;
    /**
     * 修改应用记录失败
     */
    int APP_RECORD_UPDATE_FAIL = 10004;
}
