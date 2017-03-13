package main.controllers;

import java.util.HashMap;

import main.Main;
import main.models.Patrimonio;
import main.models.PatrimonioConsumo;
import main.models.PatrimonioPermanente;

public class PatrimonioController implements Controller<Patrimonio> {
	
	HashMap<Integer, Patrimonio> patrimonios = new HashMap<Integer, Patrimonio>();	
	int proximoId = 0;
	
	@Override
	public void adicionar() {
		
		System.out.println("Tipo de Patrimonio: ");
		System.out.println("1 - Patrimonio Permanente");
		System.out.println("2 - Patrimonio de Consumo");
		int tipo = Main.scan.nextInt();
		
		Patrimonio newPatrimonio;
		
		if(tipo == 1){		
			newPatrimonio = new PatrimonioPermanente(proximoId);
		}
		else{
			newPatrimonio = new PatrimonioConsumo(proximoId);	
		}
		
		proximoId++;
		
		patrimonios.put(newPatrimonio.getId(), newPatrimonio);
	}
	
	@Override
	public void editar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Integer id) {
		patrimonios.remove(id);
	}

	@Override
	public void listar() {
		for(int i = 0; i < patrimonios.size(); i++){
			System.out.println(patrimonios.get(i).toString());
		}
	}
 	
	public void listarPorSala(Integer idSala){
		System.out.println("Patrimonios: ");
		for(int i : patrimonios.keySet()){
			if(Main.movimentacaoController.buscar(patrimonios.get(i).getIdMovimentacao()).getIdSala() == idSala){
				System.out.println("  "+patrimonios.get(i).toString());
			}
		}
		System.out.println("");
	}
	
	public void listarTodosPorSala(){
		for(int i : Main.salaController.salas.keySet()){
			System.out.println("Sala: "+Main.salaController.buscar(i).toString());
			System.out.print("  ");
			listarPorSala(i);
		}
	}

	@Override
	public Patrimonio buscar(Integer id) {
		return patrimonios.get(id);
	}
	
	public void dadosIniciais(){

		Patrimonio newPatrimonio = new Patrimonio();
		
		newPatrimonio.setId(proximoId);
		proximoId++;
		
		//Main.salaController.listarPorBloco(1); // IC
		
		newPatrimonio.setIdMovimentacao(Main.movimentacaoController.adicionar(newPatrimonio.getId(), 2)); // LAB3
		
		newPatrimonio.setNome("PC1");
		
		newPatrimonio.setNumero("1111");
		
		newPatrimonio.setStatus(1);
		
		patrimonios.put(newPatrimonio.getId(), newPatrimonio);

	}

}
