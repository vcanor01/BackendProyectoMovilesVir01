package com.example.ProyectoMovilesVir04.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Antutu{
	@Column(name = "puntuacion")
	private int puntuacion;
	@Transient
	private final float puntuacionMin = 40000f;
	
	
	public Antutu() {
		super();
	}
	
	
	public Antutu(Procesador procesador,Ram ram) {
		super();
		this.puntuacion = generarPuntuacion(procesador,ram);
	
		
	}
	
	private int generarPuntuacion(Procesador procesador, Ram ram) {
		float incrementoNucleo = 35000f;
		float incrementoVelocidad = 30000f;
		float velocidadActual= procesador.getVelocidad()*incrementoVelocidad;
		float nucleosActual = (procesador.getNucleos()*incrementoNucleo)/2;
		float incrementoRam = 30000f;
		float gb = (ram.getGb()*incrementoRam)/2;
		return (int) (velocidadActual+nucleosActual+puntuacionMin+gb);
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(puntuacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Antutu other = (Antutu) obj;
		return puntuacion == other.puntuacion;
	}

	@Override
	public String toString() {
		return " " + puntuacion + "]";
	}
	
	
	
	
	
	
}
