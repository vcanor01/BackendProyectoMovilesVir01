package com.example.ProyectoMovilesVir04;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.example.ProyectoMovilesVir04.modelo.MovilService;
import com.example.ProyectoMovilesVir04.modelo.Response;

class ResponseTest {
	
	

	@Test
	void test() {
		
		MovilService movilService = new MovilService();
		
		Response response= Response.builder()
				.TimeStamp(LocalDateTime.now())
				.Status(HttpStatus.OK)
				.Message("currito que sabe")
				.Data(Map.of("moviles", movilService.getMoviles()))
				.build();
		System.out.println(response.getData().get("moviles").toString());
	}

}
