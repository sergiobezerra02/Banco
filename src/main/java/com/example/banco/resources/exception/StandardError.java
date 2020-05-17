package com.example.banco.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int cod;
	private String msg;
	private Long timestamp;
	
	public StandardError(int cod, String msg, Long timestamp) {
		super();
		this.cod = cod;
		this.msg = msg;
		this.timestamp = timestamp;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

}
