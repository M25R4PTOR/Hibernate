package es.aytos.hibernate.hibernate_dual.pruebas;

import es.aytos.hibernate.hibernate_dual.modelo.EstadoCivil;
import es.aytos.hibernate.hibernate_dual.modelo.Persona;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioPersona;

public class Pruebas {

	public static void main(String[] args) {
		System.out.println(crearPersona());
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
}
