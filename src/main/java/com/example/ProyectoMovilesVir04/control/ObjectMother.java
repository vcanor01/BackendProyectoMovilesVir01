package com.example.ProyectoMovilesVir04.control;

import javax.persistence.Entity;

import com.example.ProyectoMovilesVir04.modelo.Movil;



public class ObjectMother {
	
	
	
	
	public Movil generarMovil(int id){
		
		return Movil.builderMovil()
				.Id(id)
				.Marca()
				.Modelo()
				.Pantalla()
				.Ram()
				.Procesador()
				.Antutu()
				.Bateria()
				.Precio()
				.movilBuild();
	}
	
}
