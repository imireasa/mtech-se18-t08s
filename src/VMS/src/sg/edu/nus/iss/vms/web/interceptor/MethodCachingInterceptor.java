package sg.edu.nus.iss.vms.web.interceptor;

import java.io.Serializable;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

public class MethodCachingInterceptor implements MethodInterceptor {

	private CacheManager cacheManager;
	private Logger log = Logger.getLogger(MethodCachingInterceptor.class);
	private final String CACHE_DATA_KEY = "CACHE_DATA";

	public Object invoke(final MethodInvocation methodInvocation) throws Throwable {
		final String targetMethodName = methodInvocation.getMethod().getName();

		log.info("Attempting cacheManager.getCache first run (no args lookup).");

		Cache cache = cacheManager.getCache(targetMethodName);

		if (cache == null) { // Lets try with args now.
			log.info("No cache found in no args lookup.");

			final Object[] methodArgs = methodInvocation.getArguments();
			if (methodArgs != null) {
				log.info("Args on method attempting args cache lookup config.");

				final StringBuffer cacheName = new StringBuffer(targetMethodName);
				cacheName.append("(");
				for (int i = 0; i < methodArgs.length; i++) {
					cacheName.append(methodArgs[i].toString());
					if (i + 1 != methodArgs.length) {
						cacheName.append(",");
					}
				}
				cacheName.append(")");
				log.info("Attempting cacheManager.getCache with args lookup:" + cacheName);
				cache = cacheManager.getCache(cacheName.toString());
			}
		}

		boolean methodInvocationProceed = false;
		boolean methodInvocationCache = false;

		Object methodReturn = null;

		if (cache != null) {

			log.info("Cache Config. Found: " + cache.getName());

			final Element cacheElement = cache.get(CACHE_DATA_KEY);
			if (cacheElement == null) {
				methodInvocationProceed = true;
			} else {
				log.info("Cache Element Found");

				methodReturn = cacheElement.getValue();

				log.info("Using Cached Element for methodReturn.");

			}
			methodInvocationCache = true;
		}

		if (cache == null || methodInvocationProceed) {
			methodReturn = methodInvocation.proceed();
			if (methodInvocationCache) {
				final Element newCacheElement = new Element(CACHE_DATA_KEY, (Serializable) methodReturn);
				cache.put(newCacheElement);

				log.info("Created new CacheElement entry and stored in cache.");

			}
		}

		return methodReturn;
	}

	/**
	 * @return the cacheManager
	 */
	public CacheManager getCacheManager() {
		return cacheManager;
	}

	/**
	 * @param cacheManager
	 *            the cacheManager to set
	 */
	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}
}