package main.controllers;

public interface Controller {
	
	public void adicionar();
	
	public void remover(Integer id);
	
	public void listar();
	
	public Object buscar(Integer id);

}
