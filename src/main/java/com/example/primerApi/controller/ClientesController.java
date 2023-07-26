package com.example.primerApi.controller;

import com.example.primerApi.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    private ClientesService clientesService = null;

    @Autowired
    public ClientesController(clientesService clienteservice) {
        this.clientesService = clienteservice;
    }

    @GetMapping("/{id}")
    public Optional<Clientes> findClienteById(@PathVariable("id") Long id){
        return clientesService.findClienteById(id);

    }


    @GetMapping("/all")
    public List<Clientes> findAllCliente(){
        return clientesService.findAllClientes();

    }

    @PostMapping("/add")
    public Clientes addCliente(@RequestBody Clientes clientes) {
        return clientesService.addCliente(clientes);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCliente(@PathVariable("id") Long id){
        clientesService.deleteCliente(id);

    }

}