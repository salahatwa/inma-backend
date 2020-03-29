package com.inma.itp.queue.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name = "UsrAuthentRq")
public class UsrAuthentRq {

	@XmlElement(name = "MsgRqHdr")
	private MsgRqHdr msgRqHdr=new MsgRqHdr();

	@XmlElement(name = "Body")
	private Body body=new Body();

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
