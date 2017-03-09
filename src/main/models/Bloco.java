package main.models;

public class Bloco {
	
	private Integer id;
	private String nome;
	private String numero;
	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumero() {
		return this.numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String toString(){
		return "ID: "+this.id+" | Nome: "+this.nome+" | Numero: "+this.numero;
	}

}
