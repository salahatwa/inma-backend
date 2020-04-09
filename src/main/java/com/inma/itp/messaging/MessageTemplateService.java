package com.inma.itp.messaging;

public interface MessageTemplateService {

	
	/**
	 * @param <T>    Response Object
	 * @param <R>    Sender Object
	 * @param object
	 * @return
	 */
	public <T, R> T sendMessage(R senderObject,Class<T> receivedObject);
}
