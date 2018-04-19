package es.aytos.hibernate.hibernate_dual.repositorio;

import java.util.List;

import org.hibernate.Session;

import es.aytos.hibernate.hibernate_dual.modelo.Cliente;
import es.aytos.hibernate.hibernate_dual.modelo.EstadoCivil;
import es.aytos.hibernate.hibernate_dual.modelo.Persona;
import es.aytos.hibernate.hibernate_dual.modelo.Usuario;
import es.aytos.hibernate.hibernate_dual.util.HibernateUtil;

public class RepositorioCliente {

	public static Integer crearCliente(final Cliente cliente) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			final Integer idCliente = (Integer) sesion.save(cliente);

			sesion.getTransaction().commit();

			return idCliente;
		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando el cliente: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}
	
	public static void modificarCliente(Cliente cliente) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.saveOrUpdate(cliente);

			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Se ha producido un error modificando el cliente: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}
	
	public static List<Cliente> consultarClientes(String nombre, String apellidos, String dni, EstadoCivil estadoCivil, String login) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();
		try {
			sesion.beginTransaction();
			
			final StringBuilder sb = new StringBuilder("from Cliente Where 1=1");
			
			if (!nombre.isEmpty()) {
				sb.append(" and CLI_NOM in (select nombre from Cliente where CLI_NOM like :nombre)");
			}
			if (!apellidos.isEmpty()) {
				sb.append(" and CLI_APE like :apellidos");
			}
			if (!dni.isEmpty()) {
				sb.append(" and CLI_DNI = :dni");
			}
			if (estadoCivil!=null) {
				sb.append(" and CLI_ECV = :estadoCivil");
			}
			if (!login.isEmpty()) {
				sb.append(" and USU_LOG = :login");
			}
			
			final org.hibernate.query.Query<Cliente> consulta = sesion.createQuery(sb.toString());
			
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
			if (!login.isEmpty()) {
				consulta.setParameter("login", login);
			}
			return consulta.list();
		} catch (Exception e) {
			System.out.println("Se ha producido un error con la consulta: " + e.getMessage());
			sesion.getTransaction();
			throw new RuntimeException(e);
		} finally {
			sesion.close();
		}
	}
}
