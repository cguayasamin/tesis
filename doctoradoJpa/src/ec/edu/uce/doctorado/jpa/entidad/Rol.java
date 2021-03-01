package ec.edu.uce.doctorado.jpa.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
@Table(name = "rol")
@NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rol_id")
	private int rolId;

	@Column(name = "rol_descripcion")
	private String rolDescripcion;

	@Column(name = "rol_tipo")
	private Integer rolTipo;

	@Column(name = "rol_nivel_acceso")
	private Integer rolNivelAcceso;
	
	@Column(name = "rol_detalle")
	private String rolDetalle;
	
	// bi-directional many-to-one association to UsuarioRol
	@OneToMany(mappedBy = "usroRol")
	private List<UsuarioRol> rolListUsuarioRol;

	public Rol() {
	}

	public Rol(int rolId) {
		super();
		this.rolId = rolId;
	}

	public int getRolId() {
		return this.rolId;
	}

	public void setRolId(int rolId) {
		this.rolId = rolId;
	}

	public String getRolDescripcion() {
		return this.rolDescripcion;
	}

	public void setRolDescripcion(String rolDescripcion) {
		this.rolDescripcion = rolDescripcion;
	}

	public Integer getRolTipo() {
		return this.rolTipo;
	}

	public void setRolTipo(Integer rolTipo) {
		this.rolTipo = rolTipo;
	}

	public Integer getRolNivelAcceso() {
		return rolNivelAcceso;
	}

	public void setRolNivelAcceso(Integer rolNivelAcceso) {
		this.rolNivelAcceso = rolNivelAcceso;
	}

	public String getRolDetalle() {
		return rolDetalle;
	}

	public void setRolDetalle(String rolDetalle) {
		this.rolDetalle = rolDetalle;
	}

	public List<UsuarioRol> getRolListUsuarioRol() {
		return this.rolListUsuarioRol;
	}

	public void setRolListUsuarioRol(List<UsuarioRol> rolListUsuarioRol) {
		this.rolListUsuarioRol = rolListUsuarioRol;
	}

	public UsuarioRol addRolListUsuarioRol(UsuarioRol rolListUsuarioRol) {
		getRolListUsuarioRol().add(rolListUsuarioRol);
		rolListUsuarioRol.setUsroRol(this);

		return rolListUsuarioRol;
	}

	public UsuarioRol removeRolListUsuarioRol(UsuarioRol rolListUsuarioRol) {
		getRolListUsuarioRol().remove(rolListUsuarioRol);
		rolListUsuarioRol.setUsroRol(null);

		return rolListUsuarioRol;
	}

}