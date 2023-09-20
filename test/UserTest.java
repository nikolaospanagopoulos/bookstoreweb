import com.bookstore.entities.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserTest {

    public static void main(String[] args) {
        User user1 = new User();
        user1.setFullName("nmisqfd");
        user1.setPassword("12345");
        user1.setEmail("efgr@rerger.gr");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(user1);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        System.out.println("Added successfully");

    }

}
