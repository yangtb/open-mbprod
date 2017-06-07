package com.sm.open.mbprod.integration.common.log;

import com.sm.open.care.core.log.LogTrace;
import com.sm.open.core.facade.model.rpc.Result;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);


	@Around("@annotation(log)")
	public Object around(ProceedingJoinPoint point, Loggable log) throws Throwable {
		String paramsStr = convertParamsToString(point.getArgs());
		long start = System.currentTimeMillis();
		Object result = point.proceed();
		long end = System.currentTimeMillis();
		LogTrace trace = LogTrace.createLogTrace(null, null, log.bizType(), (end - start), paramsStr,
				"(" + (log.printResult() ? result : "-") + ")");
		if (result instanceof Result && !((Result) result).getIsSuccess()) {
			trace.setResultStatus(LogTrace.RESULT_STATUS_F).setErrorCode(((Result) result).getErrorCode())
					.setErrorMsg(((Result) result).getErrorDesc());
		} else {
			trace.setResultStatus(LogTrace.RESULT_STATUS_T);
		}
		LOGGER.info(trace.build());
		return result;
	}

	private String convertParamsToString(Object[] params) {
		StringBuilder sb = new StringBuilder("(");
		if (ArrayUtils.isNotEmpty(params)) {
			for (Object param : params) {
				sb.append(param).append(";");
			}
			sb.deleteCharAt(sb.length() - 1);
		} else {
			sb.append("-");
		}
		sb.append(")");
		return sb.toString();
	}
}
