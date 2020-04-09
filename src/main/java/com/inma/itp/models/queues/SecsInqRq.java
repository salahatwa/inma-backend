package com.inma.itp.models.queues;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.inma.itp.config.annotations.InmaQueue;

import lombok.Data;

@Data
@XmlRootElement(name = "SecsInqRq")
@InmaQueue(requestQueue = "SecsInqRq", responseQueue = "SecsInqRs")
public class SecsInqRq {

	@XmlElement(name = "MsgRqHdr")
	private MsgRqHdr msgRqHdr = new MsgRqHdr();

	@XmlElement(name = "Body")
	private Body body = new Body();
	
	public SecsInqRq(String funcId,String agentId)
	{
		this.msgRqHdr.setFuncId(funcId);
		this.msgRqHdr.setAgentId(agentId);
	}

	@Data
	public static class Body {
		@XmlElement(name = "ProductCode")
		private String productCode;

		@XmlElement(name = "Symbol")
		private String symbol;
	}
}
