package com.inma.itp.models;

import lombok.Data;

@Data
public class Role {

	private Long id;

	private String name;

	public Role() {

	}

	public Role(String name) {
		this.name = name;
	}

}
