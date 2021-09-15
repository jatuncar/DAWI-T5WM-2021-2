package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04 {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql8");
		
		EntityManager em = fabrica.createEntityManager();
		
		// -- proceso -> busca la info del usuario con c�digo 12
		
		Usuario u = em.find(Usuario.class, 12);

		if (u == null) {
			System.out.println("Usuario NO existe!!");
		} else {
			System.out.println("Usuario encontrado");
			System.out.println(u);
		}
		
		em.close();
	}
}
