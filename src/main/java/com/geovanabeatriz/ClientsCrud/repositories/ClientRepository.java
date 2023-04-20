package com.geovanabeatriz.ClientsCrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geovanabeatriz.ClientsCrud.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
