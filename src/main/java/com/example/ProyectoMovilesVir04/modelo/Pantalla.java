package com.example.ProyectoMovilesVir04.modelo;
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Pantalla implements Serializable, IPrecio{
	
	@Column(name = "pantalla")
	private float size;
	@Transient
	private final float MIN = 5f;
	@Transient
	private final float MAX = 8f;
	

	public Pantalla() {
		super();
		this.size = getPulgada();
	}
	
	@Override
	public float calcularPrecio() {
		float incrementoPantalla=10;
		return incrementoPantalla*this.size;
	}

	public float getSize() {
		return size;
	}

	public float getMIN() {
		return MIN;
	}

	@Override
	public int hashCode() {
		return Objects.hash(size);
	}
	
	private float getPulgada() {
		float floor = (float)(Math.random()*(MAX-MIN))+MIN;
		return Math.round(floor * 10) / 10f;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pantalla other = (Pantalla) obj;
		return Float.floatToIntBits(size) == Float.floatToIntBits(other.size);
	}

	@Override
	public String toString() {
		return String.valueOf(getSize());
	}

	
	
	

}
