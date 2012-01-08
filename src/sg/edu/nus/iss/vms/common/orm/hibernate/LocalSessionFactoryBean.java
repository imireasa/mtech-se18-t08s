/**
 *
 */
package sg.edu.nus.iss.vms.common.orm.hibernate;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import sg.edu.nus.iss.vms.common.util.HibernateUtil;

/**
 * Override Spring Framework Hibernate LocalSession
 * 
 * @author zaw.htet
 * 
 */
public class LocalSessionFactoryBean extends org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean {

	protected Pattern includePattern = null;
	protected Pattern excludePattern = null;

	/**
	 * @param includePattern
	 *            the includePattern to set
	 */
	public void setIncludePattern(String pattern) {
		if (StringUtils.isNotBlank(pattern)) {
			try {
				this.includePattern = Pattern.compile(pattern);
			} catch (PatternSyntaxException e) {
				this.includePattern = null;
			}
		}
	}

	/**
	 * @param excludePattern
	 *            the excludePattern to set
	 */
	public void setExcludePattern(String pattern) {
		if (StringUtils.isNotBlank(pattern)) {
			try {
				this.excludePattern = Pattern.compile(pattern);
			} catch (PatternSyntaxException e) {
				this.includePattern = null;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.orm.hibernate3.AbstractSessionFactoryBean#
	 * afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		setupHibernateProperties();
		setupMappingResources();

		super.afterPropertiesSet();
	}

	@SuppressWarnings("unchecked")
	protected void setupMappingResources() {
		File file = new File(LocalSessionFactoryBean.class.getResource("/com/attsystems/model/").getFile());
		Collection collections = FileUtils.listFiles(file, new String[] { ".class" }, true);

		List resources = new ArrayList();

		String basePath = file.getPath();
		for (Iterator iter = collections.iterator(); iter.hasNext();) {
			File f = (File) iter.next();
			String path = StringUtils.replace(f.getPath(), basePath, "");
			if (path.charAt(0) == '/' || path.charAt(0) == '\\') {
				path = path.substring(1);
			}
			path = StringUtils.replace(path, "\\", "/");

			if (isPathIncluded(path)) {
				resources.add(path);
			}
		}
		setPackagesToScan((String[]) resources.toArray(new String[resources.size()]));
	}

	protected void setupHibernateProperties() {
		// logger.debug("entering setupHibernateProperties");
		Properties hibernateProperties = HibernateUtil.getHibernateProperties();
		// logger.debug("hibernate.properties=" + hibernateProperties);

		setHibernateProperties(hibernateProperties);
	}

	/**
	 * Decide is path (*.hbm.xml) is included or excluded to resources based on
	 * include pattern or exclude pattern (using java regular expression)
	 * 
	 * @param path
	 * @return
	 */
	protected boolean isPathIncluded(String path) {
		boolean isIncluded = false;
		if (includePattern != null) {
			if (includePattern.matcher(path).matches()) {
				if (excludePattern != null) {
					if (!excludePattern.matcher(path).matches()) {
						isIncluded = true;
					}
				} else {
					isIncluded = true;
				}
			}
		} else {
			if (excludePattern != null) {
				if (!excludePattern.matcher(path).matches()) {
					isIncluded = true;
				}
			} else {
				isIncluded = true;
			}
		}

		return isIncluded;
	}
}
