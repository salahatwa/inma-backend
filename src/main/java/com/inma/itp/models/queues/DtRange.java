package com.inma.itp.models.queues;

import javax.xml.bind.annotation.XmlElement;

import lombok.Data;

@Data
public class DtRange {
	@XmlElement(name = "StartDt")
	private String startDt;

	@XmlElement(name = "EndDt")
	private String endDt;
}
