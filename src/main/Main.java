package main;

import java.util.Scanner;

import main.controllers.BlocoController;
import main.controllers.SalaController;

public class Main {

	static Scanner scan = new Scanner(System.in);
	static SalaController salaController = new SalaController();
	static BlocoController blocoController = new BlocoController();
	
	public static void main(String[] args) {
		int menuOption = 0;
		while(menuOption != 4){
			menuOption = mainMenu();			
		}

	}
	
	public static int mainMenu(){
		System.out.println("Main Menu:");
		System.out.println("1 - Patrimonio");
		System.out.println("2 - Sala");
		System.out.println("3 - Bloco");
		System.out.println("4 - Sair");
		int menuOption = scan.nextInt();
		if(menuOption == 1){
			
		}
		else if(menuOption == 2){
			menuSala();
		}
		else if(menuOption == 3){
			menuBloco();
		}
		return menuOption;
	}
	
	public static void menuSala(){
		System.out.println("Menu Salas");
		System.out.println("1 - Adicionar");
		System.out.println("2 - Remover");
		System.out.println("3 - Buscar");
		System.out.println("4 - Listar por Bloco");
		
		int answer = scan.nextInt();
		if(answer == 1){
			salaController.adicionar();
		}
		else if(answer == 2){
			salaController.listar();
			System.out.print("ID da Sala: ");
			salaController.remover(scan.nextInt());
		}
		else if(answer == 3){
			salaController.listar();
			System.out.print("ID da Sala: ");
			salaController.buscar(scan.nextInt());
		}
		else{
			blocoController.listar();
			System.out.print("ID do Bloco: ");
			salaController.buscar(scan.nextInt());
		}
	}
	
	public static void menuBloco(){
		System.out.println("Menu Blocos");
		System.out.println("1 - Adicionar");
		System.out.println("2 - Remover");
		System.out.println("3 - Buscar");
		
		int answer = scan.nextInt();
		if(answer == 1){
			blocoController.adicionar();
		}
		else if(answer == 2){
			blocoController.listar();
			System.out.print("ID do Bloco: ");
			blocoController.remover(scan.nextInt());
		}
		else{
			blocoController.listar();
			System.out.print("ID do Bloco: ");
			blocoController.buscar(scan.nextInt());
		}
	}

}
