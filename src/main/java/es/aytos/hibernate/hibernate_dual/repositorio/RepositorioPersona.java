package es.aytos.hibernate.hibernate_dual.repositorio;

import org.hibernate.Session;

import es.aytos.hibernate.hibernate_dual.modelo.Persona;
import es.aytos.hibernate.hibernate_dual.util.HibernateUtil;

public class RepositorioPersona {

	
	public static Integer crearPersona(final Persona persona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();
		
		try {
			sesion.beginTransaction();
			
			final Integer idPersona = (Integer)sesion.save(persona);
			
			sesion.getTransaction().commit();
			
			return idPersona;
		}catch(Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			sesion.close();
		}
	}
	
	public static void modificarPersona(final Integer idPersona, final String nombre) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();
		
		try {
			sesion.beginTransaction();
			
			sesion.createQuery("Update Persona set per_nom = :nombre where per_id = :identificador").setParameter("nombre", nombre).setParameter("identificador", idPersona).executeUpdate();
			
//Línea anterior igual a las comentadas			
//			final Persona personaBBDD = (Persona) sesion.createQuery("from Persona where PER_ID = :idPersona").setParameter("idPersona", idPersona).uniqueResult();			
//			personaBBDD.setNombre(nombre);
			
			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Se ha producido u error modificando una persona: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}
	
	public static void modificarPersona2(Persona persona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();
		
		try {
			sesion.beginTransaction();
					
			sesion.saveOrUpdate(persona);
			
			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Se ha producido u error modificando una persona: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}
}
