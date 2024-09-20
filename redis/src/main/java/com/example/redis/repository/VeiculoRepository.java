package com.example.redis.repository;

import com.example.redis.model.Veiculos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends CrudRepository<Veiculos, String> {
    
}
