package main.controllers;

import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.models.Bloco;

public class BlocoController implements Controller {
	
	Scanner scan = new Scanner(System.in);
	ObservableList<Bloco> blocos = FXCollections.observableArrayList();
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
		blocos.add(newBloco);
	}

	@Override
	public void remover(Integer id) {
		blocos.remove(id);
	}

	@Override
	public void listar() {
		for(int i = 0; i < blocos.size(); i++){
			System.out.println(blocos.get(i).toString());
		}
	}

	@Override
	public Object buscar(Integer id) {
		return blocos.get(id);
	}
	
	public ObservableList<Bloco> getList(){
		return blocos;
	}

}
