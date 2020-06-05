package com.sm.open.mbprod.integration.common.log;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Loggable {

	String bizType();

	boolean printResult() default true;
}
