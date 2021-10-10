package mx.com.intercam.clientes.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.intercam.clientes.common.base.rest.AbstractBaseRestController;
import mx.com.intercam.clientes.model.dto.ResultadoDTO;
import mx.com.intercam.clientes.model.entities.Cliente;
import mx.com.intercam.clientes.service.ClienteService;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteRestController extends AbstractBaseRestController {

	@Autowired
	private ClienteService service;
	
	@PostMapping(path = "/guardar")
	public ResultadoDTO guardar(@RequestBody Cliente cliente) {
		
		ResultadoDTO resultado = new ResultadoDTO();
		
		try {
			Cliente clienteSave = service.guardar(cliente);
			resultado.setCodigo(HttpStatus.OK);
			resultado.setId(clienteSave.getId());
		} catch(Exception ex) {
			resultado.setCodigo(HttpStatus.BAD_REQUEST);
			resultado.setMensaje(ex.getMessage());
		}
		
		return resultado;
	}
	
	@GetMapping(path = "/cliente")
	public Cliente consultaClienteId(@RequestParam Long id) {
		return service.buscarClienteId(id).orElse(new Cliente());
	}
	
	@GetMapping(path = "/clientes")
	public List<Cliente> consultaClientes() {
		return service.consultaClientes();
	}
	
	@DeleteMapping(path = "/eliminar")
	public ResultadoDTO eliminarCliente(@RequestParam Long id) {
		
		ResultadoDTO resultado = new ResultadoDTO();
		
		try {
			service.eliminarCliente(id);
			resultado.setCodigo(HttpStatus.OK);
		} catch(Exception ex) {
			resultado.setCodigo(HttpStatus.BAD_REQUEST);
			resultado.setMensaje(ex.getMessage());
		}
		
		return resultado;
	}
}
