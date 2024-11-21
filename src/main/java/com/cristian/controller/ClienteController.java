package com.cristian.controller;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cristian.model.Cliente;
import com.cristian.service.ClienteService;

@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@RequestMapping(value = "cliente/{tipoDocumento}/{documento}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> getCliente(String tipoDocumento, String documento) {
		JSONObject respuesta = new JSONObject();
		Optional<Cliente> cliente = clienteService.getCliente(tipoDocumento, documento);
		respuesta.put("cliente", cliente);
		if((documento == null || documento.equals("")) || (tipoDocumento == null || tipoDocumento.equals(""))) {
			respuesta.put("error", "El Tipo de Documento o  el Documento son obligatorios");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (!cliente.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cliente>(cliente.get(),HttpStatus.OK);
	}
}
