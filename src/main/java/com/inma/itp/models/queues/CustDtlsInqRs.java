package com.inma.itp.models.queues;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name = "CustDtlsInqRs")
public class CustDtlsInqRs {

	@XmlElement(name = "MsgRsHdr")
	private MsgRsHdr msgRsHdr = new MsgRsHdr();

	@XmlElement(name = "Body")
	private Body body = new Body();

	@Data
	public static class Body {
		@XmlElement(name = "ResidenceCountryCode")
		private String residenceCountryCode;
		@XmlElement(name = "CIF")
		private String cif;
		@XmlElement(name = "CustType")
		private String custType;
		@XmlElement(name = "AlinmaId")
		private String alinmaId;
		@XmlElement(name = "FamilyName")
		private String familyName;
		@XmlElement(name = "POI")
		private String FirstName;
		@XmlElement(name = "SAMAStatus")
		private String samaStatus;
		@XmlElement(name = "NationalityCode")
		private String nationalityCode;
		@XmlElement(name = "CustStatus")
		private String custStatus;
		@XmlElement(name = "Gender")
		private String gender;
		@XmlElement(name = "BranchId")
		private String branchId;
		@XmlElement(name = "PhoneInfo")
		private PhoneInfo phoneInfo = new PhoneInfo();
		@XmlElement(name = "LangPref")
		private String langPref;
		@XmlElement(name = "OpenDt")
		private String openDt;
		@XmlElement(name = "OpenDtHjr")
		private String openDtHjr;
		@XmlElement(name = "FullName")
		private String fullName;
		@XmlElement(name = "POIRec")
		private POIRec poiRec;
		@XmlElement(name = "FatherName")
		private String fatherName;

		@Data
		public class POIRec {
			@XmlElement(name = "POI")
			private POI poi = new POI();
		}

		@Data
		public static class PhoneInfo {
			@XmlElement(name = "PhoneCountryCode")
			private String phoneCountryCode;
			@XmlElement(name = "PhoneType")
			private String phoneType;
			@XmlElement(name = "PhoneNum")
			private String phoneNum;
			@XmlElement(name = "PhoneCategory")
			private String phoneCategory;
		}
	}
}
