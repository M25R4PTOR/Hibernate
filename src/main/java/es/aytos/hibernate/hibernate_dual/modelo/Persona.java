package es.aytos.hibernate.hibernate_dual.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.*;

import org.hibernate.annotations.SortComparator;
import org.hibernate.annotations.SortNatural;

import es.aytos.hibernate.hibernate_dual.comparadores.ComparadorTelefonos;
import es.aytos.hibernate.hibernate_dual.conversores.ConversorGenero;

@Entity
@Table(name = "A_PER")
public class Persona extends Usuario{

	@Column(name = "PER_NOM", nullable = false, length = 50)
	private String nombre;

	@Column(name = "PER_APE", nullable = false, length = 250)
	private String apellidos;

	@Column(name = "PER_DNI", nullable = false, length = 9, unique = true)
	private String dni;

	@Column(name = "PER_EDA", nullable = false)
	private Integer edad;

	@Column(name = "PER_ECV", nullable = false)
	@Enumerated
	private EstadoCivil estadoCivil;
	
	@ManyToMany(cascade = {CascadeType.ALL})
    private List<Direccion> direcciones = new ArrayList<>();
	
	
	//@OrderBy("TEL_NUM")
	//@OrderColumn
	//@SortNatural
	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@SortComparator(ComparadorTelefonos.class)
    private SortedSet<Telefono> telefonos = new TreeSet<>();
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Aficion>  aficiones = new ArrayList<>();
	
	@Column(name = "PER_GEN", nullable = false, length = 1)
	@Convert(converter = ConversorGenero.class)
	private Genero genero;
	
	public Persona() {
	}

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
	

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void addDireccion(Direccion direccion) {
        direcciones.add(direccion);
        direccion.getPersonas().add( this );
    }

    public void removeDireccion(Direccion direccion) {
    	direcciones.remove(direccion);
        direccion.getPersonas().remove( this );
    }
    
    public Set<Telefono> getTelefonos() {
        return telefonos;
    }

    public void addTelefono(Telefono telefono) {
    	telefonos.add(telefono);
    	telefono.setPersona(this);
    }

    public void removeTelefono(Telefono telefono) {
    	telefonos.remove(telefono);
    	telefono.setPersona(null);
    }

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
}
