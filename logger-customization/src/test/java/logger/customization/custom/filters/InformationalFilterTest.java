package logger.customization.custom.filters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

public class InformationalFilterTest {

	private Filter<ILoggingEvent> informationalFilter = null;
	private ILoggingEvent iLoggingEventStub = null;

	@Before
	public void setUp() throws Exception {
		informationalFilter = new InformationalFilter();
		iLoggingEventStub = new ILoggingEventStub();
	}

	@Test
	public void INFO_Reply_test() {
		FilterReply fileFilterReply = informationalFilter.decide(iLoggingEventStub);
		assertArrayEquals("Filter with reply of INFO failed to accept", new FilterReply[] {FilterReply.ACCEPT},
			new FilterReply[] {fileFilterReply});
	}

}
