package com.example.demo.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by wangtuo on 2017/9/19.
 */
public class NumberUtil {

    /**
     * 数值多条件格式转换
     * @param number 需转换的数值
     * @param grouping 是否三段式格式，三段式 eg: 2,456,789
     * @param stripTrailingZeros 是否去掉小数位最后多余的零
     * @param roundUp 四舍五入的处理，true：四舍五入，false：直接截掉多余的小数位  null不处理
     * @param digit 保留几位小数
     * @return
     */
    public static String format(Object number, boolean grouping, boolean stripTrailingZeros, Boolean roundUp, Integer digit) {
        if (number == null) {
            number = BigDecimal.ZERO;
        }
        DecimalFormat df = new DecimalFormat();
        df.setGroupingUsed(grouping);
        if(roundUp != null) {
            df.setRoundingMode(roundUp ? RoundingMode.HALF_UP : RoundingMode.DOWN);
        }
        if(digit != null) {
            df.setMaximumFractionDigits(digit);
            if(!stripTrailingZeros) {
                df.setMinimumFractionDigits(digit);
            }
        }
        return df.format(number);
    }

    /**
     * 四舍五入
     * @param decimal 需转换的数值
     * @param digit 保留几位小数
     * @return
     */
    public static String roundUp(BigDecimal decimal, int digit) {
        return format(decimal, false, false, true, digit);
    }

    /**
     * 去掉小数位多余的零
     * @param decimal 需转换的数值
     * @param digit 最多保留几位小数
     * @return
     */
    public static String delZero(BigDecimal decimal, int digit) {
        return format(decimal, false, true, false, digit);
    }

	/**
	 * 标准利率数值显示，包括：四舍五入，去掉小数后多余的零
	 * @param decimal
	 * @return
	 */
	public static String rate(BigDecimal decimal) {
		return format(decimal, false, true, true, 2);
	}

	/**
	 * 标准金额格式，包括：三段式显示，保留2为小数，截掉小数后多余的位数
	 * @param decimal
	 * @return
	 */
	public static String money(BigDecimal decimal) {
		return format(decimal, true, false, false, 2);
	}

    /**
     * 标准金额格式，包括：三段式显示，保留2为小数，四舍五入
     * @param decimal
     * @return
     */
    public static String moneyUp(BigDecimal decimal) {
        return format(decimal, true, false, true, 2);
    }
}
