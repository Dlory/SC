package com.cwbase.logback;

import ch.qos.logback.classic.AsyncAppender;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class NonBlockingAsyncAppender extends AsyncAppender {

	@Override
	protected boolean isDiscardable(ILoggingEvent event) {
		return true;
	}
}
