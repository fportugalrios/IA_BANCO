package app;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import bean.CajaAhorro;
import bean.Cliente;
import bean.Cuenta;
import bean.CuentaView;
import bean.ListClientes;
import bean.ListCuentas;


public class Banco 
{
	private ListClientes clientes;
	private ListCuentas cuentas;
	private float interesCADolar;
	private float descubiertoCCDolar;
	private float interesCAPesos;
	private float descubiertoCCPesos;
	
	public Banco()
	{
		clientes = new ListClientes();
		cuentas = new ListCuentas();
	}

	public float getInteresCADolar() {
		return interesCADolar;
	}

	public void setInteresCADolar(float interesCADolar) {
		this.interesCADolar = interesCADolar;
	}

	public float getDescubiertoCCDolar() {
		return descubiertoCCDolar;
	}

	public void setDescubiertoCCDolar(float descubiertoCCDolar) {
		this.descubiertoCCDolar = descubiertoCCDolar;
	}

	public float getInteresCAPesos() {
		return interesCAPesos;
	}

	public void setInteresCAPesos(float interesCAPesos) {
		this.interesCAPesos = interesCAPesos;
	}

	public float getDescubiertoCCPesos() {
		return descubiertoCCPesos;
	}

	public void setDescubiertoCCPesos(float descubiertoCCPesos) {
		this.descubiertoCCPesos = descubiertoCCPesos;
	}
	
	public void crearCliente(String nombre, String dni,int telefono,
			String domicilio)
	{
		Cliente c = buscarCliente(dni);
		if (c==null)
		{
			c = new Cliente();
			c.setDatos(dni, domicilio, nombre, telefono);
			clientes.addCliente(c);
		}
	}

	private Cliente buscarCliente(String dni)
	{
		return clientes.getClientePorId(dni);
	}
	
	public void modificarCliente (String nombre, String dni, int telefono,
			String domicilio)
	{
		Cliente c = buscarCliente(dni);
		if (c!=null)
		{
			c.setNombre(nombre);
			c.setTelefono(telefono);
			c.setDomicilio(domicilio);
		}
	}
	
	public void eliminarCliente(String dni)
	{
		Cliente c = buscarCliente(dni);
		//if (!c.hayCuentasActivas())
			clientes.removeCliente(c);
	}

	public void abrirCajaAhorroPesos (String dni,int nroCta)
	{
		Cliente c = buscarCliente(dni);
		if (c!=null)
		{
			Cuenta cta = buscarCuenta(nroCta);
			if (cta==null)
			{
				CajaAhorro ca$ = new CajaAhorro ();
				ca$.setDatos(LocalDate.now(),nroCta,c,interesCAPesos);
				cuentas.addCuenta(ca$);
				//c.add(ca$);
				
			}
		}
	}

	private Cuenta buscarCuenta(int nroCta) 
	{
		return cuentas.getCuentaPorId(nroCta);
	}
	
/*
	private Cliente buscarClienteConCuenta(int nroCta) 
	{
		for(int i=0;i<clientes.size();i++)
		{
			if (clientes.elementAt(i).tieneCuenta(nroCta))
				return clientes.elementAt(i);
		}
		return null;
	}
*/
	public float depositar(int nroCta, float monto)
	{
		Cuenta cta = buscarCuenta(nroCta);
		if (cta!=null)
		{
			cta.depositar(monto);
			return cta.getSaldo();
		}
		return 0;
	}
	
	public float extraer(int nroCta, float monto)
	{
		Cuenta cta = buscarCuenta(nroCta);
		if (cta!=null)
			return cta.extraer(monto, "Extraccion de cuenta");
		return -2;
	}	
	
	public void actualizarBD()
	{
		clientes.actualizarBD();
		cuentas.actualizarBD();
		
	}

	public List<CuentaView> getCuentas() 
	{
		return cuentas.getCuentasView();
	}

	public void debitarMantenimiento(float monto) 
	{
		for(Cuenta c : cuentas.getCuentas())
		{
			c.extraer(monto,"Debito Mantenimiento");
		}
		
	}

	public float consultarSaldoCuenta(int cta) 
	{
		Cuenta cuenta = cuentas.getCuentaPorId(cta);
		if (cuenta!=null)
			return cuenta.getSaldo();
		return 0;
	}

	public CuentaView getCuenta(int cta) 
	{
		Cuenta cuenta = cuentas.getCuentaPorId(cta);
		if (cuenta!=null)
			return cuenta.getView();
		return null;
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


