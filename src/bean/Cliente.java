package bean;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "Clientes")
public abstract class Cliente implements Serializable
{
	@Id
	private long codigo;
	
	private static final long serialVersionUID = 1L;
	@Column (name = "telefono", nullable = false, length = 20)
	private int telefono;
	@Column (name = "domicilio", nullable = false, length = 80)
	private String domicilio;
	
	
	public Cliente(int telefono, String domicilio) {
		super();
		this.telefono = telefono;
		this.domicilio = domicilio;
	}

	//private Vector<Cuenta>cuentas;
	
	public void setDatos(Long dni, String domicilio, String nombre, int telefono) 
	{
		this.domicilio = domicilio;
		this.telefono = telefono;
		//cuentas = new Vector<Cuenta>();
	}

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	
	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public void setNombre(String nombre) {
		// TODO Auto-generated method stub
		
	}

	/*
	public Vector<Cuenta> getCuentas() {
		return cuentas;
	}
	
	public void eliminarCuenta (Cuenta cuenta)
	{
		cuentas.remove(cuenta);
	}
	
	public void add (Cuenta cuenta)
	{
		cuentas.add(cuenta);
	}
	
	public boolean hayCuentasActivas ()
	{
		return !(cuentas.size()== 0);
	}
	*/
/*
	public boolean tieneCuenta(int nroCta) 
	{
		for (int i=0;i<cuentas.size();i++)
		{
			if (cuentas.elementAt(i).getNumero()==nroCta)
				return true;
		}
		return false;
	}*/
	

	

}
