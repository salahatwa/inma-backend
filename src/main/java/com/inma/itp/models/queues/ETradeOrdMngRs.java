package com.inma.itp.models.queues;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name = "eTradeOrdMngRs")
public class ETradeOrdMngRs {

	@XmlElement(name = "MsgRsHdr")
	private MsgRsHdr msgRsHdr = new MsgRsHdr();

	@XmlElement(name = "Body")
	private Body body = new Body();

	@Data
	public static class Body {
		@XmlElement(name = "CustLimit")
		private String custLimit;
	}
}
