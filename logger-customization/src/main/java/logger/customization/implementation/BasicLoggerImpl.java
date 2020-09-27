package logger.customization.implementation;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.filter.LevelFilter;
import ch.qos.logback.classic.filter.ThresholdFilter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import ch.qos.logback.core.spi.FilterReply;
import ch.qos.logback.core.util.FileSize;
import logger.customization.custom.filters.InformationalFilter;

public class BasicLoggerImpl extends BaseLoggerBuilder<BasicLoggerImpl, Logger> {

	protected Logger logger;
	protected LoggerContext loggerCtx;
	protected ConsoleAppender<ILoggingEvent> consoleAppender;
	protected RollingFileAppender<ILoggingEvent> informationalAppender;
	protected RollingFileAppender<ILoggingEvent> flawAppender;
	protected RollingFileAppender<ILoggingEvent> traceAppender;
	protected SizeAndTimeBasedRollingPolicy<ILoggingEvent> informationalRollingPolicy;
	protected SizeAndTimeBasedRollingPolicy<ILoggingEvent> flawsRollingPolicy;
	protected SizeAndTimeBasedRollingPolicy<ILoggingEvent> traceRollingPolicy;
	protected ThresholdFilter consoleAppenderFilter;
	protected ThresholdFilter flawsAppenderFilter;
	protected LevelFilter traceAppenderFilter;
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
		informationalRollingPolicy = new SizeAndTimeBasedRollingPolicy<ILoggingEvent>();
		informationalRollingPolicy.setContext(loggerCtx);
		informationalRollingPolicy.setFileNamePattern(INFORMATIONAL_FILE_PATTERN);
		informationalRollingPolicy.setMaxFileSize(FileSize.valueOf(MAX_FILE_SIZE));
		informationalRollingPolicy.setMaxHistory(MAX_HISTORY);
		informationalRollingPolicy.setTotalSizeCap(FileSize.valueOf(TOTAL_CAP_SIZE));
		flawsRollingPolicy = new SizeAndTimeBasedRollingPolicy<ILoggingEvent>();
		flawsRollingPolicy.setContext(loggerCtx);
		flawsRollingPolicy.setFileNamePattern(FLAWS_FILE_PATTERN);
		flawsRollingPolicy.setMaxFileSize(FileSize.valueOf(MAX_FILE_SIZE));
		flawsRollingPolicy.setMaxHistory(MAX_HISTORY);
		flawsRollingPolicy.setTotalSizeCap(FileSize.valueOf(TOTAL_CAP_SIZE));
		traceRollingPolicy = new SizeAndTimeBasedRollingPolicy<ILoggingEvent>();
		traceRollingPolicy.setContext(loggerCtx);
		traceRollingPolicy.setFileNamePattern(TRACE_FILE_PATTERN);
		traceRollingPolicy.setMaxFileSize(FileSize.valueOf(MAX_FILE_SIZE));
		traceRollingPolicy.setMaxHistory(MAX_HISTORY);
		traceRollingPolicy.setTotalSizeCap(FileSize.valueOf(TOTAL_CAP_SIZE));
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
		consoleAppenderFilter = new ThresholdFilter();
		consoleAppenderFilter.setContext(loggerCtx);
		consoleAppenderFilter.setLevel(consoleAppenderFilterLevel.levelStr);
		informationalFilter = new InformationalFilter();
		informationalFilter.setContext(loggerCtx);
		flawsAppenderFilter = new ThresholdFilter();
		flawsAppenderFilter.setContext(loggerCtx);
		flawsAppenderFilter.setLevel(Level.WARN.levelStr);
		traceAppenderFilter = new LevelFilter();
		traceAppenderFilter.setContext(loggerCtx);
		traceAppenderFilter.setLevel(Level.TRACE);
		traceAppenderFilter.setOnMatch(FilterReply.ACCEPT);
		traceAppenderFilter.setOnMismatch(FilterReply.DENY);
		return this;
	}

	@Override
	public BasicLoggerImpl initializeAppender() {
		consoleAppender = new ConsoleAppender<ILoggingEvent>();
		consoleAppender.setContext(loggerCtx);
		consoleAppender.addFilter(consoleAppenderFilter);
		consoleAppender.setEncoder(patternLayoutEncoder);
		informationalAppender = new RollingFileAppender<ILoggingEvent>();
		informationalAppender.setContext(loggerCtx);
		informationalAppender.addFilter(informationalFilter);
		informationalAppender.setEncoder(patternLayoutEncoder);
		informationalAppender.setRollingPolicy(informationalRollingPolicy);
		flawAppender = new RollingFileAppender<ILoggingEvent>();
		flawAppender.setContext(loggerCtx);
		flawAppender.addFilter(flawsAppenderFilter);
		flawAppender.setEncoder(patternLayoutEncoder);
		flawAppender.setRollingPolicy(flawsRollingPolicy);
		traceAppender = new RollingFileAppender<ILoggingEvent>();
		traceAppender.setContext(loggerCtx);
		traceAppender.addFilter(traceAppenderFilter);
		traceAppender.setEncoder(patternLayoutEncoder);
		traceAppender.setRollingPolicy(traceRollingPolicy);
		return this;
	}

	@Override
	public BasicLoggerImpl assemble() {
		informationalRollingPolicy.start();
		flawsRollingPolicy.start();
		traceRollingPolicy.start();
		patternLayoutEncoder.start();
		consoleAppenderFilter.start();
		informationalFilter.start();
		flawsAppenderFilter.start();
		traceAppenderFilter.start();
		consoleAppender.start();
		informationalAppender.start();
		flawAppender.start();
		traceAppender.start();
		logger.addAppender(consoleAppender);
		logger.addAppender(informationalAppender);
		logger.addAppender(flawAppender);
		logger.addAppender(traceAppender);
		return this;
	}

	@Override
	public Logger logger() {
		return this.logger;
	}

}
