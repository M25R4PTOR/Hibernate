package es.aytos.hibernate.hibernate_dual.modelo;

import javax.persistence.*;

@Entity
@Table(name = "A_DET")
public class DetallesPersona {

	@Id
	@GeneratedValue
	@Column(name = "DET_ID")
	private Integer idDetallesPersona;
	
	@Column(name = "DET_PRA")
	private Boolean practicaDeporte;
	
	@Column(name = "DET_TMA")
	private Boolean tieneMascota;
	
	@Column(name = "DET_THI")
	private Boolean tieneHijos;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    private Persona persona;
	
	public DetallesPersona() {
	}

	public Integer getIdDetallesPersona() {
		return idDetallesPersona;
	}

	public void setIdDetallesPersona(Integer idDetallesPersona) {
		this.idDetallesPersona = idDetallesPersona;
	}

	public Boolean getPracticaDeporte() {
		return practicaDeporte;
	}

	public void setPracticaDeporte(Boolean practicaDeporte) {
		this.practicaDeporte = practicaDeporte;
	}

	public Boolean getTieneMascota() {
		return tieneMascota;
	}

	public void setTieneMascota(Boolean tieneMascota) {
		this.tieneMascota = tieneMascota;
	}

	public Boolean getTieneHijos() {
		return tieneHijos;
	}

	public void setTieneHijos(Boolean tieneHijos) {
		this.tieneHijos = tieneHijos;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
}
