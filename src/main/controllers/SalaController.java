package main.controllers;

import java.util.HashMap;
import java.util.Scanner;

import main.Main;
import main.models.Sala;

public class SalaController implements Controller {
	
	Scanner scan = new Scanner(System.in);
	HashMap<Integer, Sala> salas = new HashMap<Integer, Sala>();	
	int proximoId = 0;
	
	public void dadosIniciais(){
		
		Sala newSala1 = new Sala();
		//Main.blocoController.listar();
		newSala1.setIdBloco(1);
		newSala1.setId(proximoId);
		proximoId++;
		newSala1.setNome("Sala 01");
		newSala1.setNumero("1");
		salas.put(newSala1.getId(), newSala1);
	
		Sala newSala2 = new Sala();
		//Main.blocoController.listar();
		newSala2.setIdBloco(1);
		newSala2.setId(proximoId);
		proximoId++;
		newSala2.setNome("Sala 02");
		newSala2.setNumero("2");
		salas.put(newSala2.getId(), newSala2);
	
		Sala newSala3 = new Sala();
		//Main.blocoController.listar();
		newSala3.setIdBloco(1);
		newSala3.setId(proximoId);
		proximoId++;
		newSala3.setNome("LAB 03");
		newSala3.setNumero("103");
		salas.put(newSala3.getId(), newSala3);
		
	}
	
	
	@Override
	public void adicionar() {
		Sala newSala = new Sala();
		Main.blocoController.listar();
		System.out.print("ID do Bloco: ");
		newSala.setIdBloco(scan.nextInt());
		
		newSala.setId(proximoId);
		proximoId++;
		
		System.out.println("Nome: ");
		scan.nextLine();
		newSala.setNome(scan.nextLine());
		
		System.out.println("Numero: ");
		newSala.setNumero(scan.nextLine());
		
		salas.put(newSala.getId(), newSala);
	}

	@Override
	public void remover(Integer id) {
		salas.remove(id);
	}

	@Override
	public void listar() {
		for(int i = 0; i < salas.size(); i++){
			System.out.println(salas.get(i).toString());
		}
	}
	
	public void listarPorBloco(Integer idBloco){
		System.out.println("Salas: ");
		for(int i = 0; i < salas.size(); i++){
			if(salas.get(i).getIdBloco() == idBloco) System.out.println("  "+salas.get(i).toString());
		}
		System.out.println("");
	}
	
	public Sala buscar(Integer id){
		return buscar(Sala.class, id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Object>T buscar(Class<T> type, Integer id) {
		return (T) salas.get(id);
	}

}
