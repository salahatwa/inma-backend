package com.inma.itp.models.queues;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.inma.itp.config.annotations.InmaQueue;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
@XmlRootElement(name = "eTradeOrdMngRq")
@InmaQueue(requestQueue = "eTradeOrdMngRq", responseQueue = "eTradeOrdMngRs")
public class ETradeOrdMngRq implements Serializable {

	@XmlElement(name = "MsgRqHdr")
	private MsgRqHdr msgRqHdr = new MsgRqHdr();

	@XmlElement(name = "Body")
	private Body body = new Body();

	public ETradeOrdMngRq(String funcId, String agentId) {
		this.msgRqHdr.setFuncId(funcId);
		this.msgRqHdr.setAgentId(agentId);
	}

	@Data
	public static class Body implements Serializable {

		@Getter(AccessLevel.NONE)
		@XmlElement(name = "eTradeOrdDtls")
		private ETradeOrdDtls eTradeOrdDtls = new ETradeOrdDtls();

		public ETradeOrdDtls geteTradeOrdDtls() {
			return eTradeOrdDtls;
		}

		public void seteTradeOrdDtls(ETradeOrdDtls eTradeOrdDtls) {
			this.eTradeOrdDtls = eTradeOrdDtls;
		}

		@Data
		public static class ETradeOrdDtls implements Serializable {

			@XmlElement(name = "OrdQty")
			private String ordQty;

			@XmlElement(name = "MaxFloor")
			private String maxFloor;

			@XmlElement(name = "CurAmt")
			private CurAmt curAmt = new CurAmt();

			@XmlElement(name = "TIFType")
			private String tifType;

			@XmlElement(name = "OrdSide")
			private String ordSide;

			@XmlElement(name = "Symbol")
			private String symbol;

			@XmlElement(name = "OrdType")
			private String ordType;

			@XmlElement(name = "PortfolioNum")
			private String portfolioNum;

			@XmlElement(name = "Product")
			private String product;

			@XmlElement(name = "ExpDt")
			private String expDt;

			@XmlElement(name = "MinFillQty")
			private String minFillQty;

		}

	}

}
