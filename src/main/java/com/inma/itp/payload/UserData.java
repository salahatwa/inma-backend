package com.inma.itp.payload;

import com.inma.itp.secuirty.UserPrincipal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserData {
	private String id;
	private String email;
	private String username;
	private String bio;
	private String image;
	private String accessToken;
	private UserPrincipal profile;

	public UserData(String accessToken) {
		this.accessToken = accessToken;
	}

	public UserData(String accessToken, UserPrincipal userPrincipal) {
		this.accessToken = accessToken;
		this.profile = userPrincipal;
	}

}
