package logger.customization.implementation;

import ch.qos.logback.classic.Logger;
import logger.customization.repository.interfaces.CustomizationLogger;

public class CustomizedLoggerImpl implements CustomizationLogger {

	// TODO: Implement dependency injection here..
	private BaseLoggerBuilder<?> logger;

	public CustomizedLoggerImpl( BaseLoggerBuilder<?> logger ) {
		this.logger = logger;
	}

	@Override
	public void trace(String msg) {
		logger.logger().trace(msg);
	}

	@Override
	public void trace(String format, Object ... arguments) {
		logger.logger().trace(format, arguments);
	}

	@Override
	public void trace(String msg, Throwable t) {
		logger.logger().trace(msg, t);
	}

	@Override
	public void debug(String msg) {
		logger.logger().debug(msg);
	}

	@Override
	public void debug(String format, Object ... arguments) {
		logger.logger().debug(format, arguments);
	}

	@Override
	public void debug(String msg, Throwable t) {
		logger.logger().debug(msg, t);
	}

	@Override
	public void info(String msg) {
		logger.logger().info(msg);
	}

	@Override
	public void info(String format, Object ... arguments) {
		logger.logger().info(format, arguments);
	}

	@Override
	public void info(String msg, Throwable t) {
		logger.logger().info(msg, t);
	}

	@Override
	public void warn(String msg) {
		logger.logger().warn(msg);
	}

	@Override
	public void warn(String format, Object ... arguments) {
		logger.logger().warn(format, arguments);
	}

	@Override
	public void warn(String msg, Throwable t) {
		logger.logger().warn(msg, t);
	}

	@Override
	public void error(String msg) {
		logger.logger().error(msg);
	}

	@Override
	public void error(String format, Object ... arguments) {
		logger.logger().error(format, arguments);
	}

	@Override
	public void error(String msg, Throwable t) {
		logger.logger().error(msg, t);
	}

}
