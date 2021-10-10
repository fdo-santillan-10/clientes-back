package mx.com.intercam.clientes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.intercam.clientes.dao.ClienteRepository;
import mx.com.intercam.clientes.model.entities.Cliente;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public Cliente guardar(Cliente cliente) {
		return repository.save(cliente);
	}
	
	public Optional<Cliente> buscarClienteId(Long id) {
		return repository.findById(id);
	}
	
	public List<Cliente> consultaClientes() {
		return repository.findAll();
	}
	
	public void eliminarCliente(Long id) {
		repository.deleteById(id);
	}
}
