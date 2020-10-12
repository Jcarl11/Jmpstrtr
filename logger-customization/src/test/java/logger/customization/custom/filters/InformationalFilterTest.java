package logger.customization.custom.filters;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

public class InformationalFilterTest {

	private Filter<ILoggingEvent> informationalFilter = null;
	private ILoggingEvent iLoggingEventStub = null;

	@Before
	public void setUp() throws Exception {
		informationalFilter = new InformationalFilter();
		iLoggingEventStub = mock(ILoggingEvent.class);
	}

	@Test
	public void INFO_Reply_test() {
		when(iLoggingEventStub.getLevel()).thenReturn(Level.INFO);
		FilterReply fileFilterReply = informationalFilter.decide(iLoggingEventStub);
		assertEquals("Filter with reply of INFO failed to accept", FilterReply.ACCEPT, fileFilterReply);
	}

	@Test
	public void DEBUG_Reply_test() {
		when(iLoggingEventStub.getLevel()).thenReturn(Level.DEBUG);
		FilterReply fileFilterReply = informationalFilter.decide(iLoggingEventStub);
		assertEquals("Filter with reply of DEBUG failed to accept", FilterReply.ACCEPT, fileFilterReply);
	}

	@Test
	public void WARN_Reply_test() {
		when(iLoggingEventStub.getLevel()).thenReturn(Level.WARN);
		FilterReply fileFilterReply = informationalFilter.decide(iLoggingEventStub);
		assertEquals("Filter reply other than INFO and DEBUG was accepted", FilterReply.DENY, fileFilterReply);
	}

	@Test
	public void ERROR_Reply_test() {
		when(iLoggingEventStub.getLevel()).thenReturn(Level.ERROR);
		FilterReply fileFilterReply = informationalFilter.decide(iLoggingEventStub);
		assertEquals("Filter reply other than INFO and DEBUG was accepted", FilterReply.DENY, fileFilterReply);
	}

	@Test
	public void ALL_Reply_test() {
		when(iLoggingEventStub.getLevel()).thenReturn(Level.ALL);
		FilterReply fileFilterReply = informationalFilter.decide(iLoggingEventStub);
		assertEquals("Filter reply other than INFO and DEBUG was accepted", FilterReply.DENY, fileFilterReply);
	}

	@Test
	public void OFF_Reply_test() {
		when(iLoggingEventStub.getLevel()).thenReturn(Level.OFF);
		FilterReply fileFilterReply = informationalFilter.decide(iLoggingEventStub);
		assertEquals("Filter reply other than INFO and DEBUG was accepted", FilterReply.DENY, fileFilterReply);
	}

}
