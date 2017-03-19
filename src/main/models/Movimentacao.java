package main.models;

import java.util.Calendar;
import java.util.Date;

import main.Main;

public class Movimentacao {
	
	private Integer id;
	private Integer idSala;
	private Integer idPatrimonio;
	private Calendar data;
	
	public Movimentacao(){
		
	}
	
	public Movimentacao(Integer id){
		
		this.setId(id);
		
		Main.patrimonioController.listar(1);
		
		this.setIdPatrimonio(Main.checarID(1));
		
		System.out.println("\nDefinir nova sala do patrimonio: ");
		Main.salaController.listar(1);

		this.setIdSala(Main.checarID(2));
		
		this.setData();
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdSala() {
		return idSala;
	}
	public void setIdSala(Integer idSala) {
		this.idSala = idSala;
	}
	public Integer getIdPatrimonio() {
		return idPatrimonio;
	}
	public void setIdPatrimonio(Integer idPatrimonio) {
		this.idPatrimonio = idPatrimonio;
	}
	public Calendar getData() {
		return data;
	}
	public void setData() {
		setData(null);
	}
	public void setData(Date data) {
		this.data = Calendar.getInstance();
		if(data != null) this.data.setTime(data);
	}
	public String toString(){
		return "ID: "+this.id+" | ID-Patrimonio: "+this.idPatrimonio+" | ID-Sala: "+this.idSala+" | Data: "+data.get(Calendar.DAY_OF_MONTH)+"/"+(data.get(Calendar.MONTH)+1)+"/"+data.get(Calendar.YEAR);
	}

}
