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
			System.out.println("Se ha producido un error insertando el producto: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			sesion.close();
		}
	}
	
	public static void modificarProducto(Producto producto) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();
		
		try {
			sesion.beginTransaction();
					
			sesion.saveOrUpdate(producto);
			
			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Se ha producido un error modificando un producto: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}
	
	public static void eliminarProducto(Integer idProducto) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();
		
		try {
			sesion.beginTransaction();
					
			sesion.createQuery("Delete Producto where pro_id = :identificador").setParameter("identificador", idProducto).executeUpdate();
			
			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Se ha producido un error eliminando un producto: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}
}

