package com.inma.itp.models.queues;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@XmlRootElement(name = "UsrAuthentRs")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsrAuthentRs {

	@XmlElement(name = "MsgRsHdr")
	private MsgRsHdr msgRsHdr = new MsgRsHdr();

	@XmlElement(name = "Body")
	private Body body = new Body();

	@Data
	public static class Body {
		@XmlElement(name = "BankUsrInfo")
		private BankUsrInfo bankUsrInfo = new BankUsrInfo();

		@XmlElement(name = "OneTmPswdFlg")
		private String oneTmPswdFlg;

		@Data
		@XmlAccessorType(XmlAccessType.FIELD)
		public static class BankUsrInfo {
			@XmlElement(name = "LastLoginTmstmp")
			private String lastLoginTmstmp;

			@XmlElement(name = "DeptCode")
			private String deptCode;

			@XmlElement(name = "RoleInfo")
			@JacksonXmlElementWrapper(useWrapping = false)
			private List<RoleInfo> roles;

			@XmlElement(name = "UsrId")
			private String usrId;

			@XmlElement(name = "LangPref")
			private String langPref;

			@XmlElement(name = "NumOfFailedLogins")
			private String numOfFailedLogins;

			@Data
			@NoArgsConstructor
			@XmlAccessorType(XmlAccessType.FIELD)
			public static class RoleInfo {
				@XmlElement(name = "RoleId")
				private String roleId;

			}
		}
	}

}
