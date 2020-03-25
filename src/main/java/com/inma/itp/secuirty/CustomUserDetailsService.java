package com.inma.itp.secuirty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inma.itp.service.AuthService;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private AuthService authService;

	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		// Let people login with either username or email
//        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
//                .orElseThrow(() ->
//                        new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
//        );
//
//        return UserPrincipal.create(user);
		return null;
	}

	public UserDetails loadUserById(String id) {
//		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

//		return UserPrincipal.create(user);

		return null;
	}
}