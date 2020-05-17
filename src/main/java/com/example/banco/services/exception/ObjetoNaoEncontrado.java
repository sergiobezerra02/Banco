package com.example.banco.services.exception;

public class ObjetoNaoEncontrado extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ObjetoNaoEncontrado(String msg) {
		super(msg);
	}
	
	public ObjetoNaoEncontrado(String msg, Throwable value) {
		super(msg, value);
	}

}
