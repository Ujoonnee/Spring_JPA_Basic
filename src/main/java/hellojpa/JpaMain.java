package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 영속
            Member member = em.find(Member.class, 1L);      // 1차 캐시에 없으므로 DB에서 SELECT
            member.setName("memberDetached");                   // em.clear()에 의해 UPDATE 쿼리를 생성하지 않음

            em.clear();                                         // 영속성 컨텍스트 초기화

            Member member1 = em.find(Member.class, 1L);     // 초기화에 의해 1차 캐시에 없으므로 다시 DB에서 SELECT
            member1.setName("memberAAA");                       // flush 시점에 UPDATE 쿼리 생성

            tx.commit();                                        // commit 전 자동으로 flush

        } catch (Exception e) {
            tx.rollback();

        } finally {
            em.close();
        }

        emf.close();

    }
}
