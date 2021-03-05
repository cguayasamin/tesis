package ec.edu.uce.doctorado.jpa.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@Table(name = "persona")
@NamedQueries({ 
		@NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
		@NamedQuery(name = "Persona.findByIdentificacion", query = "SELECT p FROM Persona p WHERE p.prsIdentificacion = :identificacion"),
		@NamedQuery(name = "Persona.findByPersonaId", query = "SELECT p FROM Persona p WHERE p.prsId = :prsId")
		})
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prs_id")
	private int prsId;

	@Column(name = "prs_mail_personal")
	private String prsMailPersonal;

	@Column(name = "prs_mail_institucional")
	private String prsMailInstitucional;

	@Temporal(TemporalType.DATE)
	@Column(name = "prs_fecha_nacimiento")
	private Date prsFechaNacimiento;

	@Column(name = "prs_identificacion")
	private String prsIdentificacion;
	
	@Column(name = "PRS_TIPO_IDENTIFICACION_SNESE")
	private Integer prsIdentificacionSnese;

	@Column(name = "prs_nombres")
	private String prsNombres;

	@Column(name = "prs_primer_apellido")
	private String prsPrimerApellido;

	@Column(name = "prs_segundo_apellido")
	private String prsSegundoApellido;

	@Column(name = "prs_telefono")
	private String prsTelefono;

	@Column(name = "prs_tipo_identificacion")
	private Integer prsTipoIdentificacion;

	@Column(name = "prs_sexo")
	private Integer prsSexo;

	@Column(name = "PRS_SEXO_SNESE")
	private Integer prsSexoSnese;


	// bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy = "usrPersona")
	private List<Usuario> prsListUsuario;


	public Persona() {
	}

	public Persona(int prsId) {
		super();
		this.prsId = prsId;
	}

	public int getPrsId() {
		return this.prsId;
	}

	public void setPrsId(int prsId) {
		this.prsId = prsId;
	}

	
	public Date getPrsFechaNacimiento() {
		return this.prsFechaNacimiento;
	}

	public void setPrsFechaNacimiento(Date prsFechaNacimiento) {
		this.prsFechaNacimiento = prsFechaNacimiento;
	}

	public String getPrsIdentificacion() {
		return this.prsIdentificacion;
	}

	public void setPrsIdentificacion(String prsIdentificacion) {
		this.prsIdentificacion = prsIdentificacion;
	}

	public String getPrsNombres() {
		return this.prsNombres;
	}

	public void setPrsNombres(String prsNombres) {
		this.prsNombres = prsNombres;
	}

	public String getPrsPrimerApellido() {
		return this.prsPrimerApellido;
	}

	public void setPrsPrimerApellido(String prsPrimerApellido) {
		this.prsPrimerApellido = prsPrimerApellido;
	}

	public String getPrsSegundoApellido() {
		return this.prsSegundoApellido;
	}

	public void setPrsSegundoApellido(String prsSegundoApellido) {
		this.prsSegundoApellido = prsSegundoApellido;
	}

	public String getPrsTelefono() {
		return this.prsTelefono;
	}

	public void setPrsTelefono(String prsTelefono) {
		this.prsTelefono = prsTelefono;
	}

	
	public Integer getPrsTipoIdentificacion() {
		return this.prsTipoIdentificacion;
	}

	public void setPrsTipoIdentificacion(Integer prsTipoIdentificacion) {
		this.prsTipoIdentificacion = prsTipoIdentificacion;
	}

	
	public Integer getPrsSexo() {
		return prsSexo;
	}

	public void setPrsSexo(Integer prsSexo) {
		this.prsSexo = prsSexo;
	}

	public String getPrsMailPersonal() {
		return prsMailPersonal;
	}

	public void setPrsMailPersonal(String prsMailPersonal) {
		this.prsMailPersonal = prsMailPersonal;
	}

	public String getPrsMailInstitucional() {
		return prsMailInstitucional;
	}

	public void setPrsMailInstitucional(String prsMailInstitucional) {
		this.prsMailInstitucional = prsMailInstitucional;
	}

	public Integer getPrsIdentificacionSnese() {
		return prsIdentificacionSnese;
	}

	public void setPrsIdentificacionSnese(Integer prsIdentificacionSnese) {
		this.prsIdentificacionSnese = prsIdentificacionSnese;
	}

	public Integer getPrsSexoSnese() {
		return prsSexoSnese;
	}

	public void setPrsSexoSnese(Integer prsSexoSnese) {
		this.prsSexoSnese = prsSexoSnese;
	}

	public List<Usuario> getPrsListUsuario() {
		return this.prsListUsuario;
	}

	public void setPrsListUsuario(List<Usuario> prsListUsuario) {
		this.prsListUsuario = prsListUsuario;
	}

	public Usuario addPrsListUsuario(Usuario prsListUsuario) {
		getPrsListUsuario().add(prsListUsuario);
		prsListUsuario.setUsrPersona(this);

		return prsListUsuario;
	}

	public Usuario removePrsListUsuario(Usuario prsListUsuario) {
		getPrsListUsuario().remove(prsListUsuario);
		prsListUsuario.setUsrPersona(null);

		return prsListUsuario;
	}

	

}