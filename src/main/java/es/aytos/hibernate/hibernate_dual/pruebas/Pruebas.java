package es.aytos.hibernate.hibernate_dual.pruebas;

import java.util.Date;
import java.util.List;

import es.aytos.hibernate.hibernate_dual.modelo.EstadoCivil;
import es.aytos.hibernate.hibernate_dual.modelo.Genero;
import es.aytos.hibernate.hibernate_dual.modelo.Persona;
import es.aytos.hibernate.hibernate_dual.modelo.Telefono;
import es.aytos.hibernate.hibernate_dual.modelo.Cliente;
import es.aytos.hibernate.hibernate_dual.modelo.Direccion;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioCliente;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioPersona;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioUsuario;

public class Pruebas {

	public static void main(String[] args) {
		crearPersona("00000000A", "jaa");
//		crearCliente("11111111A", "jaa2");
//		crearPersona("99999999Z", "aaa");
//		crearCliente("88888888Z", "aaa2");
//		modificarCliente();
//		eliminarUsuario();
//		consultarCliente("%Manuel%", "", "", null, "aaa2");
		consultarPersona(1);
	}
	
	private static Integer crearPersona(String dni, String login) {
		final Persona persona = new Persona();
		persona.setNombre("Manuel Jesús");
		persona.setApellidos("Martín Prieto");
		persona.setEdad(24);
		persona.setEstadoCivil(EstadoCivil.SOLTERO);
		persona.setDni(dni);
		persona.setFechaAlta(new Date());
		persona.setLogin(login);
		persona.setPassword("jaa");
		persona.setGenero(Genero.MASCULINO);
		agregarDireccion(persona);
		agregarTelefono(persona);
		
		return RepositorioPersona.crearPersona(persona);
	}
	
	private static Integer crearCliente(String dni, String login) {
		final Cliente cliente = new Cliente();
		cliente.setNombre("Manuel Jesús");
		cliente.setApellidos("Martín Prieto");
		cliente.setEdad(24);
		cliente.setEstadoCivil(EstadoCivil.SOLTERO);
		cliente.setDni(dni);
		cliente.setFechaAlta(new Date());
		cliente.setLogin(login);
		cliente.setPassword("jaa");
		
		
		return RepositorioCliente.crearCliente(cliente);
	}
	
	private static void modificarPersona() {
		RepositorioPersona.modificarPersona(1, "Nadie");
	}
	
	private static void modificarPersona2() {
		Persona persona = new Persona();
		persona.setNombre("Manuel Jesús2");
		persona.setApellidos("Martín Prieto2");
		persona.setEdad(25);
		persona.setEstadoCivil(EstadoCivil.CASADO);
		persona.setDni("02345678X");
		persona.setIdUsuario(1);
		
		RepositorioPersona.modificarPersona2(persona);
	}
	
	private static void modificarCliente() {
		Cliente cliente = new Cliente();
		cliente.setNombre("Cliente");
		cliente.setApellidos("Perdido");
		cliente.setEdad(25);
		cliente.setEstadoCivil(EstadoCivil.CASADO);
		cliente.setDni("02345678X");
		cliente.setIdUsuario(2);
		cliente.setFechaAlta(new Date());
		cliente.setLogin("login");
		cliente.setPassword("passjaa");
		
		RepositorioCliente.modificarCliente(cliente);
	}
	
	private static void eliminarPersona() {
		RepositorioPersona.eliminarPersona(1);
	}
	
	private static void eliminarPersona2() {
		Persona persona = new Persona();
		persona.setIdUsuario(3);;
		
		RepositorioPersona.eliminarPersona2(persona);
	}
	
	private static void eliminarUsuario() {
		RepositorioUsuario.eliminarUsuario(1);
	}
	
//	private static Integer crearProducto() {
//		final Producto producto = new Producto();
//		producto.setNombre("Algo");
//		producto.setDescripcion("Puede que funcione");
//		producto.setCaducidad(new Date());
//		producto.setTipo(TipoProducto.PRODUCTO);
//		producto.setPrecio(5.5);
//		
//		return RepositorioProducto.crearProducto(producto);
//	}
//	
//	private static void modificarProducto() {
//		Producto producto = new Producto();
//		producto.setIdProducto(1);
//		producto.setNombre("Algo 2.0");
//		producto.setDescripcion("Puede que funcione");
//		producto.setCaducidad(new Date());
//		producto.setTipo(TipoProducto.PRODUCTO);
//		producto.setPrecio(5.5);
//		
//		RepositorioProducto.modificarProducto(producto);
//	}
//	
//	private static void eliminarProducto() {
//		RepositorioProducto.eliminarProducto(2);
//	}
	
	private static void consultarPersona(final Integer idPersona) {
		final Persona persona = RepositorioPersona.consultarNombreCompleto(idPersona);
		System.out.println(persona.getNombre());
		System.out.println(persona.getApellidos());
		System.out.println(persona.getEstadoCivil());
		System.out.println(persona.getEdad());
		System.out.println(persona.getDni());
		System.out.println(persona.getGenero().getCodigo());
		persona.getTelefonos().stream().forEach(telefono -> System.out.println(telefono.getNumero()));
	}

	private static void consultarPersona(String nombre, String apellidos, String dni, EstadoCivil estadoCivil) {
		final List<Persona> personas = RepositorioPersona.consultar(nombre, apellidos, dni, estadoCivil);
		
		System.out.println(personas.size());
	}
	
	private static void consultarCliente(String nombre, String apellidos, String dni, EstadoCivil estadoCivil, String login) {
		final List<Cliente> clientes = RepositorioCliente.consultarClientes(nombre, apellidos, dni, estadoCivil, login);
		
		System.out.println(clientes.size());
	}
	
	private static void agregarDireccion(Persona persona) {
		final Direccion direccion = new Direccion();
		direccion.setProvincia("Sevilla");
		direccion.setCiudad("Ecija");
		direccion.setCodigoPostal("41400");
		direccion.setCalle("Conde");
		direccion.setNumero(1);
		direccion.setBloque(1);
		direccion.setPlanta(1);
		direccion.setPuerta("Hodor");
		
		persona.addDireccion(direccion);
	}
	
	private static void agregarTelefono(Persona persona) {
		final Telefono telefono = new Telefono();
		telefono.setNumero("987456320");
		final Telefono telefono2 = new Telefono();
		telefono2.setNumero("987456321");
		final Telefono telefono3 = new Telefono();
		telefono3.setNumero("987456326");
		final Telefono telefono4 = new Telefono();
		telefono4.setNumero("987456329");
		final Telefono telefono5 = new Telefono();
		telefono5.setNumero("987456325");
		persona.addTelefono(telefono);
		persona.addTelefono(telefono2);
		persona.addTelefono(telefono3);
		persona.addTelefono(telefono4);
		persona.addTelefono(telefono5);
	}
}
