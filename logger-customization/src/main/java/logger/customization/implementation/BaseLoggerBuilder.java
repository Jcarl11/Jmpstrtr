package logger.customization.implementation;

import ch.qos.logback.classic.Logger;

public abstract class BaseLoggerBuilder<E> {

	protected static String LOG_PATTERN = "<<%level>>%date{MMM dd yyyy HH:mm:ss} [%thread] (%class{0}.%M:%L) - %msg%n";
	protected static String LOG_LOCATION_DEV = String.format("%s/logs/dev-logs", System.getProperty("user.dir"));
	protected static String LOG_LOCATION_INFORMATIONAL = String.format("%s/logs/informational-logs",
		System.getProperty("user.dir"));
	protected static String LOG_LOCATION_FLAWS = String.format("%s/logs/flaw-logs", System.getProperty("user.dir"));
	protected static String LOG_LOCATION_TRACES = String.format("%s/logs/trace-logs", System.getProperty("user.dir"));

	abstract public E initializeLogger();
	abstract public E initializeEncoder();
	abstract public E initializeFilter();
	abstract public E initializeAppender();
	abstract public Logger logger();
	
}
