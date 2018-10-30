package bean;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@DiscriminatorColumn(name= "TipoCuenta", discriminatorType= DiscriminatorType.STRING)
@DiscriminatorValue("F")
public class PersonaFisica extends Cliente {
	
	 
	@Column (name = "DNI")
	private String dni;
	
	@Column (name = "NombreApellido", nullable = false, length = 50)
	private String nombre;
	
	
	public PersonaFisica(String dni, String domicilio, String nombre, int telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}
	
	
}
