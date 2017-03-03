package main.models;

import java.util.Calendar;
//a decidir qual biblioteca de data vai ser usada
public class Movimentacao {
	
	private Integer id;
	private Integer idSala;
	private Integer idPatrimonio;
	private Calendar data;
	
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
	public void setData(Calendar data) {
		this.data = data;
	}

}
