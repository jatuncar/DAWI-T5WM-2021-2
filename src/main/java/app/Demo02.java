package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql8");
		
		EntityManager em = fabrica.createEntityManager();
		
		// -- proceso -> actualizar datos en la entidad Usuario
		Usuario u = new Usuario();
		u.setCodigo(100);
		u.setNombre("Prosor");
		u.setApellido("Apellido");
		u.setUsuario("profe100@mail.com");
		u.setClave("456");
		u.setFnacim("2020/08/24");
		u.setTipo(1);
		u.setEstado(1);
		
		em.getTransaction().begin();
		
		em.merge(u); // actualiza -> si existe el código /si no existe lo crea
		
		em.getTransaction().commit();
		
		em.close();
	}
}
