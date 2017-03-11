package main.controllers;

import java.util.HashMap;
import java.util.Scanner;

import main.Main;
import main.models.Movimentacao;

public class MovimentacaoController {

	Scanner scan = new Scanner(System.in);
	HashMap<Integer, Movimentacao> movimentacoes = new HashMap<Integer, Movimentacao>();	
	int proximoId = 0;
	
	public void adicionar(Integer idPatrimonio, Integer idSala) {
		Movimentacao newMovimentacao = new Movimentacao();
		newMovimentacao.setId(proximoId);
		proximoId++;
		newMovimentacao.setIdPatrimonio(idPatrimonio);
		newMovimentacao.setIdSala(idSala);
		movimentacoes.put(newMovimentacao.getId(), newMovimentacao);
	}

	public void remover(Integer id) {
		movimentacoes.remove(id);
	}

	public void listar() {
		for(int i = 0; i < movimentacoes.size(); i++){
			System.out.println(movimentacoes.get(i).toString());
		}
	}
	
	public void listarPorPatrimonio() {
		
	}

	public Object buscar(Integer id) {
		return movimentacoes.get(id);
	}

}
