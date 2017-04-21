package main.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import main.Main;

public class Patrimonio extends InformacoesBasicas {
	
	private Integer idMovimentacao;
	private Integer status; // 1 - Padrão, 2 - Danificado / Inutilizável, 3 - Em manutenção
	private Calendar manutencao;
	private Integer frequenciaDeManutencao; // Em dias
	
	public Patrimonio(){
		//Função usada para criar patrimonios de teste
	}
	
	public Patrimonio(Integer id){
		
		this.setId(id);
		
		Main.salaController.listar(1);
		this.setIdMovimentacao(Main.movimentacaoController.adicionar(this.getId(), Main.checarID(2)));
		
		System.out.print("Nome: ");
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
	public boolean checarManutencao(){
		Calendar hoje = Calendar.getInstance();
		if(manutencao.get(Calendar.DATE) == hoje.get(Calendar.DATE) && manutencao.get(Calendar.MONTH) == hoje.get(Calendar.MONTH) && manutencao.get(Calendar.YEAR) == hoje.get(Calendar.YEAR)){
			return true;	
		}
				
		return false;  
	}
	public Integer getFrequenciaDeManutencao() {
		return frequenciaDeManutencao;
	}
	public void setFrequenciaDeManutencao(Integer frequenciaDeManutencao) {
		this.frequenciaDeManutencao = frequenciaDeManutencao;
	}
	
}
