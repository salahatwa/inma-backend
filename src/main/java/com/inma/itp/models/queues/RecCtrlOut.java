package com.inma.itp.models.queues;

import javax.xml.bind.annotation.XmlElement;

import lombok.Data;

@Data
public class RecCtrlOut {
	@XmlElement(name = "MatchedRecs")
	private String matchedRecs;

	@XmlElement(name = "SentRecs")
	private String sentRecs;
}
