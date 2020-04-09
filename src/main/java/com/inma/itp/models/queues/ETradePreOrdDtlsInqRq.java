package com.inma.itp.models.queues;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.inma.itp.config.annotations.InmaQueue;

import lombok.Data;

@Data
@XmlRootElement(name = "eTradePreOrdDtlsInqRq")
@InmaQueue(requestQueue = "eTradePreOrdDtlsInqRq", responseQueue = "eTradePreOrdDtlsInqRs")
public class ETradePreOrdDtlsInqRq {

	@XmlElement(name = "MsgRqHdr")
	private MsgRqHdr msgRqHdr = new MsgRqHdr();

	@XmlElement(name = "Body")
	private Body body = new Body();

	public ETradePreOrdDtlsInqRq(String funcId, String agentId) {
		this.msgRqHdr.setFuncId(funcId);
		this.msgRqHdr.setAgentId(agentId);
	}

	@Data
	public static class Body {

		@XmlElement(name = "OrdQty")
		private String ordQty;

		@XmlElement(name = "UnitPrice")
		private String unitPrice;

		@XmlElement(name = "OrdSide")
		private String ordSide;

		@XmlElement(name = "Symbol")
		private String symbol;

		@XmlElement(name = "OrdType")
		private String ordType;

		@XmlElement(name = "PortfolioNum")
		private String portfolioNum;
	}
}
