package es.aytos.hibernate.hibernate_dual.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "A_AFI")
public class Aficion {

	@Id
	@GeneratedValue
	@Column(name = "AFI_ID")
	private Integer idAficiones;
	
	@Column(name = "AFI_NOM")
	private String nombre;
	
	@ManyToMany(mappedBy = "aficiones")
    private List<Persona> personas = new ArrayList<>();
	
	public Aficion() {
	}

	public Integer getIdAficiones() {
		return idAficiones;
	}

	public void setIdAficiones(Integer idAficiones) {
		this.idAficiones = idAficiones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
}
