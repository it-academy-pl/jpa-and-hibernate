import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.Properties;

public class Main {

    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {

        //JPA
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("JPAExamples");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx_jpa = em.getTransaction();
        tx_jpa.begin();

        Student student = new Student("nowy", "student", "email", "password");

        em.persist(student);
        student.getId();

        tx_jpa.commit();
        em.getEntityManagerFactory().close();
    }




}
