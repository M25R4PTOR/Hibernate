package es.aytos.hibernate.hibernate_dual.modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "A_TEL")
public class Telefono implements Serializable, Comparable<Telefono>{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mi-secuencia")
	@SequenceGenerator(name = "mi-secuencia", sequenceName = "mi_sequence_bbdd", initialValue = 25, allocationSize = 1)
	@Column(name = "TEL_ID")
	private int idTelefono;
	
	@Column(name = "TEL_NUM")
	private String numero;
	
	@ManyToOne
    private Persona persona;

	public Telefono() {
	}

	public int getIdTelefono() {
		return idTelefono;
	}

	public void setIdTelefono(int idTelefono) {
		this.idTelefono = idTelefono;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

//	@Override     ASCENDENTE
//	public int compareTo(Telefono o) {
//		return this.getNumero().compareTo(o.getNumero());
//	}
	
	@Override  // DESCENDENTE
	public int compareTo(Telefono o) {
		return o.getNumero().compareTo(this.getNumero());
	}
}
