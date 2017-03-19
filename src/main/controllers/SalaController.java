package main.controllers;

import java.util.HashMap;
import java.util.Scanner;

import main.Main;
import main.models.Sala;

public class SalaController implements Controller<Sala> {

	public static Scanner scan = new Scanner(System.in);
	
	HashMap<Integer, Sala> salas = new HashMap<Integer, Sala>();	
	int proximoId = 0;	
	
	@Override
	public void adicionar() {
		Sala newSala = new Sala(proximoId);
		
		proximoId++;
		
		salas.put(newSala.getId(), newSala);
	
		System.out.println("Nova Sala adicionada com sucesso!");
		
	}
	
	@Override
	public void editar(Integer id) {
		System.out.println("O que voce deseja editar:");
		System.out.println("1 - Nome");
		System.out.println("2 - Numero");
		System.out.println("3 - Bloco");
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
			System.out.println("Bloco Atual: "+Main.blocoController.buscar(buscar(id).getIdBloco()).toString()+"\n");
			System.out.println("Definir Novo Bloco: ");
			Main.blocoController.listar(0);
			System.out.println();
			buscar(id).setIdBloco(Main.checarID(3));
			Main.scan.nextLine();
			
		}
	}

	@Override
	public void remover(Integer id) {
		salas.remove(id);
		System.out.println("Sala removida com sucesso!");
	}

	@Override
	public void listar(int forma) {
		
		int idBloco = -1;
		
		if(forma == 1){
	
			Main.blocoController.listar(0);
			System.out.print("ID do Bloco: ");
			idBloco = Main.checarID(3);
			System.out.println("Bloco: " + Main.blocoController.buscar(idBloco).getNome());
		}
		
		for(int i : salas.keySet()){
			if(buscar(i).getIdBloco() == idBloco || idBloco == -1){
				System.out.print("  ");
				System.out.println(salas.get(i).toString());
			}
		}
		System.out.println();
		
	}
	
	@Override
	public Sala buscar(Integer id){
		return salas.get(id);
	}
	
	public void dadosIniciais(){
		
		Sala deposito = new Sala();
		deposito.setIdBloco(1);
		deposito.setId(proximoId);
		proximoId++;
		deposito.setNome("Depósito");
		deposito.setNumero("000");
		salas.put(deposito.getId(), deposito);
		
		Sala newSala1 = new Sala();
		newSala1.setIdBloco(1);
		newSala1.setId(proximoId);
		proximoId++;
		newSala1.setNome("Sala 01");
		newSala1.setNumero("1");
		salas.put(newSala1.getId(), newSala1);
	
		Sala newSala2 = new Sala();
		newSala2.setIdBloco(1);
		newSala2.setId(proximoId);
		proximoId++;
		newSala2.setNome("Sala 02");
		newSala2.setNumero("2");
		salas.put(newSala2.getId(), newSala2);
	
		Sala newSala3 = new Sala();
		newSala3.setIdBloco(1);
		newSala3.setId(proximoId);
		proximoId++;
		newSala3.setNome("LAB 03");
		newSala3.setNumero("103");
		salas.put(newSala3.getId(), newSala3);
		
	}

}
