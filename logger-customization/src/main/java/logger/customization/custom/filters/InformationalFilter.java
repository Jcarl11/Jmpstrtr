package logger.customization.custom.filters;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

public class InformationalFilter extends Filter<ILoggingEvent> {

	private Level level;
	private String logger;

	@Override
	public FilterReply decide(ILoggingEvent event) {
		return event.getLevel() == Level.INFO || event.getLevel() == Level.DEBUG ? FilterReply.ACCEPT
			: FilterReply.DENY;
	}

	@Override
	public void start() {
		if (this.level != null && this.logger != null) super.start();
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public void setLogger(String logger) {
		this.logger = logger;
	}

}
