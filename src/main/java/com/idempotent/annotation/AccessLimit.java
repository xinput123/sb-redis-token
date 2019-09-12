package com.idempotent.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在需要保证接口防刷限流的Controller的方法上使用此注解
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessLimit {

    /**
     * 最大访问次数
     */
    int max();

    /**
     * 固定时间，单位: s
     */
    int seconds();
}
