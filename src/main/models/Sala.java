package main.models;

import main.Main;

public class Sala extends InformacoesBasicas {
	
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
	
	public Integer getIdBloco() {
		return idBloco;
	}
	public void setIdBloco(Integer idBloco) {
		this.idBloco = idBloco;
	}

}
