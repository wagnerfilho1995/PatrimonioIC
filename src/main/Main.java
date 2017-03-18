package main;

import java.util.Scanner;

import main.controllers.BlocoController;
import main.controllers.MovimentacaoController;
import main.controllers.PatrimonioController;
import main.controllers.SalaController;

public class Main {

	public static Scanner scan = new Scanner(System.in);
	public static PatrimonioController patrimonioController = new PatrimonioController();
	public static SalaController salaController = new SalaController();
	public static BlocoController blocoController = new BlocoController();
	public static MovimentacaoController movimentacaoController = new MovimentacaoController();
	
	static int busca;
	
	public static void main(String[] args) {
		
		int menuOption = 0;
		
		blocoController.dadosIniciais();
		salaController.dadosIniciais();
		patrimonioController.dadosIniciais();
				
		while(menuOption != 4){
			menuOption = mainMenu();
		}
		System.out.println("Que a força esteja com você!");
	}
	
	public static int mainMenu(){
		System.out.println("\nMain Menu:");
		System.out.println("1 - Patrimonio");
		System.out.println("2 - Sala");
		System.out.println("3 - Bloco");
		System.out.println("4 - Sair");
		int menuOption = scan.nextInt();
		if(menuOption == 1){
			menuPatrimonio();
		}
		else if(menuOption == 2){
			menuSala();
		}
		else if(menuOption == 3){
			menuBloco();
		}
		return menuOption;
	}
	
	public static void menuPatrimonio(){
		
		System.out.println("Menu Patrimonio");
		System.out.println("1 - Adicionar");
		System.out.println("2 - Remover");
		System.out.println("3 - Editar");
		//colocar função de edição
		System.out.println("4 - Buscar");
		System.out.println("5 - Listar");
		
		System.out.println("\n0 - Voltar para o Menu Principal");
	
		int answer = scan.nextInt();
		
		if(answer == 1){
			patrimonioController.adicionar();
		}
		else if(answer == 2){
			patrimonioController.listar(2);
			patrimonioController.remover(checarID(1));
		}
		else if(answer == 4){
			patrimonioController.listar(2);
			busca = checarID(1);
			scan.nextLine();
			String salaAtual = salaController.buscar(movimentacaoController.buscar(patrimonioController.buscar(busca).getIdMovimentacao()).getIdSala()).toString();					
			System.out.println("Sala Atual do Patrimonio Buscado: "+salaAtual);
		}	
		else if(answer == 5){
			System.out.println("Forma de Listagem:");
			System.out.println("1 - Salas");
			System.out.println("2 - Todos");
			busca = scan.nextInt();
			patrimonioController.listar(busca);
		}
		else if(answer == 0) return;
	}
	
	public static void menuSala(){
		
		System.out.println("Menu Salas");
		System.out.println("1 - Adicionar");
		System.out.println("2 - Remover");
		System.out.println("3 - Editar");
		System.out.println("4 - Buscar");
		System.out.println("5 - Listar");
		System.out.println("\n0 - Voltar para o Menu Principal");
		
		int answer = scan.nextInt();
		if(answer == 1){
			salaController.adicionar();
		}
		else if(answer == 2){
			salaController.listar(2);
			salaController.remover(checarID(2));
		}
		else if(answer == 3){
			salaController.listar(2);
			System.out.print("ID da Sala: ");
			salaController.editar(checarID(2));
		}
		else if(answer == 4){
			salaController.listar(2);
			String blocoAtual = blocoController.buscar(salaController.buscar(checarID(2)).getIdBloco()).toString();
			System.out.println("Bloco Atual da Sala Buscada: "+blocoAtual);
		}
		else if(answer == 5){
			System.out.println("Forma de Listagem:");
			System.out.println("1 - Blocos");
			System.out.println("2 - Todos");
			busca = scan.nextInt();
			salaController.listar(busca);
		}
		else if(answer == 0) return;
	}
	
	public static void menuBloco(){
		
		System.out.println("Menu Blocos");
		System.out.println("1 - Adicionar");
		System.out.println("2 - Remover");
		System.out.println("3 - Editar");
		System.out.println("4 - Buscar");
		System.out.println("\n0 - Voltar para o Menu Principal");
		int answer = scan.nextInt();
		if(answer == 1){
			blocoController.adicionar();
		}
		else if(answer == 2){
			blocoController.listar(0);
			System.out.print("ID do Bloco: ");
			blocoController.remover(checarID(3));
		}
		else if(answer == 3){
			blocoController.listar(0);
			System.out.print("ID do Bloco: ");
			blocoController.editar(checarID(3));
		}
		else{
			blocoController.listar(0);
			blocoController.buscar(checarID(3));
		}
	}
	
	public static int checarID(int tipo){ // 1 - Patrimonio, 2 - Sala, 3 - Bloco
		
		int id = 0;
		
		if(tipo == 1){
			do{
				System.out.print("ID do Patrimonio: ");
				id = scan.nextInt();
				if(patrimonioController.buscar(id) == null){
					System.out.println("Inválido!");
					System.out.println("Por favor digite um ID válido.");
				}
			}while(patrimonioController.buscar(id) == null);	
		}
		else if(tipo == 2){	
			do{
				System.out.print("ID da Sala: ");
				id = scan.nextInt();
				if(salaController.buscar(id) == null){
					System.out.println("Inválido!");
					System.out.println("Por favor digite um ID válido.");
				}
			}while(salaController.buscar(id) == null);
		}
		else if(tipo == 3){
			do{
				System.out.print("ID do Bloco: ");
				id = scan.nextInt();
				if(blocoController.buscar(id) == null){
					System.out.println("Inválido!");
					System.out.println("Por favor digite um ID válido.");
				}
			}while(blocoController.buscar(id) == null);
		}
		
		return id;
		
	}

}
