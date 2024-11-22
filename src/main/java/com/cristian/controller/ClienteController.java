package com.cristian.controller;

import org.springframework.http.MediaType;
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
	
	@RequestMapping(value = "cliente/{tipoDocumento}/{documento}", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> getCliente(String tipoDocumento, String documento) {
		Optional<Cliente> cliente = null;
		try {
			JSONObject respuesta = new JSONObject();
			cliente = clienteService.getCliente(tipoDocumento, documento);
			respuesta.put("cliente", cliente);
			if((documento == null || documento.equals("")) || (tipoDocumento == null || tipoDocumento.equals(""))) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			if (!cliente.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<Cliente>(cliente.get(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Cliente>(cliente.get(),HttpStatus.OK);
	}
}
