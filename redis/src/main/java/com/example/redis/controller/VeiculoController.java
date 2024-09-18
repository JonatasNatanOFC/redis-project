package com.example.redis.controller;

import com.example.redis.model.Veiculo;
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
    public Veiculo criarVeiculo(@RequestBody Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    @GetMapping("/{id}")
    public Optional<Veiculo> getVeiculo(@PathVariable String id) {
        return veiculoRepository.findById(id);
    }

    @GetMapping
    public List<Veiculo> getAllVeiculos() {
        return (List<Veiculo>) veiculoRepository.findAll();
    }

    @PutMapping("/{id}")
    public Veiculo updateVeiculo(@PathVariable String id, @RequestBody Veiculo veiculoDetails) {
        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
        veiculo.setMarca(veiculoDetails.getMarca());
        veiculo.setModelo(veiculoDetails.getModelo());
        veiculo.setAno(veiculoDetails.getAno());
        return veiculoRepository.save(veiculo);
    }

    @DeleteMapping("/{id}")
    public void deleteVeiculo(@PathVariable  String id) {
        veiculoRepository.deleteById(id);
    }
}