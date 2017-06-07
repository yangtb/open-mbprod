package com.sm.open.mbprod.integration.common.retry;

import java.lang.annotation.*;

/**
* @ClassName: Retryable
* @Description: 重试注解
*/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Retryable {

	int retryTimes() default -1;

}
