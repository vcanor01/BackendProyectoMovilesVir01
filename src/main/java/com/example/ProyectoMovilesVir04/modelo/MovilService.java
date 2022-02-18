package com.example.ProyectoMovilesVir04.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.ProyectoMovilesVir04.control.ObjectMother;



@Service
public class MovilService {
	
	Set<Movil> movilesLista;
	ObjectMother objectMother = new ObjectMother();
	
	public MovilService(){
		
		movilesLista = new HashSet<Movil>();
		for (int i = 0; i < 50; i++) {
			movilesLista.add(objectMother.generarMovil(i));
		}
	}
	
	public HashSet<Movil> getMoviles(){
		return (HashSet<Movil>) this.movilesLista;
	}
	
	public List<Movil> getMovilesPorMarca(String marca){
		return this.getMoviles().stream().filter(
				(Movil movil)-> movil.getMarca().startsWith(marca))
				.collect(Collectors.toList());
	}
	
	public List<Movil> getMovilesPorBateria(int bateria){
		return this.getMoviles().stream().filter(
				(Movil movil)-> movil.getBateria().getMwh()==bateria)
				.collect(Collectors.toList());
	}
	
	public List<Movil> getMovilesPorRam(int ram){
		return this.getMoviles().stream().filter(
				(Movil movil)-> movil.getRam().getGb()==ram)
				.collect(Collectors.toList());
	}
	
	public List<Movil> getMovilesPrecio(float precio){
		return this.getMoviles().stream().filter(
				(Movil movil)-> movil.getPrecio()==precio)
				.collect(Collectors.toList());
	}
	
	public List<Movil> buscarMovilesFiltros(String marca,  int bateria, float precio, int ram){
		return this.getMoviles().stream().filter(
				(Movil movil)-> movil.getMarca().startsWith(marca) 
				&& movil.getBateria().getMwh()==bateria
				&& movil.getPrecio()==precio
				&& movil.getRam().getGb()==ram)
				.collect(Collectors.toList());
	}
	
	public List<Movil> compararMoviles(String marcaUno, String marcaDos){
		List<Movil> dosMoviles = new ArrayList<Movil>();
		dosMoviles.add(this.getMoviles().stream().filter((a)-> a.getMarca().equals(marcaUno)).findFirst().get());
		dosMoviles.add(this.getMoviles().stream().filter((a)-> a.getMarca().equals(marcaDos)).findFirst().get());
		
		return dosMoviles;
	}
	
	
	
	
	

}
