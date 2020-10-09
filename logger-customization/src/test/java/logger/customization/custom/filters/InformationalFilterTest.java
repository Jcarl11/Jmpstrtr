package logger.customization.custom.filters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;

public class InformationalFilterTest {

	private Filter<ILoggingEvent> informationalFilter = null;
	private ILoggingEvent iLoggingEvent = null;

	@Before
	public void setUp() throws Exception {
		informationalFilter = new InformationalFilter();
		iLoggingEvent = new ILoggingEventStub();
	}

	@Test
	public void test() {
		
	}

}
