package es.aytos.hibernate.hibernate_dual.comparadores;

import java.util.Comparator;

import es.aytos.hibernate.hibernate_dual.modelo.Telefono;

public class ComparadorTelefonos implements Comparator<Telefono>{

//	@Override    ASCENDENTE
//	public int compare(Telefono t1, Telefono t2) {
//		return t1.getNumero().compareTo(t2.getNumero());
//	}
	
	@Override  // DESCENDENTE
	public int compare(Telefono t1, Telefono t2) {
		return t2.getNumero().compareTo(t1.getNumero());
	}
}
