package com.inma.itp.models.queues;

import java.util.Objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.inma.itp.config.annotations.InmaQueue;
import com.inma.itp.models.queues.MsgRqHdr.CustId;

import lombok.Data;

@Data
@XmlRootElement(name = "eTradeCustPortfoliosInqRq")
@InmaQueue(requestQueue = "eTradeCustPortfoliosInqRq", responseQueue = "eTradeCustPortfoliosInqRs")
public class ETradeCustPortfoliosInqRq {
	@XmlElement(name = "MsgRqHdr")
	private MsgRqHdr msgRqHdr = new MsgRqHdr();

	@XmlElement(name = "Body")
	private Body body = new Body();

	public ETradeCustPortfoliosInqRq(String funcId, String agentId, String poiNum) {
		this.msgRqHdr.setAgentId(agentId);
		this.msgRqHdr.setFuncId(funcId);
		if (Objects.nonNull(poiNum)) {
			this.msgRqHdr.setCustId(new CustId());
			this.msgRqHdr.getCustId().getPoi().setPoiNum(poiNum);
		}
	}

	@Data
	public static class Body {
		@XmlElement(name = "PortfolioType")
		private String portfolioType;

		@XmlElement(name = "PortfolioNum")
		private String portfolioNum;

		@XmlElement(name = "Symbol")
		private String symbol;

	}
}
