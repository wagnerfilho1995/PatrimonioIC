package main.controllers;

import java.util.HashMap;
import java.util.Scanner;

import main.models.Bloco;

public class BlocoController implements Controller<Bloco> {
	
	Scanner scan = new Scanner(System.in);
	HashMap<Integer, Bloco> blocos = new HashMap<Integer, Bloco>();
	int proximoId = 0;
	
	@Override
	public void adicionar() {
		Bloco newBloco = new Bloco();
		newBloco.setId(proximoId);
		proximoId++;
		System.out.print("Nome: ");
		newBloco.setNome(scan.nextLine());
		System.out.print("Numero: ");
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
	public Bloco buscar(Integer id) {
		return blocos.get(id);
	}

	public void dadosIniciais(){
		
		Bloco newBloco1 = new Bloco();
		newBloco1.setId(proximoId);
		proximoId++;
		newBloco1.setNome("Antigo IM");
		newBloco1.setNumero("14");
		blocos.put(newBloco1.getId(), newBloco1);
	
		Bloco newBloco2 = new Bloco();
		newBloco2.setId(proximoId);
		proximoId++;
		newBloco2.setNome("IC");
		newBloco2.setNumero("17");
		blocos.put(newBloco2.getId(), newBloco2);
	
		Bloco newBloco3 = new Bloco();
		newBloco3.setId(proximoId);
		proximoId++;
		newBloco3.setNome("CPTEC");
		newBloco3.setNumero("18");
		blocos.put(newBloco3.getId(), newBloco3);
	
	}
	
}
