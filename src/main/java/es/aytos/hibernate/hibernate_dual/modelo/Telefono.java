package es.aytos.hibernate.hibernate_dual.modelo;

import javax.persistence.*;

@Entity
@Table(name = "A_TEL")
public class Telefono {

	@Id
	@GeneratedValue
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
}
