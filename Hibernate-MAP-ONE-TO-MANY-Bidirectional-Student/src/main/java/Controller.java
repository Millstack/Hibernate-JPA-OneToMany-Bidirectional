import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Controller {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("milind");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		List<Course> c = new ArrayList();
		
		Student s1 = new Student();
		s1.setName("Milind");
		s1.setRol_no("46");
		
		Course c1 = new Course();
		c1.setName("Java Ful stack");
		c1.setDuration("4mn");
		c1.setPrice(31000);
		c1.setStudent(s1);
		
		Course c2 = new Course();
		c2.setName("Web Developer");
		c2.setDuration("2mn");
		c2.setPrice(389);
		c2.setStudent(s1);
		
		Course c3 = new Course();
		c3.setName("React.js");
		c3.setDuration("1mn");
		c3.setPrice(389);
		c3.setStudent(s1);
		
		c.add(c1);		
		c.add(c2);		
		c.add(c3);
		
		s1.setCourse(c);
		
		entityTransaction.begin();
		entityManager.persist(s1);
		entityManager.persist(c1);
		entityManager.persist(c2);
		entityManager.persist(c3);
		entityTransaction.commit();
	}
}