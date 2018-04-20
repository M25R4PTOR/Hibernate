package es.aytos.hibernate.hibernate_dual.pruebas;

import java.util.List;

import es.aytos.hibernate.hibernate_dual.modelo.Aficion;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioAficion;

public class PruebasCache {

	public static void main(String[] args) {
		consultarAficiones();
		consultarAficiones();
	}
	
	private static void consultarAficiones() {
		final List<Aficion> aficiones = RepositorioAficion.consultarAficiones();
		
		aficiones.stream().map(Aficion::getNombre).forEach(System.out::println);
	}
}
