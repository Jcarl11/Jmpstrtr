package logger.utils.constants;

public class LoggerConstants {

	public static final String LOG_PATTERN = "<<%level>>%date{MMM dd yyyy HH:mm:ss} [%thread] (%class{0}.%M:%L) - %msg%n";
	public static final String LOGS_LOCATION_DEV = String.format("%s/logs/dev-logs", System.getProperty("user.dir"));
	public static final String LOGS_LOCATION_FLAW = String.format("%s/logs/flaw-logs", System.getProperty("user.dir"));
	public static final String LOGS_LOCATION_INFORMATIONAL = String.format("%s/logs/informational-logs",
		System.getProperty("user.dir"));
	public static final String LOGS_LOCATION_TRACE = String.format("%s/logs/trace-logs", System.getProperty("user.dir"));
	public static final String APP_NAME = "JMPSTRTR";
	public static final String LOGS_LABEL_DEV = "DEV";
	public static final String LOGS_LABEL_INFO = "INFORMATIONAL";
	public static final String LOGS_LABEL_FLAWS = "FLAWS";
	public static final String LOGS_LABEL_TRACES = "TRACES";
	public static final String FILE_NAME_PATTERN = "%s/LOG_%s.%s_%d{yyyyMMdd}%i.log";

}
