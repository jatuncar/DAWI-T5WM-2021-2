package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;
import model.Usuario;

public class Prod01 {
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql8");
		
		EntityManager em = fabrica.createEntityManager();
		
		// -- proceso -> grabar datos en la entidad Usuario
		Producto p = new Producto();
		p.setIdprod("P0050");
		p.setDescripcion("Prueba50");
		p.setStock(500);
		p.setPrecio(0.99);
		p.setIdcategoria(1);
		p.setEstado(1);
		
		em.getTransaction().begin();
		
		em.persist(p);
		
		em.getTransaction().commit();
		
		em.close();
	}
	
}
