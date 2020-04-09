package com.inma.itp.models.queues;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.inma.itp.config.annotations.InmaQueue;

import lombok.Data;

@Data
@XmlRootElement(name = "UsrAuthentRq")
@InmaQueue(requestQueue ="UsrAuthentRq",responseQueue = "UsrAuthentRs")
public class UsrAuthentRq {

	@XmlElement(name = "MsgRqHdr")
	private MsgRqHdr msgRqHdr=new MsgRqHdr();

	@XmlElement(name = "Body")
	private Body body=new Body();

	public UsrAuthentRq(String funcId) {
		this.msgRqHdr.setFuncId(funcId);
	}
	
	@Data
	public class Body {
		@XmlElement(name = "Sec")
		private Sec sec=new Sec();

		@XmlElement(name = "LoginId")
		private LoginId loginId=new LoginId();
	}

	@Data
	public class LoginId {
		
		@XmlElement(name = "LoginAttribVal")
		private String loginAttribVal;

		@XmlElement(name = "LoginAttribType")
		private String loginAttribType;
	}

	@Data
	public class Sec {
		@XmlElement(name = "Info")
		private String info;

		@XmlElement(name = "InfoType")
		private String infoType;
	}

}
