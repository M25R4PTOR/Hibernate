package es.aytos.hibernate.hibernate_dual.pruebas;

import java.util.Date;

import es.aytos.hibernate.hibernate_dual.modelo.EstadoCivil;
import es.aytos.hibernate.hibernate_dual.modelo.Persona;
import es.aytos.hibernate.hibernate_dual.modelo.Producto;
import es.aytos.hibernate.hibernate_dual.modelo.TipoProducto;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioPersona;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioProducto;

public class Pruebas {

	public static void main(String[] args) {
//		System.out.println(crearPersona());
//		System.out.println(crearProducto());
		modificarPersona2();
	}
	
	private static Integer crearPersona() {
		final Persona persona = new Persona();
		persona.setNombre("Manuel Jesús");
		persona.setApellidos("Martín Prieto");
		persona.setEdad(24);
		persona.setEstadoCivil(EstadoCivil.SOLTERO);
		persona.setDni("12345678X");
		
		
		return RepositorioPersona.crearPersona(persona);
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
	
	private static void modificarPersona() {
		RepositorioPersona.modificarPersona(1, "Nadie");
	}
	
	private static void modificarPersona2() {
		Persona persona = new Persona();
		persona.setIdPersona(8);
		persona.setNombre("Manuel Jesús2");
		persona.setApellidos("Martín Prieto2");
		persona.setEdad(25);
		persona.setEstadoCivil(EstadoCivil.CASADO);
		persona.setDni("02345678X");
		
		RepositorioPersona.modificarPersona2(persona);
	}
}
