package main.models;

import main.Main;

public class Bloco extends InformacoesBasicas {
	
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
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
