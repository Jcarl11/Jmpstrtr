package logger.customization.repository.interfaces;

public interface CustomizationLogger {

	public void trace(String msg);
	public void trace(String format, Object ... arguments);
	public void trace(String msg, Throwable t);
	public void debug(String msg);
	public void debug(String format, Object ... arguments);
	public void debug(String msg, Throwable t);
	public void info(String msg);
	public void info(String format, Object ... arguments);
	public void info(String msg, Throwable t);
	public void warn(String msg);
	public void warn(String format, Object ... arguments);
	public void warn(String msg, Throwable t);
	public void error(String msg);
	public void error(String format, Object ... arguments);
	public void error(String msg, Throwable t);

}
