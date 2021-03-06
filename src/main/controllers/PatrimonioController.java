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

		System.out.println("Novo Patrim�nio adicionado com sucesso!");
	
	}
	
	@Override
	public void editar(Integer id) {
		System.out.println("O que voce deseja editar:");
		System.out.println("1 - Nome");
		System.out.println("2 - Numero");
		System.out.println("3 - Status");
		System.out.println("4 - Frequencia de Manuten��o");
		int answer = Main.scan.nextInt();
		Main.scan.nextLine();
		if(answer == 1){
			System.out.println("Nome Atual: "+buscar(id).getNome());
			System.out.print("Novo Nome: ");
			buscar(id).setNome(Main.scan.nextLine());
		}
		else if(answer == 2){
			System.out.println("Numero Atual: "+buscar(id).getNumero());
			System.out.print("Novo Numero: ");
			buscar(id).setNumero(Main.scan.nextLine());
		}
		else if(answer == 3){
			System.out.println("Status Atual: "+buscar(id).getStatus());
			System.out.print("Novo Status: ");
			buscar(id).setStatus(Main.scan.nextInt());
			Main.scan.nextLine();
		}
		else if(answer == 4){
			System.out.println("Frequencia De Manutencao Atual: "+buscar(id).getFrequenciaDeManutencao());
			System.out.print("Nova Frequencia De Manutencao: ");
			buscar(id).setFrequenciaDeManutencao(Main.scan.nextInt());
			Main.scan.nextLine();
		}
	}

	@Override
	public void remover(Integer id) {
		patrimonios.remove(id);
		System.out.println("Patrimonio removido com sucesso!");
	}

	@Override
	public void listar(int forma) {
		for(int i : Main.salaController.salas.keySet()){
			if(forma == 1){
				System.out.println(Main.salaController.buscar(i).toString());
				System.out.print("  ");
				System.out.println("Patrimonios: ");
			}
			listarPorSala(i, forma);
		}
	}
 	
	public void listarPorSala(Integer idSala, int forma){
		int j = 0;
		for(int i : patrimonios.keySet()){
			if(Main.movimentacaoController.buscar(patrimonios.get(i).getIdMovimentacao()).getIdSala() == idSala){
				System.out.println("  " + patrimonios.get(i).toString());
				j = 1;
			}
		}
		if(j == 0 && forma == 1) System.out.println("  Nenhum\n");
	}

	@Override
	public Patrimonio buscar(Integer id) {
		return patrimonios.get(id);
	}
	
	
	public void atualizarStatus(Integer id){
		
		Patrimonio patrimonio = buscar(id);
		if(patrimonio.getStatus() == 1){
			buscar(id).setStatus(2);
		}
		else if(patrimonio.getStatus() == 2){
			buscar(id).setStatus(3);
		}
		else if(patrimonio.getStatus() == 3){
			buscar(id).setStatus(1);
		}
	}
	
	public void listarDanificados(){
		int contador = 0;
		for(int i : patrimonios.keySet()){
			if(buscar(i).getManutencao() != null && buscar(i).checarManutencao() && buscar(i).getStatus() == 1){
				atualizarStatus(i);
				buscar(i).setManutecao();
			}
			if(buscar(i).getStatus() == 2){
				System.out.println(patrimonios.get(i).toString());
				contador = 1;
			}
			
		}
		if(contador == 0) System.out.println("Nenhum encontrado");
		
		System.out.println("");
				
				
	}
	public void dadosIniciais(){

		Patrimonio newPatrimonio = new Patrimonio();
		
		newPatrimonio.setId(proximoId);
		proximoId++;
		
		newPatrimonio.setIdMovimentacao(Main.movimentacaoController.adicionar(newPatrimonio.getId(), 2)); // LAB3
		
		newPatrimonio.setNome("PC1");
		
		newPatrimonio.setNumero("1111");
		
		newPatrimonio.setStatus(1);
		
		patrimonios.put(newPatrimonio.getId(), newPatrimonio);
		
		Patrimonio newPatrimonio2 = new Patrimonio();
		
		newPatrimonio2.setId(proximoId);
		proximoId++;
		
		newPatrimonio2.setIdMovimentacao(Main.movimentacaoController.adicionar(newPatrimonio.getId(), 2)); // LAB3
		
		newPatrimonio2.setNome("ArCondicionado1");
		
		newPatrimonio2.setNumero("18111");
		
		newPatrimonio2.setStatus(1);
		
		patrimonios.put(newPatrimonio2.getId(), newPatrimonio2);

	}

}
