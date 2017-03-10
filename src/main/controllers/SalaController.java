package main.controllers;

import java.util.HashMap;
import java.util.Scanner;

import main.models.Sala;

public class SalaController implements Controller {
	
	Scanner scan = new Scanner(System.in);
	HashMap<Integer, Sala> salas = new HashMap<Integer, Sala>();	
	int proximoId = 0;
	
	@Override
	public void adicionar() {
		Sala newSala = new Sala();
		newSala.setId(proximoId);
		proximoId++;
		System.out.println("Nome: ");
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
		for(int i = 0; i < salas.size(); i++){
			if(salas.get(i).getIdBloco() == idBloco) System.out.println(salas.get(i).toString());
		}
	}

	@Override
	public Object buscar(Integer id) {
		return salas.get(id);
	}

}
