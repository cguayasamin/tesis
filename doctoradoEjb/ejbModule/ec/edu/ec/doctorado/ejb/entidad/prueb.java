package ec.edu.ec.doctorado.ejb.entidad;

import java.util.List;

import ec.edu.uce.doctorado.jpa.entidad.Persona;

public class prueb {

	public prueb() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ingreso1");
		PersonaServicioImpl personaSe= new PersonaServicioImpl();
		System.out.println(personaSe);
		System.out.println("ingreso3");
		List<Persona> listar=personaSe.listar();
		System.out.print(listar);
		for (Persona persona : listar) {
			System.out.print(persona.getPrsNombres());
		}
		
	}

}
