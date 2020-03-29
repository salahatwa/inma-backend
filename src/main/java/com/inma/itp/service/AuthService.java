package com.inma.itp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inma.itp.models.Role;
import com.inma.itp.models.User;
import com.inma.itp.queue.models.UsrAuthentRq;
import com.inma.itp.queue.models.UsrAuthentRs;
import com.inma.itp.queue.models.UsrAuthentRs.Body.BankUsrInfo.RoleInfo;
import com.inma.itp.secuirty.UserPrincipal;
import com.inma.itp.xml.XmlTemplateService;

@Service
public class AuthService {

	@Autowired
	private XmlTemplateService xmlTemplateService;

	public UserPrincipal login(String username, String password) {

		try {

			UsrAuthentRq rq = new UsrAuthentRq();
			rq.getMsgRqHdr().setRqUID("ITP201911197B94DDF8F67CBF2A");
			rq.getMsgRqHdr().setFuncId("10080000");
			rq.getMsgRqHdr().setScid("ITP");
			rq.getBody().getLoginId().setLoginAttribVal("naif01");
			rq.getBody().getLoginId().setLoginAttribType("4");
			rq.getBody().getSec().setInfo("18BD4EBD1A9436142D16224C33327A9B8323AC8949AF256D1C37930C6308B2DB");
			rq.getBody().getSec().setInfoType("1");

			UsrAuthentRs rs = xmlTemplateService.sendMessage(rq, UsrAuthentRs.class);

			

			User user = new User();
			user.setId(rs.getBody().getBankUsrInfo().getUsrId());
			user.setLang(rs.getBody().getBankUsrInfo().getLangPref());

			List<RoleInfo> roles = rs.getBody().getBankUsrInfo().getRoles();

			for (RoleInfo role : roles) {
				user.getRoles().add(new Role(role.getRoleId()));
			}
			return UserPrincipal.create(user);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
