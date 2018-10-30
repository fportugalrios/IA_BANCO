package bean;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorColumn(name= "TipoCuenta", discriminatorType= DiscriminatorType.STRING)
@DiscriminatorValue("CC")
public class CajaCC extends Cuenta {
	
	private float descubierto;
	
	@Override
	public float extraer(float monto, String desc) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
