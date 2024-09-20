package com.example.redis.controller;

import com.example.redis.model.Veiculos;
import com.example.redis.repository.VeiculoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoRepository veiculoRepository;

    public VeiculoController(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    @PostMapping
    public Veiculos criarVeiculo(@RequestBody Veiculos veiculo) {
        return veiculoRepository.save(veiculo);
    }

    @GetMapping("/{id}")
    public Optional<Veiculos> getVeiculo(@PathVariable String id) {
        return veiculoRepository.findById(id);
    }

    @GetMapping
    public List<Veiculos> getAllVeiculos() {
        return (List<Veiculos>) veiculoRepository.findAll();
    }

    @PutMapping("/{id}")
    public Veiculos updateVeiculo(@PathVariable String id, @RequestBody Veiculos veiculoDetails) {
        Veiculos veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
        veiculo.setMarca(veiculoDetails.getMarca());
        veiculo.setModelo(veiculoDetails.getModelo());
        veiculo.setAno(veiculoDetails.getAno());
        return veiculoRepository.save(veiculo);
    }

    @DeleteMapping("/{id}")
    public void deleteVeiculo(@PathVariable String id) {
        veiculoRepository.deleteById(id);
    }
}