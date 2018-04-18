package es.aytos.hibernate.hibernate_dual.repositorio;

import org.hibernate.Session;

import es.aytos.hibernate.hibernate_dual.modelo.Producto;
import es.aytos.hibernate.hibernate_dual.util.HibernateUtil;

public class RepositorioProducto {

	
	public static Integer crearProducto(final Producto producto) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();
		
		try {
			sesion.beginTransaction();
			
			final Integer idProducto = (Integer)sesion.save(producto);
			
			sesion.getTransaction().commit();
			
			return idProducto;
		}catch(Exception e) {
			System.out.println("Se ha producido un error insertando la poducto: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			sesion.close();
		}
	}
}

