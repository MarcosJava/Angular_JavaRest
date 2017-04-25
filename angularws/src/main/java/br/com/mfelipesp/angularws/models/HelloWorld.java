package br.com.mfelipesp.argularws.models;

public class HelloWorld {
	private long id;
	private String texto;
	
	public HelloWorld(long id, String texto) {
		this.id = id;
		this.texto = texto;
	}

	public long getId() {
		return id;
	}

	public String getTexto() {
		return texto;
	}
	
	
}
