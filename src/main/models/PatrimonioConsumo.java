package main.models;

import main.Main;

public class PatrimonioConsumo extends Patrimonio {
	
	public PatrimonioConsumo(Integer id) {
		super(id);
		System.out.print("ID do Responsável: ");
		//Listar Servidores; Por Enquanto o ID do Responsável Não Faz Diferença
		this.setIdResponsavel(Main.scan.nextInt());
	}

	private Integer idResponsavel;

	public Integer getIdResponsavel() {
		return idResponsavel;
	}

	public void setIdResponsavel(Integer idResponsavel) {
		this.idResponsavel = idResponsavel;
	}
	
}
