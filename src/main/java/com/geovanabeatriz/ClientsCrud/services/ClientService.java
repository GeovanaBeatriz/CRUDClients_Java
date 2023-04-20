package com.geovanabeatriz.ClientsCrud.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geovanabeatriz.ClientsCrud.dto.ClientDTO;
import com.geovanabeatriz.ClientsCrud.entities.Client;
import com.geovanabeatriz.ClientsCrud.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	
	public List<ClientDTO> findAll(){
		List<Client> list = repository.findAll(); //tem q transformar isso em DTO agora
		
		List<ClientDTO> listDto = new ArrayList<>();
		for(Client cat : list) {
			listDto.add(new ClientDTO(cat));
		} //Convertendo em dto
		
		return listDto;
	}
}
