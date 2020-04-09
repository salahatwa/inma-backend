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
@XmlRootElement(name = "eTradeCustPortfoliosInqRs")
public class ETradeCustPortfoliosInqRs {
	@XmlElement(name = "MsgRsHdr")
	private MsgRsHdr msgRsHdr = new MsgRsHdr();

	@XmlElement(name = "Body")
	private Body body = new Body();

	@Data
	public static class Body {

		@XmlElement(name = "PortfoliosList")
		private PortfoliosList portfoliosList = new PortfoliosList();

		@XmlElement(name = "RecCtrlOut")
		private RecCtrlOut recCtrlOut = new RecCtrlOut();

		@Data
		public static class PortfoliosList {

			@XmlElement(name = "PortfolioDtls")
			@JacksonXmlElementWrapper(useWrapping = false)
			private List<PortfolioDtls> portfolioDtls = new ArrayList<>();

			@Data
			@NoArgsConstructor
			@XmlAccessorType(XmlAccessType.FIELD)
			public static class PortfolioDtls {

				@XmlElement(name = "AcctId")
				private AcctId acctId = new AcctId();

				@XmlElement(name = "ExcBuyAmt")
				private String excBuyAmt;

				@XmlElement(name = "POINum")
				private String poiNum;

				@XmlElement(name = "BuyingPwr")
				private String buyingPwr;

				@XmlElement(name = "TotalMrktVal")
				private String totalMrktVal;

				@XmlElement(name = "PortfolioPositionAmt")
				private String portfolioPositionAmt;

				@XmlElement(name = "PortfolioNum")
				private String portfolioNum;

				@XmlElement(name = "PortfolioType")
				private String portfolioType;

				@XmlElement(name = "SAMAAcctNum")
				private String samaAcctNum;

				@XmlElement(name = "MobileNum")
				private String mobileNum;

				@XmlElement(name = "DiscountRate")
				private String discountRate;

				@XmlElement(name = "TotalCost")
				private String totalCost;

				@XmlElement(name = "ExcSellAmt")
				private String excSellAmt;

				@XmlElement(name = "TotalRealizedProfitLoss")
				private String totalRealizedProfitLoss;

				@XmlElement(name = "TradeSecsList")
				private TradeSecsList tradeSecsList = new TradeSecsList();

				@XmlElement(name = "AvailBal")
				private String availBal;

				@XmlElement(name = "OutstandBuyAmt")
				private String outstandBuyAmt;

				@XmlElement(name = "TotalUnrealizedProfitLoss")
				private String totalUnrealizedProfitLoss;

				@XmlElement(name = "OutstandSellAmt")
				private String outstandSellAmt;

				@XmlElement(name = "PortfolioName")
				private String portfolioName;

				@XmlElement(name = "MarginLimit")
				private String marginLimit;

				@Data
				public static class AcctId {
					@XmlElement(name = "AcctNum")
					private String acctNum;

					@XmlElement(name = "AcctType")
					private String acctType;
				}

				@Data
				public static class TradeSecsList {

					@XmlElement(name = "TradeSec")
					@JacksonXmlElementWrapper(useWrapping = false)
					private List<TradeSec> tradeSec = new ArrayList<>();

					@Data
					@NoArgsConstructor
					@XmlAccessorType(XmlAccessType.FIELD)
					public static class TradeSec {

						@XmlElement(name = "OutstandBuyQuantity")
						private String outstandBuyQuantity;

						@XmlElement(name = "PledgedQuantity")
						private String pledgedQuantity;

						@XmlElement(name = "SecEnName")
						private String secEnName;

						@XmlElement(name = "UnrealizedProfitLossPercen")
						private String unrealizedProfitLossPercen;

						@XmlElement(name = "OutstandSellQuantity")
						private String outstandSellQuantity;

						@XmlElement(name = "TotalMrktVal")
						private String totalMrktVal;

						@XmlElement(name = "Symbol")
						private String symbol;

						@XmlElement(name = "SecArName")
						private String secArName;

						@XmlElement(name = "OwnedQuantity")
						private String ownedQuantity;

						@XmlElement(name = "TotalCost")
						private String totalCost;

						@XmlElement(name = "AvgCostPrice")
						private String avgCostPrice;

						@XmlElement(name = "AvailQuantity")
						private String availQuantity;

						@XmlElement(name = "UnrealizedProfitLoss")
						private String unrealizedProfitLoss;

						@XmlElement(name = "RealizedProfitLossPercen")
						private String realizedProfitLossPercen;

						@XmlElement(name = "UnsettledBuyQuantity")
						private String unsettledBuyQuantity;

						@XmlElement(name = "RealizedProfitLoss")
						private String realizedProfitLoss;

						@XmlElement(name = "MrktPrice")
						private String mrktPrice;

						@XmlElement(name = "UnsettledSellQuantity")
						private String unsettledSellQuantity;
					}
				}

			}
		}

	}
}
