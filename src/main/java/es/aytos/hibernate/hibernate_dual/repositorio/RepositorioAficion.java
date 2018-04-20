package es.aytos.hibernate.hibernate_dual.repositorio;

import java.util.List;

import org.hibernate.Session;

import es.aytos.hibernate.hibernate_dual.modelo.Aficion;
import es.aytos.hibernate.hibernate_dual.util.HibernateUtil;

public class RepositorioAficion {

	
	public static List<Aficion> consultarAficiones() {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();
		try {
			sesion.beginTransaction();
			
			List<Aficion> aficiones = (List<Aficion>) sesion.createQuery("from Aficion").setCacheable(true).list();
			
			return aficiones;
			
		} catch (Exception e) {
			System.out.println("Se ha producido un error con la consulta: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			sesion.close();
		}
	}
}
