package com.inma.itp.models.queues;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.inma.itp.config.annotations.InmaQueue;

import lombok.Data;

@Data
@XmlRootElement(name = "eTradeOrdsInqRq")
@InmaQueue(requestQueue = "eTradeOrdsInqRq", responseQueue = "eTradeOrdsInqRs")
public class ETradeOrdsInqRq {

	@XmlElement(name = "MsgRqHdr")
	private MsgRqHdr msgRqHdr = new MsgRqHdr();

	@XmlElement(name = "Body")
	private Body body = new Body();

	public ETradeOrdsInqRq(String funcId, String agentId) {
		this.msgRqHdr.setFuncId(funcId);
		this.msgRqHdr.setAgentId(agentId);
	}

	@Data
	public static class Body {
		@XmlElement(name = "OrdSide")
		private String ordSide;

		@XmlElement(name = "OrdStatus")
		private String ordStatus;

		@XmlElement(name = "Symbol")
		private String symbol;

		@XmlElement(name = "DtRange")
		private DtRange dtRange = new DtRange();

		@XmlElement(name = "RecCtrlIn")
		private RecCtrlIn recCtrlIn = new RecCtrlIn();

		@XmlElement(name = "PortfolioNum")
		private String portfolioNum;

		@XmlElement(name = "Product")
		private String product;

	}
}
