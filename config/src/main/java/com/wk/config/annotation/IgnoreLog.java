package com.wk.config.annotation;

import java.lang.annotation.*;

/**
 * 忽略Token验证
 *
 * @author ssc
 * @email 25444648@qq.com
 * @date 2017-03-23 15:44
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreLog {

}
