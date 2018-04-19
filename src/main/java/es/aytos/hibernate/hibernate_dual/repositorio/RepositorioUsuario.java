package es.aytos.hibernate.hibernate_dual.repositorio;

import org.hibernate.Session;

import es.aytos.hibernate.hibernate_dual.util.HibernateUtil;

public class RepositorioUsuario {

	public static void eliminarUsuario(Integer idUsuario) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.createQuery("Delete Usuario where USU_ID = :identificador").setParameter("identificador", idUsuario)
					.executeUpdate();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Se ha producido un error eliminando un usuario: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}
}
