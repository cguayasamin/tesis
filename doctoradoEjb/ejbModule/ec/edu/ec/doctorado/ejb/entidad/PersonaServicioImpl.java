package ec.edu.ec.doctorado.ejb.entidad;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ec.edu.uce.doctorado.jpa.entidad.Persona;

public class PersonaServicioImpl implements PersonaServicio{

	private EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("doctoradoJpa");
	private EntityManager entityManager= entityManagerFactory.createEntityManager();
	
	@Override
	public List<Persona> listar() {
		// TODO Auto-generated method stub
		System.out.println("ingreso2");
		//System.out.print(entityManager);
		System.out.print("entrada");
		List<Persona> todo= entityManager.createNamedQuery("Persona.findAll", Persona.class)
				.getResultList();
		System.out.print(todo);
		entityManager.close();
		entityManagerFactory.close();
		return todo;
	}
	

	
	
	

	
}
