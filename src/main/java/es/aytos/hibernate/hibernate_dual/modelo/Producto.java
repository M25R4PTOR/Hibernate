package es.aytos.hibernate.hibernate_dual.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "A_PRO")
public class Producto implements Serializable{

	@Id
	@GeneratedValue
	@Column(name = "PRO_ID")
	private int idProducto;
	
	@Column(name = "PRO_NOM", nullable = false, length = 50)
	private String nombre;
	
	@Column(name = "PRO_DES", nullable = false, length = 500)
	private String descripcion;
	
	@Column(name = "PRO_CAD", nullable = true)
	private Date caducidad;
	
	@Column(name = "PRO_TIP", nullable = false)
	@Enumerated
	private TipoProducto tipo;
	
	@Column(name = "PRO_PRE", nullable = false)
	private Double precio;
	
	public Producto() {
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(Date caducidad) {
		this.caducidad = caducidad;
	}

	public TipoProducto getTipo() {
		return tipo;
	}

	public void setTipo(TipoProducto tipo) {
		this.tipo = tipo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
}
