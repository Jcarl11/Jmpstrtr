package logger.customization.implementation;

import java.io.File;

import logger.utils.constants.LoggerConstants;

public abstract class BaseLoggerBuilder<E, T> {

	protected static String LOG_PATTERN = LoggerConstants.LOG_PATTERN;
	protected static String LOG_LOCATION_DEV = LoggerConstants.LOGS_LOCATION_DEV;
	protected static String LOG_LOCATION_INFORMATIONAL = LoggerConstants.LOGS_LOCATION_INFORMATIONAL;
	protected static String LOG_LOCATION_FLAWS = LoggerConstants.LOGS_LOCATION_FLAW;
	protected static String LOG_LOCATION_TRACES = LoggerConstants.LOGS_LOCATION_TRACE;
	protected static String MAX_FILE_SIZE = "5MB";
	protected static String TOTAL_CAP_SIZE = "50MB";
	protected static int MAX_HISTORY = 30; // 30 days
	protected static String FILE_PATTERN = String.format(LoggerConstants.FILE_NAME_PATTERN,
		LoggerConstants.LOGS_LOCATION_INFORMATIONAL, LoggerConstants.APP_NAME, LoggerConstants.LOGS_LABEL_INFO);

	abstract public E initializeLogger();
	abstract public E initializePolicy();
	abstract public E initializeEncoder();
	abstract public E initializeFilter();
	abstract public E initializeAppender();
	abstract public E assemble();
	abstract public T logger();

	public BaseLoggerBuilder() {
		new File(LOG_LOCATION_DEV).mkdirs();
		new File(LOG_LOCATION_INFORMATIONAL).mkdirs();
		new File(LOG_LOCATION_FLAWS).mkdirs();
		new File(LOG_LOCATION_TRACES).mkdirs();
	}

}
