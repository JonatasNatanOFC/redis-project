package com.example.redis.controller;

import com.example.redis.model.Cliente;
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
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @GetMapping("/{cpf}")
    public Optional<Cliente> getCliente(@PathVariable String cpf) {
        return clienteRepository.findById(cpf);
    }

    @GetMapping
    public List<Cliente> getAllClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @PutMapping("/{cpf}")
    public Cliente updateCliente(@PathVariable String cpf, @RequestBody Cliente clienteDetails) {
        Cliente cliente = clienteRepository.findById(cpf)
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
