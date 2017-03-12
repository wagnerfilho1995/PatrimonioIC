package main.models;

import java.util.Calendar;
import java.util.Date;

public class Patrimonio {

	private Integer id;
	private String nome;
	private String numero;
	private Integer idMovimentacao;
	private Integer status; // 1 - Padr�o, 2 - Danificado / Inutiliz�vel, 3 - Em manuten��o
	private Calendar manutencao;
	private Integer frequenciaDeManutencao; // Em dias
	
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
