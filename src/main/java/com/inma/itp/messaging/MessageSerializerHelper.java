package com.inma.itp.messaging;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Utility Class To Convert from Xml to Java Object and vice versa
 * 
 * @author ssatwa
 *
 */
@Slf4j
public class MessageSerializerHelper {

	private static XmlMapper xmlMapper = new XmlMapper();

	static {
		// Format Xml
//		xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
		xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
		xmlMapper.setSerializationInclusion(Include.NON_NULL);
		xmlMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
		xmlMapper.registerModule(new JaxbAnnotationModule());

//		xmlMapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
		xmlMapper.enable(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS);
		xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
	}

	/**
	 * Serialize our Object into XML string
	 * 
	 * @return xml string
	 */
	public static String serializeToXML(Object object) {
		try {
			String xmlString = xmlMapper.writeValueAsString(object);

//			logger.info("Parsing Object [{}] : \n{}", object.getClass().getSimpleName(), xmlString);

			return xmlString;
		} catch (JsonProcessingException e) {
			log.error("Error Parsing {}", e.getMessage());
		}
		return null;
	}

	/**
	 * Deserialize from the XML into object
	 * 
	 * @param <T>
	 * @param clazz   Should have no args constructor
	 * @param content Xml String
	 * @return Mapped Object from Xml
	 */
	public static <T> T deserializeFromXML(Class<T> clazz, String content) {
		try {

			T deserializedData = xmlMapper.readValue(content, clazz);

//			logger.info("Deserialize Object [{}]", deserializedData.getClass().getName());

			return deserializedData;
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Error Parsing {}", e.getMessage());
		}
		return null;
	}

	public static void main(String[] args) {
		PhoneDetails phoneDetails = new PhoneDetails("OnePlus", "6.4", "6/64 GB");
		String resultXml = MessageSerializerHelper.serializeToXML(phoneDetails);
		PhoneDetails resultObject = MessageSerializerHelper.deserializeFromXML(PhoneDetails.class, resultXml);

		System.out.println(resultObject.getName());
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class PhoneDetails {
		private String name;
		private String displaySize;
		private String memory;

	}

}
