package com.inma.itp.models.queues;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.inma.itp.config.annotations.InmaQueue;

import lombok.Data;

@Data
@XmlRootElement(name = "CustDtlsInqRq")
@InmaQueue(requestQueue = "CustDtlsInqRq", responseQueue = "CustDtlsInqRs")
public class CustDtlsInqRq {

	@XmlElement(name = "MsgRqHdr")
	private MsgRqHdr msgRqHdr = new MsgRqHdr();
}
