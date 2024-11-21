package com.cristian.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristian.model.Cliente;
import com.cristian.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public Optional <Cliente> getCliente(String documento){
		return clienteRepository.getCliente(documento);
	}
}
