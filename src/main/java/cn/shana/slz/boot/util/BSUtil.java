package cn.shana.slz.boot.util;

import cn.shana.slz.boot.exception.BusinessException;
import cn.shana.slz.boot.response.ErrorEnum;

import java.util.function.Predicate;

/**
 * 业务工具类
 */
public class BSUtil {

    public static final String ILLEGAL_OPERATION = "illegal operation!";

    public static final String FAILED_OPERATION = "操作失败!";

    public static <T> void isTrue(T arg, Predicate<T> predicate, ErrorEnum errorEnum, String error){
        if(!predicate.test(arg)){
            throw new BusinessException(errorEnum, error);
        }
    }

    public static void isTrue(boolean expression, ErrorEnum errorEnum, String error){
        if(!expression) {
            throw new BusinessException(errorEnum, error);
        }
    }

    public static void isNull(Object object, ErrorEnum errorEnum, String error){
        if(object != null) {
            throw new BusinessException(errorEnum, error);
        }
    }

    public static void notNull(Object object, ErrorEnum errorEnum, String error) {
        if(object == null) {
            throw new BusinessException(errorEnum, error);
        }
    }

    /**
     * 正则校验
     * @param input
     * @param regexp
     * @param error
     */
    public static void validateRegexp(String input, String regexp, ErrorEnum errorEnum, String error){
        isTrue(input.matches(regexp), errorEnum, error);
    }
}
