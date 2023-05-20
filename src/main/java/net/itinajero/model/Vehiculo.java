package net.itinajero.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "autos")
public class Vehiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment MySQL
	private Integer id;
	
	private String Marca; // Fecha en que aplico el usuario para esta oferta de trabajo
	private String Modelo;
	


	
	
	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", Marca=" + Marca + ", Modelo=" + Modelo + "]";
	}

	
	
}
