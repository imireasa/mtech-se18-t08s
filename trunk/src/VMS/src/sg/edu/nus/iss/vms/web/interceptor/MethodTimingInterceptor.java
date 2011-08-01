package sg.edu.nus.iss.vms.web.interceptor;

import java.math.BigDecimal;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang.time.StopWatch;
import org.apache.log4j.Logger;

public class MethodTimingInterceptor {
	private final Logger log = Logger.getLogger(MethodTimingInterceptor.class);

	public Object invoke(final MethodInvocation methodInvocation) throws Throwable {
		final StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object methodResult = null;
		try {
			methodResult = methodInvocation.proceed();
		} finally {
			stopWatch.stop();
		}
		final long millis = stopWatch.getTime();
		final BigDecimal seconds = new BigDecimal(millis).divide(new BigDecimal(DateUtils.MILLIS_PER_SECOND), BigDecimal.ROUND_HALF_UP);

		log.info("Method Invocation [" + methodInvocation.getThis().getClass().getName() + "." + methodInvocation.getMethod().getName() + "] Total Time: " + seconds + "(seconds) "
				+ millis + "(millis)");

		return methodResult;
	}
}
