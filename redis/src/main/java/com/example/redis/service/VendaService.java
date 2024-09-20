package com.example.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.redis.model.Veiculos;
import com.example.redis.model.Vendas;
import com.example.redis.repository.VeiculoRepository;
import com.example.redis.repository.VendaRepository;

@Service
public class VendaService {
    
    @Autowired
    private VeiculoRepository veiculoRepository;
    @Autowired
    private VendaRepository vendaRepository;

    public void venderVeiculo(String veiculoId) {
        Veiculos veiculos = veiculoRepository.findById(veiculoId).orElse(null);
        if (veiculos != null && veiculos.isDisponivel()) {
            Vendas vendas = new Vendas();
            vendas.setId(veiculoId);
            vendas.setCarro(veiculos.getMarca());
            vendas.setModelo(veiculos.getModelo());
            vendas.setAno(veiculos.getAno());

            vendaRepository.save(vendas);

            veiculoRepository.deleteById(veiculoId);

            System.out.println("Veiculo vendido com sucesso");
        } else {
            System.out.println("Veiculo não está disponivel");
        }
    }
}
