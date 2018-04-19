package es.aytos.hibernate.hibernate_dual.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Entity
//@Table(name = "A_PER")
public class Persona2 extends Usuario{

//	@Id
//	@GeneratedValue
//	@Column(name = "PER_ID")
//	private int idPersona;

	//@Column(name = "PER_NOM", nullable = false, length = 50)
	@Column(name = "PER_NOM2", length = 50)
	private String nombre;

	//@Column(name = "PER_APE", nullable = false, length = 250)
	@Column(name = "PER_APE2", length = 250)
	private String apellidos;

	//@Column(name = "PER_DNI", nullable = false, length = 9, unique = true)
	@Column(name = "PER_DNI2", length = 9, unique = true)
	private String dni;

	//@Column(name = "PER_EDA", nullable = false)
	@Column(name = "PER_EDA2")
	private Integer edad;

	//@Column(name = "PER_ECV", nullable = false)
	@Column(name = "PER_ECV2")
	@Enumerated
	private EstadoCivil estadoCivil;
	
	public Persona2() {
	}

//	public int getIdPersona() {
//		return idPersona;
//	}
//
//	public void setIdPersona(int idPersona) {
//		this.idPersona = idPersona;
//	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	
}
