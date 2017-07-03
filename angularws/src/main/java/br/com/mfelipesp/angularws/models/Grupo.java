package br.com.mfelipesp.angularws.models;

public class Grupo {
	
	private int id;
	private String nome;
	
	public Grupo(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}  
	
	public Grupo() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Grupo [id=" + id + ", nome=" + nome + "]";
	}

}
