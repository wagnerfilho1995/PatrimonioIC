package main.controllers;

public interface Controller {
	
	public void adicionar();
	
	public void remover(Integer id);
	
	public void listar();
	
	public <T extends Object>T buscar(Class<T> type, Integer id);

}
