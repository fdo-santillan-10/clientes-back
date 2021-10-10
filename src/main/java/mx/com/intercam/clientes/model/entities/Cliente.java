package mx.com.intercam.clientes.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 5837290120150352231L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "Nombre", length = 512)
	private String nombre;
	
	@Column(name = "ApellidoPaterno", length = 512)
	private String apellidoPaterno;
	
	@Column(name = "ApellidoMaterno", length = 512)
	private String apellidoMaterno;
	
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@Column(name = "Ingresos")
	private BigDecimal ingresos;
	
	@Column(name = "CodigoPostal", length = 6)
	private String codigoPostal;
}
