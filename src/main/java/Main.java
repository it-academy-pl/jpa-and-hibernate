import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("JPAExamples");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
/*
        Student student = new Student("name", "surname", "email", "password");
        em.persist(student);
*/
        //JPQL queries
/*        Query query = em.createQuery("select s from STUDENTS s");
        List<Student> students = query.getResultList();
        //query.setParameter("email", "kowalski@onet.pl");
        System.out.println(students.toString());
        System.out.println("-----------");*/


        //Criteria query
/*        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
        Root<Student> root = criteria.from(Student.class);
        criteria.where(builder.equal(root.get("email"), "123@a.pl"));
        Query q = em.createQuery(criteria);
        Student student = (Student) q.getSingleResult();
        System.out.println(student);*/

        tx.commit();
        em.close();
        emf.close();

    }
}
