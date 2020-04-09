package com.inma.itp.models.queues;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name = "eTradePreOrdDtlsInqRs")
public class ETradePreOrdDtlsInqRs {
	@XmlElement(name = "MsgRsHdr")
	private MsgRsHdr msgRsHdr = new MsgRsHdr();

	@XmlElement(name = "Body")
	private Body body = new Body();

	@Data
	public static class Body {
		@XmlElement(name = "BankCommVATPercentage")
		private String bankCommVATPercentage;

		@XmlElement(name = "TotalComm")
		private String totalComm;

		@XmlElement(name = "TotTradeAmt")
		private String totTradeAmt;

		@XmlElement(name = "BankComm")
		private String bankComm;

		@XmlElement(name = "BankCommVAT")
		private String bankCommVAT;

		@XmlElement(name = "ExchangeFees")
		private String exchangeFees;
	}
}
