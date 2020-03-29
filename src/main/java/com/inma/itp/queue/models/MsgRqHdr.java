package com.inma.itp.queue.models;

import javax.xml.bind.annotation.XmlElement;

import lombok.Data;

@Data
public class MsgRqHdr {

	@XmlElement(name = "FuncId")
	private String funcId;

	@XmlElement(name = "RqUID")
	private String rqUID;

	@XmlElement(name = "SCId")
	private String scid;

}
