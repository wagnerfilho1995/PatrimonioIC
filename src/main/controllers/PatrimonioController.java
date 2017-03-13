package main.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Scanner;

import main.Main;
import main.models.Patrimonio;
import main.models.PatrimonioConsumo;
import main.models.PatrimonioPermanente;

public class PatrimonioController implements Controller<Patrimonio> {
	
	Scanner scan = new Scanner(System.in);
	HashMap<Integer, Patrimonio> patrimonios = new HashMap<Integer, Patrimonio>();	
	int proximoId = 0;
	
	@Override
	public void adicionar() {
		
		System.out.println("Tipo de Patrimonio: ");
		System.out.println("1 - Patrimonio Permanente");
		System.out.println("2 - Patrimonio de Consumo");
		int tipo = scan.nextInt();
		
		Patrimonio newPatrimonio;
		
		if(tipo == 1){		
			newPatrimonio = new PatrimonioPermanente();
		}
		else{
			newPatrimonio = new PatrimonioConsumo();
			System.out.print("ID do Responsável: ");
			//Listar Servidores; Por Enquanto o ID do Responsável Não Faz Diferença
			((PatrimonioConsumo) newPatrimonio).setIdResponsavel(scan.nextInt());
		}
		newPatrimonio.setId(proximoId);
		Main.movimentacaoController.proximoId++;
		proximoId++;
		Main.blocoController.listar();
		
		System.out.println("ID Bloco para alocação:");
		Main.salaController.listarPorBloco(scan.nextInt());
		
		System.out.println("ID Sala para alocação:");
		newPatrimonio.setIdMovimentacao(Main.movimentacaoController.adicionar(newPatrimonio.getId(), scan.nextInt()));
		
		System.out.println("Nome: ");
		scan.nextLine();
		newPatrimonio.setNome(scan.nextLine());
		
		System.out.println("Numero: ");
		newPatrimonio.setNumero(scan.nextLine());
		
		newPatrimonio.setStatus(1);
		
		System.out.println("Tipo de Manutencao: ");
		System.out.println("1 - Periodica");
		System.out.println("2 - Pontual");
		int answer = scan.nextInt();
		
		if(answer == 1){
			System.out.println("Frequencia(Em dias): ");
			newPatrimonio.setFrequenciaDeManutencao(scan.nextInt());
			scan.nextLine();
			System.out.println("Data da proxima manutenção(dd/MM/aaaa): ");
			String m = scan.nextLine();
			SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy");
			try {
				newPatrimonio.setManutencao(sm.parse(m));
			} catch (ParseException e) {
				System.out.println("Formato de data errado");
				e.printStackTrace();
			}
		}
		
		
		patrimonios.put(newPatrimonio.getId(), newPatrimonio);
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

		Patrimonio newPatrimonio = new PatrimonioPermanente();
		
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
