package com.inma.itp.xml;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

/**
 * Generice Template Service implementation offline equal false send message to
 * queue and received response offline equal true read response from resources
 * 
 * @author ssatwa
 *
 */
@Service
public class XmlTemplateServiceImpl implements XmlTemplateService {
	private static Logger logger = LoggerFactory.getLogger(XmlTemplateService.class);

	@Value("${isOffline}")
	private boolean isOffline;

	@Override
	public <T, R> T sendMessage(R senderObject, Class<T> receivedObject) {
		String rqMsg=XmlSerializerHelper.serializeToXML(senderObject);
		logger.info("Sending message \n{}",rqMsg);
		if (isOffline) {
			T response = XmlSerializerHelper.deserializeFromXML(receivedObject, getFakeRes(senderObject));
			
			logger.info("Received message \n{}", getFakeRes(senderObject));
			return response;
		} else {
			// Implementation to send message to Queue and get response
		}
		return null;
	}

	private String getFakeRes(Object object) {
		try {
			String objectName = object.getClass().getSimpleName();
			String fileName = objectName.substring(0, objectName.length() - 2) + "Rs.xml";

			Resource resource = new ClassPathResource("offline-msg/" + fileName);
			InputStream inputStream = resource.getInputStream();
			byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
			String xmlMsg = new String(bdata, StandardCharsets.UTF_8);
			return xmlMsg;
		} catch (Exception ex) {
			logger.error("Error File not found {}" + ex.getMessage());
		}
		return null;
	}
}
