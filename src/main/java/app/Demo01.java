package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql8");
		
		EntityManager em = fabrica.createEntityManager();
		
		// -- proceso -> grabar datos en la entidad Usuario
		Usuario u = new Usuario();
		u.setCodigo(124);
		u.setNombre("José");
		u.setApellido("Apellido");
		u.setUsuario("profe124@mail.com");
		u.setClave("1234");
		u.setFnacim("2020/08/24");
		u.setTipo(1);
		u.setEstado(1);
		
		em.getTransaction().begin();
		
		em.persist(u);
		
		em.getTransaction().commit();
		
		em.close();
	}
	
}
