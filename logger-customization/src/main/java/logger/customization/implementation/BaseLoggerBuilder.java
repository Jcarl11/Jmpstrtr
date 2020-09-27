package logger.customization.implementation;

import ch.qos.logback.classic.Logger;
import logger.utils.constants.LoggerConstants;

public abstract class BaseLoggerBuilder<E, T> {

	protected static String LOG_PATTERN = LoggerConstants.LOG_PATTERN;
	protected static String LOG_LOCATION_DEV = LoggerConstants.LOGS_LOCATION_DEV;
	protected static String LOG_LOCATION_INFORMATIONAL = LoggerConstants.LOGS_LOCATION_INFORMATIONAL;
	protected static String LOG_LOCATION_FLAWS = LoggerConstants.LOGS_LOCATION_FLAW;
	protected static String LOG_LOCATION_TRACES = LoggerConstants.LOGS_LOCATION_TRACE;

	abstract public E initializeLogger();
	abstract public E initializeEncoder();
	abstract public E initializeFilter();
	abstract public E initializeAppender();
	abstract public T logger();
	
}
