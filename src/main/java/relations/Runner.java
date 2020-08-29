package relations;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

import static java.lang.System.out;

public class Runner {

    public static void main(String[] args) {
        EntityManagerFactory managerFactory =
                Persistence.createEntityManagerFactory("mysqlPU");
        EntityManager entityManager = managerFactory.createEntityManager();
        System.out.println("Is open: " + entityManager.isOpen());

        Post post1 = new Post();
        post1.setTitle("Java is fun");
        post1.setContent("TLTR;");
        PostDetails details1 = new PostDetails();
        details1.setRedactor("Smith");
        details1.setCreationTimestamp(new Date());
        details1.setModificationTimestamp(new Date());

        Comment comment1 = new Comment();
        comment1.setComment("Foo bar Foo bar Foo bar Foo bar Foo bar ");
        comment1.setNickName("FB");

        Comment comment2 = new Comment();
        comment2.setComment("fiu fiu fiu fif");
        comment2.setNickName("ohhh");

        Board board1 = new Board();
        board1.setBoardName("Fun");

        Board board2 = new Board();
        board2.setBoardName("Happy");



        entityManager.getTransaction().begin();
        entityManager.persist(post1);
        entityManager.persist(details1);
        entityManager.persist(board1);
        entityManager.persist(board2);
        post1.setDetails(details1);
        post1.addComment(comment1);
        post1.addComment(comment2);

        post1.addBoard(board1);
        post1.addBoard(board2);

        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        Post post = entityManager.createQuery("FROM Post p WHERE p.id=1", Post.class).getSingleResult();
//        Post post = entityManager.createQuery("FROM Post", Post.class).getResultList().get(0);
        out.println(post);
        out.println(post.getDetails());
        post.getComments().forEach(out::println);

        post.getBoards().forEach(out::println);

        entityManager.getTransaction().commit();

        entityManager.close();
        managerFactory.close();
    }
}