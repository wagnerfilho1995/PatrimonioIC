package main.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Scanner;

import main.Main;
import main.models.Patrimonio;

public class PatrimonioController implements Controller {
	
	Scanner scan = new Scanner(System.in);
	HashMap<Integer, Patrimonio> patrimonios = new HashMap<Integer, Patrimonio>();	
	int proximoId = 0;
	
	public void dadosIniciais(){

		Patrimonio newPatrimonio = new Patrimonio();
		
		newPatrimonio.setId(proximoId);
		proximoId++;
		
		//Main.salaController.listarPorBloco(1); // IC
		
		newPatrimonio.setIdMovimentacao(Main.movimentacaoController.adicionar(newPatrimonio.getId(), 3)); // LAB3
		
		newPatrimonio.setNome("PC1");
		
		newPatrimonio.setNumero("1111");
		
		newPatrimonio.setStatus(1);
		
		patrimonios.put(newPatrimonio.getId(), newPatrimonio);

	}
	
	@Override
	public void adicionar() {
		
		Patrimonio newPatrimonio = new Patrimonio();
		
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
			System.out.println("Data da proxima manutenção(dd/MM/aaaa): ");
			String m = scan.nextLine();
			SimpleDateFormat sm = new SimpleDateFormat("dd-mm-yyyy");
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
		for(int i : patrimonios.keySet()){
			if(Main.movimentacaoController.buscar(patrimonios.get(i).getIdMovimentacao()) == idSala){
				System.out.println(patrimonios.get(i).toString());
			}
		}
	}

	@Override
	public Object buscar(Integer id) {
		return patrimonios.get(id);
	}

}
