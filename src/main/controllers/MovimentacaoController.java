package main.controllers;

import java.util.HashMap;

import main.models.Movimentacao;

public class MovimentacaoController implements Controller<Movimentacao> {

	HashMap<Integer, Movimentacao> movimentacoes = new HashMap<Integer, Movimentacao>();	
	int proximoId = 0;
	
	@Override
	public void adicionar(){
		
		Movimentacao newMovimentacao = new Movimentacao(proximoId);
		
		proximoId++;
		
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
	public void editar(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void remover(Integer id) {
		movimentacoes.remove(id);
	}
	@Override
	public void listar(int forma) {
		for(int i = 0; i < movimentacoes.size(); i++){
			System.out.println(movimentacoes.get(i).toString());
		}
	}
	
	public void listarPorPatrimonio() {
		
	}
	
	@Override
	public Movimentacao buscar(Integer id){
		return movimentacoes.get(id);
	}

}
