package com.example.demo.utils;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * hibernate-validator校验工具类
 *
 * 参考文档：http://docs.jboss.org/hibernate/validator/5.4/reference/en-US/html_single/
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-15 10:50
 */
public class ValidatorUtils {
    private static Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

   /* *//**
     * 校验对象
     * @param object        待校验对象
     * @param groups        待校验的组
     * @throws AppBusinessException  校验不通过，则报AppBusinessException异常
     *//*
    public static void validateEntity(Object object, Class<?>... groups)
            throws AppBusinessException {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            StringBuilder msg = new StringBuilder();
            for(ConstraintViolation<Object> constraint:  constraintViolations){
                msg.append(constraint.getMessage()).append("<br>");
            }
            throw new AppBusinessException(msg.toString());
        }
    }
*/
    /**
     * 验证Email地址格式
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
        return phoneNum !=null && phoneNum.matches("^(13|14|15|17|18)[0-9]{9}$");
    }

    /**
     * 验证工号
     * @param empNo
     * @return
     */
    public static boolean isEmpNo(String empNo){
        return empNo !=null && empNo.matches("^JT-[0-9]+$");
    }
}
