package logger.customization.custom.filters;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

public class InformationalFilter extends Filter<ILoggingEvent> {

	Level level;

	@Override
	public FilterReply decide(ILoggingEvent event) {
		return event.getLevel() == Level.INFO || event.getLevel() == Level.DEBUG ? FilterReply.ACCEPT
			: FilterReply.DENY;
	}

	@Override
	public void start() {
		if (this.level != null) super.start();
	}

	public void setLevel(String level) {
		this.level = Level.toLevel(level);
	}

}
