package com.xyh.game.req;

import com.xyh.game.valid.MyValidTest;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class TestReq implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 3377447825007230381L;
	private Long id;
	@NotNull(message = "{valid.test.name.null}")
	@MyValidTest(length = 3,message = "{valid.test.name.my.length}")
	@Length(max=1,message = "{valid.test.name.length}")
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
