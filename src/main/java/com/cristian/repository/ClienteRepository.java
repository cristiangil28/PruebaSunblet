package com.cristian.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.cristian.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	Optional<Cliente> getCliente(String documento);
}
