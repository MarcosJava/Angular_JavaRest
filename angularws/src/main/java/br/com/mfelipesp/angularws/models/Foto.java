package br.com.mfelipesp.angularws.models;

public class Foto {
	private String titulo;
	private String url;
	
	public Foto() {
		// TODO Auto-generated constructor stub
	}
	
	public Foto(String titulo, String url) {
		super();
		this.titulo = titulo;
		this.url = url;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	

}
