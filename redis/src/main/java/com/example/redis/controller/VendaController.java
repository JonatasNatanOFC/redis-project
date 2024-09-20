package com.example.redis.controller;

import com.example.redis.model.Vendas;
import com.example.redis.repository.VendaRepository;
import com.example.redis.service.VendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;
    
    private final VendaRepository vendaRepository;

    public VendaController(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    @PostMapping
    public Vendas criarVenda(@RequestBody Vendas vendas) {
        return vendaRepository.save(vendas);
    }

    @PostMapping("/vender/{id}")
    public String venderVeiculo(@PathVariable String id) {
        vendaService.venderVeiculo(id);
        return "Processo de venda iniciado.";
    }

    @GetMapping
    public List<Vendas> getAllVendas() {
        return (List<Vendas>) vendaRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteVenda(@PathVariable String id) {
        vendaRepository.deleteById(id);
    }
}
