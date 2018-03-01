package com.example.demo.utils;

/**
 * 应用状态
 * Created by yuanyuzhao on 2017/10/9.
 */
public enum AppStatus {

    NORMAL(0,"正常"),
    DELETE(-1,"已删除");

    private int value;
    private String label;

    AppStatus(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public static String getLabelByValue(int value) {
        String returnLabel = "";
        if (NORMAL.value == value) {
            returnLabel = NORMAL.label;
        } else if (DELETE.value == value) {
            returnLabel = DELETE.label;
        }
        return returnLabel;
    }

}
