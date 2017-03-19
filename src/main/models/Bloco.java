package main.models;

import main.Main;

public class Bloco {
	
	private Integer id;
	private String nome;
	private String numero;
	private String endereco;
	
	public Bloco(){
		//Função usada para criar blocos de teste
	}
	
	public Bloco(Integer id){
		
		Main.scan.nextLine();
		this.setId(id);
		System.out.print("Nome: ");
		this.setNome(Main.scan.nextLine());
		System.out.print("Numero: ");
		this.setNumero(Main.scan.nextLine());
		System.out.print("Endereco: ");
		this.setNumero(Main.scan.nextLine());
		
	}
	
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
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String toString(){
		return "ID: "+this.id+" | Nome: "+this.nome+" | Numero: "+this.numero;
	}

}
