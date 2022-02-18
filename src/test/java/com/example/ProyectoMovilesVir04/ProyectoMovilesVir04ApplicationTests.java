package com.example.ProyectoMovilesVir04;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ProyectoMovilesVir04.control.ObjectMother;
import com.example.ProyectoMovilesVir04.modelo.Movil;
import com.example.ProyectoMovilesVir04.modelo.MovilRepository;


@SpringBootTest
class ProyectoMovilesVir04ApplicationTests {
	
	
	@Autowired
	MovilRepository movilRepository;

	@Test
	void contextLoads() {
		
		
		ObjectMother objectMother = new ObjectMother();
		Set<Movil> listaMoviles = new HashSet<>();
		
		for (int i = 0; i < 50; i++) {
			listaMoviles.add(objectMother.generarMovil(i));
		}
		
		listaMoviles.forEach((a)->{System.out.println(a.toString());});
		movilRepository.saveAll(listaMoviles);
	
	}

}
