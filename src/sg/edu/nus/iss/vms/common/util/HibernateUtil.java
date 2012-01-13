package sg.edu.nus.iss.vms.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.NameFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.context.ContextLoader;

@SuppressWarnings("unchecked")
public class HibernateUtil {

	private static Logger log = Logger.getLogger(HibernateUtil.class);

	public static SessionFactory getSessionFactory() {
		// return sessionFactory;
		Object ctx = ContextLoader.getCurrentWebApplicationContext();
		if (ctx != null) {
			return (SessionFactory) ContextLoader.getCurrentWebApplicationContext().getBean("sessionFactory");
		}
		return null;
	}

	public static Session getSession() {
		// return session;
		return getSessionFactory().openSession();
	}

	public static Session getCurrentSession() {
		return getSessionFactory().getCurrentSession();
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}

	private static File getHibernatePropertiesFile(String fileName) {

		File file = new File(HibernateUtil.class.getResource("/").getFile());

		if (file.getParentFile().toString().endsWith("WEB-INF")) {
			file = file.getParentFile();
		}

		Collection collections = FileUtils.listFiles(file, new NameFileFilter(fileName), TrueFileFilter.INSTANCE);
		if (collections.size() > 0) {
			File hibernatePropertiesFile = (File) collections.iterator().next();
			return hibernatePropertiesFile;
		}

		return null;
	}

	public static Properties getHibernateProperties() {
		return getHibernateProperties("hibernate.properties");
	}

	public static Properties getHibernateProperties(String fileName) {
		Properties hibernateProperties = null;
		File cfg = getHibernatePropertiesFile(fileName);
		if (cfg != null && cfg.exists()) {
			try {

				hibernateProperties = new Properties();
				hibernateProperties.load(new FileInputStream(cfg));

				// setup hibernate properties
				log.debug("hibernate.properties load from " + cfg);
				return hibernateProperties;
			} catch (FileNotFoundException e) {
				log.warn("hibernate.properties NOT FOUND!", e);
			} catch (IOException e) {
				log.warn("hibernate.properties UNABLE TO LOAD!", e);
			}
		}

		// if no hibernate.properties found in system, create default
		hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.OracleDialect");

		log.debug("hibernate.properties not found, create default properties");
		return hibernateProperties;
	}
}