package ec.edu.uce.doctorado.jsf.entidad;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;

import ec.edu.ec.doctorado.ejb.entidad.PersonaServicio;
import ec.edu.uce.doctorado.jpa.entidad.Persona;



@ManagedBean
@RequestScoped
public class PersonaControlador {
	
	private PersonaServicio personaServicio;
	
	private List<Persona> listarP;
	
	public void listarT() {
		listarP=personaServicio.listar();
	}
}
