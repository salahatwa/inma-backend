package com.inma.itp.apis;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inma.itp.exception.InvalidUsernamePasswordException;
import com.inma.itp.payload.LoginRequest;
import com.inma.itp.payload.UserData;
import com.inma.itp.secuirty.CustomAuthenticationProvider;
import com.inma.itp.secuirty.JwtTokenProvider;
import com.inma.itp.secuirty.UserPrincipal;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private CustomAuthenticationProvider customAuthManager;

	@Autowired
	private JwtTokenProvider tokenProvider;
	
	

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		String jwt = null;
		UserPrincipal userPrincipal = null;
		try {
			Authentication authentication = customAuthManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

			SecurityContextHolder.getContext().setAuthentication(authentication);

			userPrincipal = (UserPrincipal) authentication.getPrincipal();
			jwt = tokenProvider.generateToken(authentication);

		} catch (Exception ex) {
			throw new InvalidUsernamePasswordException("user " + ex.getMessage(), "Email or Password",
					loginRequest.getUsername());
		}
		return ResponseEntity.ok(new UserData(jwt, userPrincipal));
	}

}
