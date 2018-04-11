package cn.shana.slz.response;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解（过滤返回字段）
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SerializedField {
    /**
     * 需要返回的字段
     *
     * @return
     */
    String includes()[] default {};

    /**
     * 需要过滤的字段
     *
     * @return
     */
    String excludes()[] default {};

    /**
     * 数据是否需要加密
     *
     * @return
     */
    boolean encode() default true;
}
