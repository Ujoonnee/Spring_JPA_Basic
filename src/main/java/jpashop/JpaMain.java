package jpashop;

import hellojpa.Member;
import hellojpa.Team;
import jpashop.domain.Order;
import jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class  JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Order order = new Order();
            em.persist(order);

            OrderItem orderItem = new OrderItem();
            em.persist(orderItem);

            order.addOrderItem(orderItem);


            tx.commit();

        } catch (Exception e) {
            tx.rollback();

        } finally {
            em.close();
        }

        emf.close();

    }
}
