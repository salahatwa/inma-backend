package com.inma.itp.apis;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inma.itp.exception.InvalidUsernamePasswordException;
import com.inma.itp.payload.LoginRequest;
import com.inma.itp.payload.UserData;
import com.inma.itp.secuirty.JwtTokenProvider;
import com.inma.itp.secuirty.UserPrincipal;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	JwtTokenProvider tokenProvider;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		String jwt = null;
		UserPrincipal userPrincipal = null;
		try {
			Authentication authentication = authenticationManager.authenticate(
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
