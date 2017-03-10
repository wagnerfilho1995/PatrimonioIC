package main.controllers;

import java.util.HashMap;
import java.util.Scanner;

import main.models.Bloco;

public class BlocoController implements Controller {
	
	Scanner scan = new Scanner(System.in);
	HashMap<Integer, Bloco> blocos = new HashMap<Integer, Bloco>();
	int proximoId = 0;

	@Override
	public void adicionar() {
		Bloco newBloco = new Bloco();
		newBloco.setId(proximoId);
		proximoId++;
		System.out.println("Nome: ");
		newBloco.setNome(scan.nextLine());
		System.out.println("Numero: ");
		newBloco.setNumero(scan.nextLine());
		blocos.put(newBloco.getId(), newBloco);
	}

	@Override
	public void remover(Integer id) {
		blocos.remove(id);
	}

	@Override
	public void listar() {
		for(int i : blocos.keySet()){
			System.out.println(blocos.get(i).toString());
		}
	}

	@Override
	public Object buscar(Integer id) {
		return blocos.get(id);
	}

}
