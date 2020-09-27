package logger.customization.implementation;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.filter.ThresholdFilter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import ch.qos.logback.core.util.FileSize;
import logger.customization.custom.filters.InformationalFilter;
import logger.utils.constants.LoggerConstants;

public class BasicLoggerImpl extends BaseLoggerBuilder<BasicLoggerImpl, Logger> {

	protected Logger logger;
	protected LoggerContext loggerCtx;
	protected ConsoleAppender<ILoggingEvent> consoleAppender;
	protected RollingFileAppender<ILoggingEvent> rollingFileAppender;
	protected SizeAndTimeBasedRollingPolicy<ILoggingEvent> sizeAndTimeBasedRollingPolicy;
	protected ThresholdFilter thresholdFilter;
	protected InformationalFilter informationalFilter;
	protected PatternLayoutEncoder patternLayoutEncoder;
	protected Level consoleAppenderFilterLevel = Level.DEBUG;
	protected Level loggerLevel = Level.ALL;
	private static BasicLoggerImpl instance = null;

	private BasicLoggerImpl() {
		super();
	}

	public static synchronized BasicLoggerImpl getInstance() {
		if (instance == null) {
			instance = new BasicLoggerImpl();
		}
		return instance;
	}

	@Override
	public BasicLoggerImpl initializeLogger() {
		loggerCtx = (LoggerContext) LoggerFactory.getILoggerFactory();
		logger = loggerCtx.getLogger(Logger.ROOT_LOGGER_NAME);
		logger.setLevel(loggerLevel);
		return this;
	}

	@Override
	public BasicLoggerImpl initializePolicy() {
		sizeAndTimeBasedRollingPolicy = new SizeAndTimeBasedRollingPolicy<ILoggingEvent>();
		sizeAndTimeBasedRollingPolicy.setContext(loggerCtx);
		sizeAndTimeBasedRollingPolicy.setFileNamePattern(FILE_PATTERN);
		sizeAndTimeBasedRollingPolicy.setMaxFileSize(FileSize.valueOf(MAX_FILE_SIZE));
		sizeAndTimeBasedRollingPolicy.setMaxHistory(MAX_HISTORY);
		sizeAndTimeBasedRollingPolicy.setTotalSizeCap(FileSize.valueOf(TOTAL_CAP_SIZE));
		return this;
	}

	@Override
	public BasicLoggerImpl initializeEncoder() {
		patternLayoutEncoder = new PatternLayoutEncoder();
		patternLayoutEncoder.setContext(loggerCtx);
		patternLayoutEncoder.setPattern(LOG_PATTERN);
		return this;
	}

	@Override
	public BasicLoggerImpl initializeFilter() {
		thresholdFilter = new ThresholdFilter();
		thresholdFilter.setContext(loggerCtx);
		thresholdFilter.setLevel(consoleAppenderFilterLevel.levelStr);
		informationalFilter = new InformationalFilter();
		informationalFilter.setContext(loggerCtx);
		return this;
	}

	@Override
	public BasicLoggerImpl initializeAppender() {
		consoleAppender = new ConsoleAppender<ILoggingEvent>();
		consoleAppender.setContext(loggerCtx);
		consoleAppender.addFilter(thresholdFilter);
		consoleAppender.setEncoder(patternLayoutEncoder);
		rollingFileAppender = new RollingFileAppender<ILoggingEvent>();
		rollingFileAppender.setContext(loggerCtx);
		rollingFileAppender.addFilter(informationalFilter);
		rollingFileAppender.setEncoder(patternLayoutEncoder);
		return this;
	}

	@Override
	public BasicLoggerImpl assemble() {
		sizeAndTimeBasedRollingPolicy.start();
		patternLayoutEncoder.start();
		thresholdFilter.start();
		informationalFilter.start();
		consoleAppender.start();
		rollingFileAppender.start();
		logger.addAppender(consoleAppender);
		logger.addAppender(rollingFileAppender);
		return this;
	}

	@Override
	public Logger logger() {
		return this.logger;
	}

}
