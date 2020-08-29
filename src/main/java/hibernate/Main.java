package hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.Instant;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello in ORM world");

        EntityManagerFactory managerFactory =
                Persistence.createEntityManagerFactory("mysqlPU");
        EntityManager entityManager = managerFactory.createEntityManager();
        System.out.println("Is open: " + entityManager.isOpen());

        ORMTypes t1 = new ORMTypes();
        t1.setAnInt(100);
        t1.setaDouble(99.99);
        t1.setaFloat(10.09f);
        t1.setaShort((short) 122);
        t1.setString("Hello t1");
        t1.setPoryRoku(PoryRoku.LATO);

        ORMTypes t2 = new ORMTypes();
        t2.setIntArray(new int[]{1, 2, 3, 5, 6, 7, 8});
        t2.setDate(Date.from(Instant.now()));
        t2.setTimestamp(Date.from(Instant.now()));
        t2.setTime(Date.from(Instant.now()));
        t2.setPassword("Zimna wiosna");


        entityManager.getTransaction().begin();
        entityManager.persist(t1);
        entityManager.persist(t2);
        entityManager.getTransaction().commit();

        entityManager.close();
        managerFactory.close();
    }
}