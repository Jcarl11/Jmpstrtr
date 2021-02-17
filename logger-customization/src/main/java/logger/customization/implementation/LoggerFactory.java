package logger.customization.implementation;

import ch.qos.logback.classic.Logger;
import logger.utils.loggerEnums.LoggerImpl;

public class LoggerFactory {

	public static BaseLoggerBuilder<?, ? extends Logger> getLogger(LoggerImpl loggerImpl) {
		switch (loggerImpl) {
		case BASICLOGGERIMPL:
			return BasicLoggerImpl.getInstance().initializeLogger().initializeFilter().initializeEncoder()
				.initializeAppender().assemble();
		default:
			try {
				throw new Exception("Logger implementation not found");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

}
