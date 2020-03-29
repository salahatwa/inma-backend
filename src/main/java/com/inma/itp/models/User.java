package com.inma.itp.models;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class User {

	private String id;

	private String name;
	
	private String lang;

	private String username;

	private String email;

	private String password;

	private Set<Role> roles = new HashSet<>();

	public User() {

	}

}