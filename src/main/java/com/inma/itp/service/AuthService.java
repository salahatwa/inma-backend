package com.inma.itp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.inma.itp.config.secuirty.UserPrincipal;
import com.inma.itp.exception.ResourceNotFoundException;
import com.inma.itp.messaging.MessageTemplateService;
import com.inma.itp.models.Role;
import com.inma.itp.models.User;
import com.inma.itp.models.queues.UsrAuthentRq;
import com.inma.itp.models.queues.UsrAuthentRs;
import com.inma.itp.models.queues.UsrAuthentRs.Body.BankUsrInfo.RoleInfo;
import com.inma.itp.repository.UserRepository;
import com.inma.itp.utils.Security;

@Service
public class AuthService {

	@Autowired
	private MessageTemplateService msgTemplateService;

	@Autowired
	private UserRepository userRepo;

	public UserPrincipal login(String username, String password) {

		UsrAuthentRq rq = new UsrAuthentRq("10080000");
		rq.getBody().getLoginId().setLoginAttribVal(username);
		rq.getBody().getLoginId().setLoginAttribType("4");
		// password should be encrypted
		rq.getBody().getSec().setInfo(Security.byteToHex(Security.getHash(password)));
		rq.getBody().getSec().setInfoType("1");

		UsrAuthentRs rs = msgTemplateService.sendMessage(rq, UsrAuthentRs.class);

		User user = new User();
		user.setId(rs.getBody().getBankUsrInfo().getUsrId());
		user.setLang(rs.getBody().getBankUsrInfo().getLangPref());
		user.setDeptCode(rs.getBody().getBankUsrInfo().getDeptCode());
		user.setNumOfFailedLogins(rs.getBody().getBankUsrInfo().getNumOfFailedLogins());

		List<RoleInfo> roles = rs.getBody().getBankUsrInfo().getRoles();

		for (RoleInfo role : roles) {
			user.getRoles().add(new Role(role.getRoleId()));
		}

		saveUser(user);

		return UserPrincipal.create(user);
	}

	@Cacheable(value="userCache", key="#id")
	public UserDetails getUserById(String id) {
		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

		return UserPrincipal.create(user);
	}

	@Transactional
	public void saveUser(User user) {
     if(!userRepo.findById(user.getId()).isPresent())
		userRepo.save(user);
	}

}
