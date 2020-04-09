package com.inma.itp.models.queues;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@XmlRootElement(name = "SecsInqRs")
public class SecsInqRs {
	@XmlElement(name = "MsgRsHdr")
	private MsgRsHdr msgRsHdr = new MsgRsHdr();

	@XmlElement(name = "Body")
	private Body body = new Body();

	@Data
	public static class Body {
		@XmlElement(name = "SecList")
		private SecList secList=new SecList();

		@Data
		public static class SecList {

			@XmlElement(name = "SecRec")
			@JacksonXmlElementWrapper(useWrapping = false)
			private List<SecRec> secRec=new ArrayList<>();

			@Data
			@NoArgsConstructor
			@XmlAccessorType(XmlAccessType.FIELD)
			public static class SecRec {

				@XmlElement(name = "Symbol")
				private String symbol;

				@XmlElement(name = "Tradable")
				private String tradable;

				@XmlElement(name = "PriceChangeRate")
				private String priceChangeRate;

				@XmlElement(name = "TradedVol")
				private String tradedVol;

				@XmlElement(name = "SecArName")
				private String secArName;

				@XmlElement(name = "PriceChangeAmt")
				private String priceChangeAmt;

				@XmlElement(name = "MinPriceLimit")
				private String minPriceLimit;

				@XmlElement(name = "MLEnabled")
				private String mLEnabled;

				@XmlElement(name = "TradableRights")
				private String tradableRights;

				@XmlElement(name = "LosePercen")
				private String losePercen;

				@XmlElement(name = "MrktCode")
				private String mrktCode;

				@XmlElement(name = "MaxPriceLimit")
				private String maxPriceLimit;

				@XmlElement(name = "SettlementDays")
				private String settlementDays;

				@XmlElement(name = "BestBidQty")
				private String bestBidQty;

				@XmlElement(name = "SecEnName")
				private String secEnName;

				@XmlElement(name = "BestAskPrice")
				private String bestAskPrice;

				@XmlElement(name = "LoserCompany")
				private String loserCompany;

				@XmlElement(name = "LastPrice")
				private String lastPrice;

				@XmlElement(name = "TradableRightsAlert")
				private String tradableRightsAlert;

				@XmlElement(name = "BestBidPrice")
				private String bestBidPrice;

				@XmlElement(name = "OpenPrice")
				private String openPrice;

				@XmlElement(name = "RiskRate")
				private String riskRate;

				@XmlElement(name = "LoserAlert")
				private String loserAlert;

				@XmlElement(name = "BestAskQty")
				private String bestAskQty;

				@XmlElement(name = "PrevClosure")
				private String prevClosure;
			}
		}
	}
}
