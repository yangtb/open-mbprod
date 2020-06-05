package com.sm.open.mbprod.integration.common.retry;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName: RetryAspect
 * @Description: 重试请求切面
 */
@Component
@Aspect
public class RetryAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(RetryAspect.class);

    /**默认尝试执行次数*/
    @Value(value = "${integration.retry.num}")
    private int defaultRetryTimes = 3;

    @Around("@annotation(retry)")
    public Object around(ProceedingJoinPoint point, Retryable retry) throws Throwable {
        int retryTimes = defaultRetryTimes;
        if (retry.retryTimes() >= 0) {
            retryTimes = retry.retryTimes();
        }
        for (int i = 0; i <= retryTimes; i++) {
            try {
                return point.proceed();
            } catch (Exception e) {
                String message = "【Retry执行异常，第" + i + "次执行】";
                LOGGER.error(message, e);
            }
        }
        return null;
    }

}
