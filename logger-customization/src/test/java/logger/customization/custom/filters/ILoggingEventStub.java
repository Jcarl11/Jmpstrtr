package logger.customization.custom.filters;

import java.util.Map;

import org.slf4j.Marker;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.LoggerContextVO;


public class ILoggingEventStub implements ILoggingEvent {

	@Override
	public String getThreadName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Level getLevel() {
		// TODO Auto-generated method stub
		return Level.INFO;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getArgumentArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormattedMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLoggerName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoggerContextVO getLoggerContextVO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IThrowableProxy getThrowableProxy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StackTraceElement[] getCallerData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasCallerData() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Marker getMarker() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getMDCPropertyMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getMdc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getTimeStamp() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void prepareForDeferredProcessing() {
		// TODO Auto-generated method stub
	}

}
