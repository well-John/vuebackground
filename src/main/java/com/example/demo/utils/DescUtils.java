package com.example.demo.utils;

/**
 * Created by chenjx on 2018/2/13.
 */
public class DescUtils {


    public static String getStatusDescP2P(Integer status) {
        if (status == 0) {
            return "扣款成功";
        }else if(status == 2) {
            return "转出成功";
        }else if(status == -1) {
            return "转出失败";
        }else{
            return "未知";
        }
    }
    public static String getStatusDesc(Integer status) {
        if (status == 0) {
            return "扣份数成功";
        }else if(status == 2) {
            return "入账成功";
        }else if(status == -1) {
            return "入账失败";
        }else{
            return "未知";
        }
    }

    /**
     * 状态status
     0 退款初始化成功
     1 发送MQ成功
     2 退款确认成功
     3 退款失败
     * @param status
     * @return
     */
    public static String getRefundStatus(Integer status) {
        if (status == 0) {
            return "0退款初始化成功";
        }else if(status == 1) {
            return "1发送MQ成功";
        }else if(status == 2) {
            return "2退款确认成功";
        }else if(status == -1 || status == 3) {
            return "3退款失败";
        }else{
            return "未知";
        }

    }
}
