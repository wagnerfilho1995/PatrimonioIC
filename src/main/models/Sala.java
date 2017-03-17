package main.models;

import main.Main;

public class Sala {
	
	private Integer id;
	private String nome;
	private String numero;
	private Integer idBloco;
	
	public Sala(){
		//Função usada para criar salas de teste
	}
	
	public Sala(Integer id){
		
		this.setId(id);
		
		Main.blocoController.listar(0);
		System.out.print("ID do Bloco: ");
		this.setIdBloco(Main.scan.nextInt());
		Main.scan.nextLine();
		
		System.out.print("Nome: ");
		this.setNome(Main.scan.nextLine());
		
		System.out.print("Numero: ");
		this.setNumero(Main.scan.nextLine());
	}
	
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
