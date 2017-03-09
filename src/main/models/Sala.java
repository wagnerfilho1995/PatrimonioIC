package main.models;

public class Sala {
	
	private Integer id;
	private String nome;
	private String numero;
	private Integer idBloco;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Integer getIdBloco() {
		return idBloco;
	}
	public void setIdBloco(Integer idBloco) {
		this.idBloco = idBloco;
	}
	
	public String toString(){
		return "ID: "+this.id+" | Nome: "+this.nome+" | Numero: "+this.numero;
	}

}
