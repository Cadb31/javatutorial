package com.springboot.backend;

import java.security.Timestamp;

public class ResponseDTO {

	private long time;
	private String ip;
	private String message;

	public ResponseDTO() {
		super();
	}

	public ResponseDTO(long time, String ip, String message) {
		super();
		this.time = time;
		this.ip = ip;
		this.message = message;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
