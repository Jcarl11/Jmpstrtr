package logger.customization.implementation;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import logger.utils.constants.LoggerConstants;

public abstract class BaseLoggerBuilder<E, T> {

	protected String LOG_PATTERN = LoggerConstants.LOG_PATTERN;
	protected String LOG_LOCATION_DEV = LoggerConstants.LOGS_LOCATION_DEV;
	protected String LOG_LOCATION_INFORMATIONAL = LoggerConstants.LOGS_LOCATION_INFORMATIONAL;
	protected String LOG_LOCATION_FLAWS = LoggerConstants.LOGS_LOCATION_FLAW;
	protected String LOG_LOCATION_TRACES = LoggerConstants.LOGS_LOCATION_TRACE;
	protected String MAX_FILE_SIZE = "5MB";
	protected String TOTAL_CAP_SIZE = "50MB";
	protected int MAX_HISTORY = 30; // 30 days
	protected String INFORMATIONAL_FILE_PATTERN = String.format(LoggerConstants.FILE_NAME_PATTERN,
		LoggerConstants.LOGS_LOCATION_INFORMATIONAL, LoggerConstants.APP_NAME, LoggerConstants.LOGS_LABEL_INFO);
	protected String FLAWS_FILE_PATTERN = String.format(LoggerConstants.FILE_NAME_PATTERN,
		LoggerConstants.LOGS_LOCATION_FLAW, LoggerConstants.APP_NAME, LoggerConstants.LOGS_LABEL_FLAWS);
	protected String TRACE_FILE_PATTERN = String.format(LoggerConstants.FILE_NAME_PATTERN,
		LoggerConstants.LOGS_LOCATION_TRACE, LoggerConstants.APP_NAME, LoggerConstants.LOGS_LABEL_TRACES);
	protected String DEV_FILE_PATTERN = String.format(LoggerConstants.FILE_NAME_PATTERN,
		LoggerConstants.LOGS_LOCATION_DEV, LoggerConstants.LOGS_LABEL_DEV, getTimeStamp());

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
	
	private String getTimeStamp() {
		Calendar currentDate = Calendar.getInstance();
		return new SimpleDateFormat("yyyyMMddHHmmss").format(currentDate.getTime());
	}

}
