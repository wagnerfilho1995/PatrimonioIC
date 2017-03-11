package main.controllers;

public interface Controller {
	
	void dadosIniciais();
	
	public void adicionar();
	
	public void remover(Integer id);
	
	public void listar();
	
	public Object buscar(Integer id);

}
