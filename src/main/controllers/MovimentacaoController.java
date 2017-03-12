package main.controllers;

import java.util.HashMap;
import java.util.Scanner;

import main.Main;
import main.models.Movimentacao;

public class MovimentacaoController implements Controller {

	Scanner scan = new Scanner(System.in);
	HashMap<Integer, Movimentacao> movimentacoes = new HashMap<Integer, Movimentacao>();	
	int proximoId = 0;
	
	@Override
	public void adicionar(){
		Main.blocoController.listar();
		System.out.println("Bloco atual do patrimonio: ");
		
		Main.salaController.listarPorBloco(scan.nextInt());
		System.out.println("Sala atual do patrimonio: ");
		
		Main.patrimonioController.listarPorSala(scan.nextInt());
		System.out.println("Patrimonio: ");
		
		Movimentacao newMovimentacao = new Movimentacao();
		newMovimentacao.setId(proximoId);
		proximoId++;
		
		newMovimentacao.setIdPatrimonio(scan.nextInt());
		
		Main.blocoController.listar();
		System.out.println("Novo bloco do patrimonio: ");
		
		Main.salaController.listarPorBloco(scan.nextInt());
		System.out.println("Nova sala do patrimonio: ");
		newMovimentacao.setIdSala(scan.nextInt());
		
		newMovimentacao.setData();
		movimentacoes.put(newMovimentacao.getId(), newMovimentacao);
	}
	
	public int adicionar(Integer idPatrimonio, Integer idSala) {
		Movimentacao newMovimentacao = new Movimentacao();
		newMovimentacao.setId(proximoId);
		proximoId++;
		newMovimentacao.setIdPatrimonio(idPatrimonio);
		newMovimentacao.setIdSala(idSala);
		newMovimentacao.setData();
		movimentacoes.put(newMovimentacao.getId(), newMovimentacao);
		return newMovimentacao.getId();
	}
	@Override
	public void remover(Integer id) {
		movimentacoes.remove(id);
	}
	@Override
	public void listar() {
		for(int i = 0; i < movimentacoes.size(); i++){
			System.out.println(movimentacoes.get(i).toString());
		}
	}
	
	public void listarPorPatrimonio() {
		
	}
	public Movimentacao buscar(Integer id){
		return buscar(Movimentacao.class, id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Object>T buscar(Class<T> type, Integer id) {
		return (T) movimentacoes.get(id);
	}

}
