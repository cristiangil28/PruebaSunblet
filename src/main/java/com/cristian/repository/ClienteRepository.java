package com.cristian.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.cristian.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	
	@Query(value= " select c.* from cliente c", nativeQuery = true)
	Optional<Cliente> getCliente(String tipoDocumento, String documento);
}
