package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo08 {
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql8");
		
		EntityManager em = fabrica.createEntityManager();
		
		// Forma 1: JPQL
		String sql = "select a from Usuario a where a.usuario = :xusr and a.clave = :xcla";
		TypedQuery<Usuario> query1 = em.createQuery(sql, Usuario.class);
		query1.setParameter("xusr", "U001@gmail.com");
		query1.setParameter("xcla", "10001");
		Usuario u = query1.getSingleResult();
		if (u == null) {
			System.out.println("Usuario NO existe!!");
		} else {
			System.out.println("Usuario encontrado");
			System.out.println(u);
		}
		System.out.println("-------------------------------");
		
		// Forma 2: 
		String sql2 = "{call usp_validaAcceso(?,?)}";
		Query query2 = em.createNativeQuery(sql2, Usuario.class);
		query2.setParameter("xusr", "U001@gmail.com");
		query2.setParameter("xcla", "10001");
		Usuario u2 = (Usuario) query2.getSingleResult();
		if (u2 == null) {
			System.out.println("Usuario NO existe!!");
		} else {
			System.out.println("Usuario encontrado");
			System.out.println(u2);
		}
		System.out.println("-------------------------------");
		
		em.close();
	}
}
