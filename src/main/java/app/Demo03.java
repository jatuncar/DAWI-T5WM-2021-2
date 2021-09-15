package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql8");
		
		EntityManager em = fabrica.createEntityManager();
		
		// -- proceso -> eliminar datos en la entidad Usuario
		Usuario u = new Usuario();
		u.setCodigo(12);
		// nombre, apellido, estado, etc
		
		em.getTransaction().begin();
		
		em.remove(u); // borra físicamente
		
		em.getTransaction().commit();
		
		System.out.println("Eliminación Ok");
		em.close();
	}
}
