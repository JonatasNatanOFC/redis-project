package com.example.redis.repository;

import com.example.redis.model.Vendas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends CrudRepository<Vendas, String> {
}
