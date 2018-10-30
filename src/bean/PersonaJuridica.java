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
public class PersonaJuridica extends Cliente {
	 
	@Column (name = "CUIT")
	private String CUIT;
	
	@Column (name = "RazonSocial", nullable = false, length = 50)
	private String RazonSocial;
	
	
	public PersonaJuridica(String cuit, String domicilio, String razonSocial, int telefono) {
		super();
		CUIT = cuit;
		RazonSocial = razonSocial;
	}
	
	

	
	
}

