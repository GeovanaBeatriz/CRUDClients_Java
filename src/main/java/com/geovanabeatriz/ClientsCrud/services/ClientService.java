package com.geovanabeatriz.ClientsCrud.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geovanabeatriz.ClientsCrud.dto.ClientDTO;
import com.geovanabeatriz.ClientsCrud.entities.Client;
import com.geovanabeatriz.ClientsCrud.repositories.ClientRepository;
import com.geovanabeatriz.ClientsCrud.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll(){
		List<Client> list = repository.findAll(); //tem q transformar isso em DTO agora
		
		List<ClientDTO> listDto = new ArrayList<>();
		for(Client cat : list) {
			listDto.add(new ClientDTO(cat));
		} //Convertendo em dto
		
		return listDto;
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id); //puxa do banco de dados
		Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found")); //Não achou id
		return new ClientDTO(entity);
	}
	
	@Transactional
	public ClientDTO insert (ClientDTO dto) {
		 Client entity = new Client();
		 entity.setName(dto.getName());
		 entity.setCpf(dto.getCpf());
		 entity.setIncome(dto.getIncome());
		 entity.setBirthDate(dto.getBirthDate());
		 entity.setChildren(dto.getChildren());
		 entity = repository.save(entity);
		 return new ClientDTO(entity);
	}

	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
			Client entity = repository.getOne(id); //aqui não mexe no banco de dados ainda
			entity.setName(dto.getName());
			entity.setCpf(dto.getCpf());
			entity.setIncome(dto.getIncome());
			entity.setBirthDate(dto.getBirthDate());
			entity.setChildren(dto.getChildren());
			entity = repository.save(entity); //somente aqui
			return new ClientDTO(entity);
			}
			catch(EntityNotFoundException e) {
				throw new ResourceNotFoundException("id not found");
			}
	}
}
