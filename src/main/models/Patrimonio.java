package main.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import main.Main;

public class Patrimonio {
	
	private Integer id;
	private String nome;
	private String numero;
	private Integer idMovimentacao;
	private Integer status; // 1 - Padrão, 2 - Danificado / Inutilizável, 3 - Em manutenção
	private Calendar manutencao;
	private Integer frequenciaDeManutencao; // Em dias
	
	public Patrimonio(){
		//Função usada para criar patrimonios de teste
	}
	
	public Patrimonio(Integer id){
		
		this.setId(id);
		Main.blocoController.listar();
		
		System.out.print("ID Bloco para alocação:");
		Main.salaController.listarPorBloco(Main.scan.nextInt());
		
		System.out.print("ID Sala para alocação:");
		this.setIdMovimentacao(Main.movimentacaoController.adicionar(this.getId(), Main.scan.nextInt()));
		
		System.out.print("Nome: ");
		Main.scan.nextLine();
		this.setNome(Main.scan.nextLine());
		
		System.out.print("Numero: ");
		this.setNumero(Main.scan.nextLine());
		
		this.setStatus(1);
		
		System.out.println("Tipo de Manutencao: ");
		System.out.println("1 - Periodica");
		System.out.println("2 - Pontual");
		int answer = Main.scan.nextInt();
		
		if(answer == 1){
			System.out.print("Frequencia(Em dias): ");
			this.setFrequenciaDeManutencao(Main.scan.nextInt());
			Main.scan.nextLine();
			System.out.print("Data da proxima manutenção(dd/MM/aaaa): ");
			String m = Main.scan.nextLine();
			SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy");
			try {
				this.setManutencao(sm.parse(m));
			} catch (ParseException e) {
				System.out.println("Formato de data errado");
				e.printStackTrace();
			}
		}
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Integer getIdMovimentacao() {
		return idMovimentacao;
	}
	public void setIdMovimentacao(Integer idMovimentacao) {
		this.idMovimentacao = idMovimentacao;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Calendar getManutencao(){
		return manutencao;
	}
	public void setManutecao(){
		this.manutencao.add(Calendar.DATE, frequenciaDeManutencao);
	}
	public void setManutencao(Date manutencao){
		this.manutencao = Calendar.getInstance();
		this.manutencao.setTime(manutencao);
	}
	public Integer getFrequenciaDeManutencao() {
		return frequenciaDeManutencao;
	}
	public void setFrequenciaDeManutencao(Integer frequenciaDeManutencao) {
		this.frequenciaDeManutencao = frequenciaDeManutencao;
	}
	public String toString(){
		return "ID: "+this.id+" | Nome: "+this.nome+" | Numero: "+this.numero;
	}
	
}
