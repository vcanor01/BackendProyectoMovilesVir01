package com.example.ProyectoMovilesVir04.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.ProyectoMovilesVir04.utiles.GenerarCadena;

@Entity
public class Movil implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "marca")
	private String marca;
	
	@Column(name = "modelo")
	private String modelo;
	
	@Embedded
	@Column(name = "pantalla", nullable = false)
	private Pantalla pantalla;
	
	@Embedded
	@Column(name = "ram" ,nullable = false)
	private Ram ram;
	
	@Embedded
	@Column(name = "procesador", nullable = false)
	private Procesador procesador;
	
	@Embedded
	@Column(name= "antutu", nullable = false)
	private Antutu antutu;
	
	@Embedded
	@Column(name= "bateria" , nullable = false)
	private Bateria bateria;
	
	@Column(name = "precio")
	private float precio;
	
	public Movil() {
		super();
	}
	
	
//	public Movil(MovilBuilder builder) {
//		super();
//		this.id = builder.getId();
//		this.marca = builder.getMarca();
//		this.modelo = builder.getModelo();
//		this.pantalla = builder.getPantalla();
//		this.ram = builder.getRam();
//		this.procesador = builder.getProcesador();
//		this.antutu = builder.getAntutu();
//		this.bateria = builder.getBateria();
//		this.precio = builder.getPrecio();
//	}
	
	Movil(MovilBuilder builderMovil){
		this.id=builderMovil.id;
		this.marca=builderMovil.marca;
		this.modelo=builderMovil.modelo;
		this.pantalla=builderMovil.pantalla;
		this.ram=builderMovil.ram;
		this.procesador=builderMovil.procesador;
		this.antutu=builderMovil.antutu;
		this.bateria=builderMovil.bateria;
		this.precio=builderMovil.precio;
	}
	
	public static MovilBuilder builderMovil() {
		return new MovilBuilder();
	}

	
	public Movil(String marca, String modelo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
	}


	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Pantalla getPantalla() {
		return pantalla;
	}

	public void setPantalla(Pantalla pantalla) {
		this.pantalla = pantalla;
	}

	public Ram getRam() {
		return ram;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

	public Procesador getProcesador() {
		return procesador;
	}

	public void setProcesador(Procesador procesador) {
		this.procesador = procesador;
	}

	public Antutu getAntutu() {
		return antutu;
	}

	public void setAntutu(Antutu antutu) {
		this.antutu = antutu;
	}

	public Bateria getBateria() {
		return bateria;
	}

	public void setBateria(Bateria bateria) {
		this.bateria = bateria;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	

	
	public int getId() {
		return this.id;
	}


	@Override
	public String toString() {
		return "ID: "+ String.valueOf(id) +" Movil [Marca:" + marca.toString() + ", Modelo:" + modelo.toString() + ", Pantalla:" + pantalla.toString() + ", " + ram.toString()
				+ ", " + procesador.toString() + ", Antutu: " + antutu + ", " + bateria.toString() + ", Precio:" + precio
				+ "]";
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movil other = (Movil) obj;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		return true;
	}
	
	
	public static class MovilBuilder implements Serializable {
		
		private  int id;
		private  String marca;
		private  String modelo;
		private  Pantalla pantalla;
		private  Ram ram;
		private  Procesador procesador;
		private  Antutu antutu;
		private  Bateria bateria;
		private float precio;
		
		private static int contador=0;
		
//		public MovilBuilder() {
//			super();
//			this.id= contador++;
//			this.marca = GenerarCadena.generarPalabras(7);
//			this.modelo = GenerarCadena.generarModelo(7);
//			this.pantalla = new Pantalla();
//			this.ram = new Ram();
//			this.procesador = new Procesador();
//			this.antutu = new Antutu(procesador,ram);
//			this.bateria = new Bateria(pantalla, procesador,ram);
//			this.precio = calcularPrecio();
//		}
		
		
		
		
		
		private float calcularPrecio() {
			return this.pantalla.calcularPrecio()+ this.ram.calcularPrecio()+this.procesador.calcularPrecio()+this.bateria.calcularPrecio();
		}
		
		public MovilBuilder Id() {
			this.id=contador++;
			return this;
		}
		public MovilBuilder Id(int id) {
			this.id=id;
			return this;
		}
		public MovilBuilder Marca() {
			this.marca=GenerarCadena.generarPalabras(7);
			return this;
		}
		public MovilBuilder Modelo() {
			this.modelo=GenerarCadena.generarModelo(7);
			return this;
		}
		public MovilBuilder Pantalla() {
			this.pantalla=new Pantalla();
			return this;
		}
		public MovilBuilder Ram() {
			this.ram=new Ram();
			return this;
		}
		public MovilBuilder Procesador() {
			this.procesador=new Procesador();
			return this;
		}
		public MovilBuilder Antutu() {
			this.antutu=new Antutu(this.procesador,this.ram);
			return this;
		}
		public MovilBuilder Bateria() {
			this.bateria=new Bateria(this.pantalla,this.procesador,this.ram);
			return this;
		}
		public MovilBuilder Precio() {
			this.precio=this.calcularPrecio();
			return this;
		}
		
		
		public Movil movilBuild() {
			return new Movil(this);
		}

		

		
	}
	
	
}
