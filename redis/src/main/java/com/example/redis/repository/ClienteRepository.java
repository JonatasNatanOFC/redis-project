package com.example.redis.repository;

import com.example.redis.model.Clientes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Clientes, String> {

}
