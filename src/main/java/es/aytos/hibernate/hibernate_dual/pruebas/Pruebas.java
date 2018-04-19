package es.aytos.hibernate.hibernate_dual.pruebas;

import java.util.Date;

import es.aytos.hibernate.hibernate_dual.modelo.EstadoCivil;
import es.aytos.hibernate.hibernate_dual.modelo.Persona;
import es.aytos.hibernate.hibernate_dual.modelo.Persona2;
import es.aytos.hibernate.hibernate_dual.modelo.Producto;
import es.aytos.hibernate.hibernate_dual.modelo.TipoProducto;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioPersona;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioProducto;

public class Pruebas {

	public static void main(String[] args) {
		crearPersona("00000000A", "jaa");
		crearPersona2("11111111A", "jaa2");
		crearPersona("99999999Z", "aaa");
		crearPersona2("88888888Z", "aaa2");
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
		
		
		return RepositorioPersona.crearPersona(persona);
	}
	
	private static Integer crearPersona2(String dni, String login) {
		final Persona2 persona = new Persona2();
		persona.setNombre("Manuel Jesús");
		persona.setApellidos("Martín Prieto");
		persona.setEdad(24);
		persona.setEstadoCivil(EstadoCivil.SOLTERO);
		persona.setDni(dni);
		persona.setFechaAlta(new Date());
		persona.setLogin(login);
		persona.setPassword("jaa");
		
		
		return RepositorioPersona.crearPersona2(persona);
	}
	
	private static void modificarPersona() {
		RepositorioPersona.modificarPersona(1, "Nadie");
	}
	
	private static void modificarPersona2() {
		Persona persona = new Persona();
//		persona.setIdPersona(1);
		persona.setNombre("Manuel Jesús2");
		persona.setApellidos("Martín Prieto2");
		persona.setEdad(25);
		persona.setEstadoCivil(EstadoCivil.CASADO);
		persona.setDni("02345678X");
		
		RepositorioPersona.modificarPersona2(persona);
	}
	
	private static void eliminarPersona() {
		RepositorioPersona.eliminarPersona(1);
	}
	
	private static void eliminarPersona2() {
		Persona persona = new Persona();
//		persona.setIdPersona(3);
		
		RepositorioPersona.eliminarPersona2(persona);
	}
	
	private static Integer crearProducto() {
		final Producto producto = new Producto();
		producto.setNombre("Algo");
		producto.setDescripcion("Puede que funcione");
		producto.setCaducidad(new Date());
		producto.setTipo(TipoProducto.PRODUCTO);
		producto.setPrecio(5.5);
		
		return RepositorioProducto.crearProducto(producto);
	}
	
	private static void modificarProducto() {
		Producto producto = new Producto();
		producto.setIdProducto(1);
		producto.setNombre("Algo 2.0");
		producto.setDescripcion("Puede que funcione");
		producto.setCaducidad(new Date());
		producto.setTipo(TipoProducto.PRODUCTO);
		producto.setPrecio(5.5);
		
		RepositorioProducto.modificarProducto(producto);
	}
	
	private static void eliminarProducto() {
		RepositorioProducto.eliminarProducto(2);
	}
}
