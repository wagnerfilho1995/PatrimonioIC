package main.controllers;

public interface Controller <T> {
	
	public void adicionar();
	
	public void editar(Integer id);
	
	public void remover(Integer id);
	
	public void listar();
	
	public T buscar(Integer id);

}
