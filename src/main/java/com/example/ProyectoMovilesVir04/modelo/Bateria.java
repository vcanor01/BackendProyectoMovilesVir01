package com.example.ProyectoMovilesVir04.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Bateria implements Serializable, IPrecio{
	
	@Column(name = "bateria")
	private int mwh;
	@Transient
	private int mwhMin = 2500;
	@Transient
	private int mwhMax = 3000;
	@Transient
	private float incrementoMwh = 500f;
	
	public Bateria() {
		super();
	}

	public Bateria(Pantalla pantalla, Procesador procesador, Ram ram) {
		super();
		this.mwh = calcularBateria(pantalla, procesador, ram);
	}

	private int calcularBateria(Pantalla pantalla,Procesador procesador, Ram ram) {
		float pulgadasSobrantes = pantalla.getSize()-pantalla.getMIN();
		pulgadasSobrantes *= incrementoMwh;
		mwhMin += pulgadasSobrantes;
		mwhMax += pulgadasSobrantes;
		return getMwhRandom(mwhMax, mwhMin)+ obtenerIncrProcesador(procesador)+ obtenerIncrRam(ram);
	}
	
	private int obtenerIncrProcesador(Procesador procesador) {
		float incrementoNucleo = 200f;
		float incrementoVelocidad = 200f;
		float velocidad = procesador.getVelocidad()*incrementoVelocidad;
		float nucleos = (procesador.getNucleos()*incrementoNucleo)/2;
		float suma = velocidad+nucleos;
		return (int) suma;
	}
	private int obtenerIncrRam(Ram ram) {
		float incrementoGb = 200f;
		float gb = (ram.getGb()*incrementoGb)/2;
		return (int)gb;
	}
	
	private int getMwhRandom(int max, int min) {
		int mwh = (int) (Math.random()*(max-min)+min);
		return mwh;
	}
	
	@Override
	public float calcularPrecio() {
		float incrementoBateria= 0.01f;
		return incrementoBateria*this.mwh;
	}
	

	public int getMwh() {
		return mwh;
	}

	@Override
	public int hashCode() {
		return Objects.hash(mwh);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bateria other = (Bateria) obj;
		return mwh == other.mwh;
	}

	@Override
	public String toString() {
		return "Bateria: " + mwh + " mwh]";
	}


	
	
}
