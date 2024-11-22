package com.cristian.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cristian.model.Cliente;
import com.cristian.service.ClienteService;

@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);
	
	/**
	 * EndPonint que devuelve un Objeto Cliente filtrado por tipo documento y número de documento
	 * @param tipoDocumento
	 * @param documento
	 * @return
	 */
	@RequestMapping(value = "cliente", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> getCliente(@RequestParam String tipoDocumento, @RequestParam String documento) {
		Optional<Cliente> cliente = null;
		try {
			cliente = clienteService.getCliente(tipoDocumento, documento);
			if((documento == null || documento.equals("")) || (tipoDocumento == null || tipoDocumento.equals(""))) {
				logger.warn("El tipo de documento do numero documento no pueden ser vacíos");
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			if (!cliente.isPresent()) {
				logger.warn("El cliente no existe");
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			logger.error("Error en el api");
			return new ResponseEntity<Cliente>(cliente.get(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("Cliente si existe");
		return new ResponseEntity<Cliente>(cliente.get(),HttpStatus.OK);
	}
}
