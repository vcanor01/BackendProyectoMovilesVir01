package com.example.ProyectoMovilesVir04.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import com.example.ProyectoMovilesVir04.utiles.GenerarCadena;


@Embeddable
public class Procesador implements Serializable, IPrecio{
	
	@Column(name = "procesador")
	private String nombre;
	@Column(name = "nucleos")
	private int nucleos;
	@Column(name = "velocidad")
	private float velocidad;
	
	@Transient
	private float minVelocidad= 0.9f;//1.3 ghz
	@Transient
	private float maxVelocidad= 1.4f;//3ghz
	@Transient
	private final float INCREMENTO = 0.5f;
	@Transient
	private final int MIN_NUCLEOS=2;
	@Transient
	private final int MAX_NUCLEOS=8;
	
	public Procesador() {
		super();
		this.nombre = GenerarCadena.generarPalabras(5);
		this.nucleos = generarNucleos();
		this.velocidad = generarVelocidad();
	}
	
	public int generarNucleos(){
		Random r = new Random();
		List<Integer> listaNucleos = r.ints(MIN_NUCLEOS,MAX_NUCLEOS+1).limit(30).distinct().boxed().collect(Collectors.toList());
		listaNucleos.removeIf((n)-> (n%2 !=0));
	
		return listaNucleos.get(r.nextInt(listaNucleos.size()));
	}
	
	public float generarVelocidad() {
		int nucleos = (this.nucleos - MIN_NUCLEOS)/2;
		float suma = nucleos * this.INCREMENTO;
		minVelocidad += suma;
		maxVelocidad += suma;
		return getGhzRandom(maxVelocidad, minVelocidad);
	}
	
	public float getGhzRandom(float max, float min) {
		float mwh = (float) (Math.random()*(max-min)+min);
		return Math.round(mwh * 10) / 10f;
	}
	
	@Override
	public float calcularPrecio() {
		float incrementoVelocidad = 35;
		float incrementoNucleos =35 ;
		float resultado = (incrementoVelocidad*this.velocidad)+((incrementoNucleos*this.nucleos)/2);
		return resultado;
	}
	
	public String getNombre() {
		return nombre;
	}
	public int getNucleos() {
		return nucleos;
	}
	public float getVelocidad() {
		return velocidad;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nombre, nucleos, velocidad);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Procesador other = (Procesador) obj;
		return Objects.equals(nombre, other.nombre) && nucleos == other.nucleos
				&& Float.floatToIntBits(velocidad) == Float.floatToIntBits(other.velocidad);
	}
	@Override
	public String toString() {
		return "Procesador: " + nombre + ", "+ nucleos + " nucleos, " + velocidad + " ghz]";
	}


	
	
}
