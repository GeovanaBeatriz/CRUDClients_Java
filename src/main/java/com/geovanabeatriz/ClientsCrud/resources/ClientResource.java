package com.geovanabeatriz.ClientsCrud.resources;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geovanabeatriz.ClientsCrud.entities.Client;
import com.geovanabeatriz.ClientsCrud.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		//1 - List<Client> list = new ArrayList<>();
		//1- list.add(new Client(1L, "Maria Sousa", "51810490871", 5.80, Instant.now(), 5));
		
		List<Client> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
