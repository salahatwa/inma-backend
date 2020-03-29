package com.inma.itp.xml;

import org.springframework.stereotype.Service;


public interface XmlTemplateService {

	/**
	 * @param <T>    Response Object
	 * @param <R>    Sender Object
	 * @param object
	 * @return
	 */
	public <T, R> T sendMessage(R senderObject,Class<T> receivedObject);
}
