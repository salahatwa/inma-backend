package com.inma.itp.models.queues;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@XmlRootElement(name = "eTradeOrdsInqRs")
public class ETradeOrdsInqRs {
	@XmlElement(name = "MsgRsHdr")
	private MsgRsHdr msgRsHdr = new MsgRsHdr();

	@XmlElement(name = "Body")
	private Body body = new Body();

	@Data
	public static class Body {
		@XmlElement(name = "OrdsList")
		private OrdsList OrdsList = new OrdsList();

		@XmlElement(name = "RecCtrlOut")
		private RecCtrlOut RecCtrlOut = new RecCtrlOut();

		@Data
		public static class OrdsList {

			@Getter(AccessLevel.NONE)
			@XmlElement(name = "eTradeOrdDtls")
			@JacksonXmlElementWrapper(useWrapping = false)
			private List<ETradeOrdDtls> eTradeOrdDtls = new ArrayList<>();

			public List<ETradeOrdDtls> geteTradeOrdDtls() {
				return eTradeOrdDtls;
			}

			public void seteTradeOrdDtls(List<ETradeOrdDtls> eTradeOrdDtls) {
				this.eTradeOrdDtls = eTradeOrdDtls;
			}

			@Data
			@NoArgsConstructor
			@XmlAccessorType(XmlAccessType.FIELD)
			public static class ETradeOrdDtls {
				@XmlElement(name = "OrdSide")
				private String ordSide;

				@XmlElement(name = "Symbol")
				private String symbol;

				@XmlElement(name = "PortfolioNum")
				private String portfolioNum;

				@XmlElement(name = "OrdCommiss")
				private String ordCommiss;

				@XmlElement(name = "UsrId")
				private String usrId;

				@XmlElement(name = "ExcTotalAmt")
				private String excTotalAmt;

				@XmlElement(name = "TIFType")
				private String tifType;

				@XmlElement(name = "OrdTm")
				private String ordTm;

				@XmlElement(name = "OrdStatus")
				private String ordStatus;

				@XmlElement(name = "TaxInfo")
				private TaxInfo taxInfo = new TaxInfo();

				@XmlElement(name = "AvgPrice")
				private String avgPrice;

				@XmlElement(name = "MrktPrice")
				private String mrktPrice;

				@XmlElement(name = "MrktCode")
				private String mrktCode;

				@XmlElement(name = "ExcQty")
				private String excQty;

				@XmlElement(name = "TADCommiss")
				private String tadCommiss;

				@XmlElement(name = "CIF")
				private String cif;

				@XmlElement(name = "OMSRefNum")
				private String omsRefNum;

				@XmlElement(name = "Broker")
				private String broker;

				@XmlElement(name = "OrdDtHjr")
				private String ordDtHjr;

				@XmlElement(name = "OrdType")
				private String ordType;

				@XmlElement(name = "BrokerCommiss")
				private String brokerCommiss;

				@XmlElement(name = "ExpDt")
				private String expDt;

				@XmlElement(name = "SAMAAcctNum")
				private String samaAcctNum;

				@XmlElement(name = "MrktRefNum")
				private String mrktRefNum;

				@XmlElement(name = "BankCommiss")
				private String bankCommiss;

				@XmlElement(name = "SCId")
				private String scId;

				@XmlElement(name = "RmnngQty")
				private String rmnngQty;

				@XmlElement(name = "OrdQty")
				private String ordQty;
				
				@XmlElement(name = "MaxFloor")
				private String maxFloor;

				@XmlElement(name = "CurAmt")
				private CurAmt curAmt = new CurAmt();

				@XmlElement(name = "MrktAuthrzd")
				private String mrktAuthrzd;

				@XmlElement(name = "DealerId")
				private String dealerId;

				@XmlElement(name = "OrdDt")
				private String ordDt;

				@Data
				public static class TaxInfo {
					@XmlElement(name = "TaxPercen")
					private String taxPercen;

					@XmlElement(name = "TaxType")
					private String taxType;

					@XmlElement(name = "TaxAmt")
					private String taxAmt;
				}
			}
		}
	}
}
