package main.controllers;

import java.util.HashMap;

import main.Main;
import main.models.Bloco;

public class BlocoController implements Controller<Bloco> {
	
	HashMap<Integer, Bloco> blocos = new HashMap<Integer, Bloco>();
	int proximoId = 0;
	
	@Override
	public void adicionar() {
		Bloco newBloco = new Bloco(proximoId);
		
		proximoId++;
		
		blocos.put(newBloco.getId(), newBloco);
	}
	
	@Override
	public void editar(Integer id) {
		System.out.println("O que voce deseja editar:");
		System.out.println("1 - Nome");
		System.out.println("2 - Numero");
		int answer = Main.scan.nextInt();
		Main.scan.nextLine();
		if(answer == 1){
			System.out.println("Nome Atual: "+buscar(id).getNome());
			System.out.print("Novo Nome: ");
			buscar(id).setNome(Main.scan.nextLine());
		}
		else{
			System.out.println("Numero Atual: "+buscar(id).getNumero());
			System.out.print("Novo Numero: ");
			buscar(id).setNumero(Main.scan.nextLine());
		}
		
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
