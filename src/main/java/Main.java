import domain.Student;
import domain.Tutor;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.*;

public class Main {

    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {

        //JPA
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("JPAExamples");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx_jpa = em.getTransaction();
        tx_jpa.begin();

        Tutor tutor = em.find(Tutor.class, 1L);
        List<Student> students = tutor.getStudents();
        System.out.println(tutor);

        for(Student student : students) {
            System.out.println(student);
        }

        System.out.println("---------------");

        Student student = em.find(Student.class, 2L);
        Tutor tutor1 = student.getTutor();
        System.out.println("---tutor for student 2---" + tutor1);
        tx_jpa.commit();
        em.getEntityManagerFactory().close();
    }




}
