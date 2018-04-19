package es.aytos.hibernate.hibernate_dual.repositorio;

import java.util.List;

import org.hibernate.Session;

import es.aytos.hibernate.hibernate_dual.modelo.EstadoCivil;
import es.aytos.hibernate.hibernate_dual.modelo.Persona;
import es.aytos.hibernate.hibernate_dual.modelo.Persona2;
import es.aytos.hibernate.hibernate_dual.util.HibernateUtil;

public class RepositorioPersona {

	public static Integer crearPersona(final Persona persona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			final Integer idPersona = (Integer) sesion.save(persona);

			sesion.getTransaction().commit();

			return idPersona;
		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}
	
	public static Integer crearPersona2(final Persona2 persona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			final Integer idPersona = (Integer) sesion.save(persona);

			sesion.getTransaction().commit();

			return idPersona;
		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void modificarPersona(final Integer idPersona, final String nombre) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.createQuery("Update Persona set per_nom = :nombre where per_id = :identificador")
					.setParameter("nombre", nombre).setParameter("identificador", idPersona).executeUpdate();

			// Línea anterior igual a las comentadas
			// final Persona personaBBDD = (Persona) sesion.createQuery("from Persona where
			// PER_ID = :idPersona").setParameter("idPersona", idPersona).uniqueResult();
			// personaBBDD.setNombre(nombre);

			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Se ha producido un error modificando una persona: " + e.getMessage());
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
			System.out.println("Se ha producido un error modificando una persona: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void eliminarPersona(Integer idPersona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.createQuery("Delete Persona where per_id = :identificador").setParameter("identificador", idPersona)
					.executeUpdate();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Se ha producido un error eliminando una persona: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void eliminarPersona2(Persona persona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			final Persona personaBBDD = (Persona) sesion.createQuery("from Persona where PER_ID = :identificador")
					.setParameter("identificador", persona.getIdPersona()).uniqueResult();

			sesion.delete(personaBBDD);

			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Se ha producido un error eliminando una persona: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static Persona consultarNombreCompleto(Integer idPersona) {
		final Session sesion = HibernateUtil.construirSessionFactory().getCurrentSession();
		try {
			sesion.beginTransaction();
			return (Persona) sesion.createQuery("from Persona where per_id = :idPersona")
					.setParameter("idPersona", idPersona).uniqueResult();
		} catch (Exception e) {
			System.out.println("Se ha prducido un error con la consulta: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			sesion.close();
		}
	}

	public static List<Persona> consultar(String nombre, String apellidos, String dni, EstadoCivil estadoCivil) {
		final Session sesion = HibernateUtil.construirSessionFactory().getCurrentSession();
		try {
			sesion.beginTransaction();
			
			final StringBuilder sb = new StringBuilder("from Persona Where 1=1");
			
			if (!nombre.isEmpty()) {
				sb.append(" and PER_NOM in (select nombre from Persona where PER_NOM like :nombre)");
			}
			if (!apellidos.isEmpty()) {
				sb.append(" and PER_APE like :apellidos");
			}
			if (!dni.isEmpty()) {
				sb.append(" and PER_DNI = :dni");
			}
			if (estadoCivil!=null) {
				sb.append(" and PER_ECV = :estadoCivil");
			}
			
			final org.hibernate.query.Query<Persona> consulta = sesion.createQuery(sb.toString());
			
			if (!nombre.isEmpty()) {
				consulta.setParameter("nombre", nombre);
			}
			if (!apellidos.isEmpty()) {
				consulta.setParameter("apellidos", apellidos);
			}
			if (!dni.isEmpty()) {
				consulta.setParameter("dni", dni);
			}
			if (estadoCivil!=null) {
				consulta.setParameter("estadoCivil", estadoCivil.ordinal());
			}
			return consulta.list();
		} catch (Exception e) {
			System.out.println("Se ha prducido un error con la consulta: " + e.getMessage());
			sesion.getTransaction();
			throw new RuntimeException(e);
		} finally {
			sesion.close();
		}
	}
}
