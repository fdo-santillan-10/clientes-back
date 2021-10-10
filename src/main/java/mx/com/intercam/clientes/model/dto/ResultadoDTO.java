package mx.com.intercam.clientes.model.dto;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ResultadoDTO implements Serializable {
	
	private static final long serialVersionUID = 2348378731926672327L;
	
	private HttpStatus codigo;
	private Long id;
	private String mensaje;
}
