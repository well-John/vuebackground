package com.example.demo.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by lzf on 2017/6/14.
 */
public class TuandaiUtil {

    private static final Logger logger = LoggerFactory.getLogger(TuandaiUtil.class);

    public static String getUUID() {
        return UUID.randomUUID().toString().toUpperCase();
    }
    private static final Map<String, BeanCopier> beanCopierMap = new HashMap<String, BeanCopier>();


    /**
     * 用于数据对比接口，其它方法调用要认真阅读本方法的实现
     * @param source
     * @param target
     * @return
     */
    public static boolean isEquals(String source, String target) {
        if ((source == null || StringUtils.isEmpty(source)) && (target == null || StringUtils.isEmpty(target))) {
            return true;
        } else if ((source != null && target != null && source.trim().equals(target.trim()))) {
		    return true;
        }
        return false;
    }

    /**
     * 检查参数是否为标准UUID值
     * @param uuid
     * @return
     */
    public static boolean isUUID(String uuid) {
        String reg = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
        return uuid != null && uuid.length() == 36 && uuid.matches(reg);
    }

   /* public static void requireUserId(String userId) {
        if(!isUUID(userId)) {
            throw new AppBusinessException("用户ID参数错误");
        }
    }

    public static <T> T requireNonNull(T obj, String msg) {
        if(obj == null) {
            throw new AppBusinessException(msg);
        }
        return obj;
    }*/

    /**
     * 能够针对BeanUtils所无法拷贝的属性类型进行拷贝，例如：Boolean
     * @param source
     * @param target
     */
    public static void copyProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target);
        Class<?> cls = target.getClass();
        for(Field f : source.getClass().getDeclaredFields()) {
            if(f.getType() == Boolean.class) {
                f.setAccessible(true);
                try {
                    Field tf = cls.getDeclaredField(f.getName());
                    tf.setAccessible(true);
                    tf.set(target, f.get(source));
                } catch (IllegalAccessException e) {
                } catch (NoSuchFieldException e) {
                }
            }
        }
    }
    // 团贷网密码加密算法
    public static String md5Passwrod(String password) {
        // 加密码
        StringBuffer str = new StringBuffer();
        str.append("tuan").append(password).append("dai");
        String results = null;
        MessageDigest mDigest;
        try {
            mDigest = MessageDigest.getInstance("SHA1");
            byte[] result = mDigest.digest(str.toString().getBytes());
            String sha1_input = byteToStringHex(result);// sb.toString().toUpperCase();
            mDigest = MessageDigest.getInstance("MD5");
            String md5input = sha1_input.toUpperCase();
            mDigest.update(md5input.getBytes());
            result = mDigest.digest();
            results = byteToStringHex(result);// buf.toString();
        } catch (NoSuchAlgorithmException e) {
            //
        }

        return results;
    }

    public static String byteToStringHex(byte[] result) {
        StringBuffer sb = new StringBuffer();
        for (byte element : result) {
            sb.append(Integer.toString((element & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString().toUpperCase();
    }

    public static boolean isInteger(String value) {
        if(!isBlank(value)) {
            try {
                Integer.parseInt(value);
                return true;
            } catch (NumberFormatException e) {
                logger.error("格式化失败", e);
            }
        }
        return false;
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    /**
     *
     * 使用Cglib的BeanCopier实现Bean的拷贝
     *
     * @param source
     * @param target
     */
    public static void copyPropertiesCglib(Object source, Object target) {
        String beanKey = generateBeanKey(source.getClass(), target.getClass());
        BeanCopier copier = null;
		if (!beanCopierMap.containsKey(beanKey)) {
			copier = BeanCopier.create(source.getClass(), target.getClass(), false);
			beanCopierMap.put(beanKey, copier);
		} else {
			copier = beanCopierMap.get(beanKey);
		}
		copier.copy(source, target, null);
    }

    public static String generateBeanKey(Class<?> source, Class<?> target) {
        return source.getName() + "@" + target.getName();
    }

    /**
     *
     * 使用Cglib的BeanCopier实现Bean的拷贝
     *
     * @param source
     * @param target
     */
    public static void copyPropertiesSpecical(Object source, Object target) {
//        String beanKey = source.toString() + target.toString();
//        String beanKey = source.getName() + "@" + target.getName();
        String beanKey = generateBeanKey(source.getClass(), target.getClass());
        BeanCopier copier = null;
        if (!beanCopierMap.containsKey(beanKey)) {
            copier = BeanCopier.create(source.getClass(), target.getClass(), false);
            beanCopierMap.put(beanKey, copier);
        } else {
            copier = beanCopierMap.get(beanKey);
        }
        copier.copy(source, target, null);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter datef = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		for (Field f : target.getClass().getDeclaredFields()) {
			// LocalDateTime, LocalDate的属性类型进行拷贝
			try {
				if (f.getType() == LocalDateTime.class || f.getType() == LocalDate.class) {
					f.setAccessible(true);
					if (f.get(target) == null) { // 对空的属性设置默认值
						if (f.getType() == LocalDateTime.class)
							f.set(target, LocalDateTime.parse("0001-01-01 01:01:01", df));
						else if (f.getType() == LocalDate.class)
							f.set(target, LocalDate.parse("0001-01-01", datef));
					}
				}
				// String 的属性类型进行拷贝
				else if (f.getType() == String.class) {
					f.setAccessible(true);
					if (f.get(target) == null) {
						f.set(target, "");
					}
				}
                // Integer 的属性类型进行拷贝
                else if (f.getType() == Integer.class) {
                    f.setAccessible(true);
                    if (f.get(target) == null) {
                        f.set(target, 0);
                    }
                }
                // Integer 的属性类型进行拷贝
                else if (f.getType() == BigDecimal.class) {
                    f.setAccessible(true);
                    if (f.get(target) == null) {
                        f.set(target, BigDecimal.valueOf(0.00));
                    }
                }
            } catch (IllegalAccessException e) {
			    logger.error("", e);
			}
		}
    }

    /**
     * 验证Email地址
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        return email != null && email.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+");
    }

    /**
     * 验证手机号
     * @param phoneNum
     * @return
     */
    public static boolean isPhone(String phoneNum){
        String regex = "^(13|14|15|17|18)[0-9]{9}$";//手机号正则表达式
        return phoneNum.matches(regex);
    }
    /**
     * 验证身份证号
     * @param idCard
     * @return
     */
    public static boolean isIDCard(String idCard){
        String regex = "^(^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$)|(^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}[Xx])$)$";//身份证正则表达式
        return idCard.matches(regex);
    }

    /**
     * bool to Int
     * @param value
     * @return
     */
    public static Integer boolToInt(Boolean value){
        Boolean val = Optional.ofNullable(value).orElse(false);
        return val?1:0;
    }

    /**
     * 替换https,http公用方法
     * @param url
     * @return
     */
    public static String convertHttpOrHttpsUrl(String url) {
        if(org.apache.commons.lang3.StringUtils.isEmpty(url)){
            return "//js2.tdw.cn/images/users/avatar/bav_head.png";
        }
        return url.trim().replace("https:", "").replace("http:", "");
    }


    public static void main(String[] args) {
        System.out.println(TuandaiUtil.md5Passwrod("123456a"));

    }

}
