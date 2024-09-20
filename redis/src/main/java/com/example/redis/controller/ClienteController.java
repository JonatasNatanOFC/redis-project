package com.example.redis.controller;

import com.example.redis.model.Clientes;
import com.example.redis.repository.ClienteRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping
    public Clientes criarCliente(@RequestBody Clientes clientes) {
        return clienteRepository.save(clientes);
    }

    @GetMapping("/{cpf}")
    public Optional<Clientes> getCliente(@PathVariable String cpf) {
        return clienteRepository.findById(cpf);
    }

    @GetMapping
    public List<Clientes> getAllClientes() {
        return (List<Clientes>) clienteRepository.findAll();
    }

    @PutMapping("/{cpf}")
    public Clientes updateCliente(@PathVariable String cpf, @RequestBody Clientes clienteDetails) {
        Clientes cliente = clienteRepository.findById(cpf)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        cliente.setNome(clienteDetails.getNome());
        cliente.setIdade(clienteDetails.getIdade());
        cliente.setLogradouro(clienteDetails.getLogradouro());
        cliente.setCidade(clienteDetails.getCidade());
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/{cpf}")
    public void deleteCliente(@PathVariable String cpf) {
        clienteRepository.deleteById(cpf);
    }

}
