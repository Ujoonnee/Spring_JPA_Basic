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
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeam(team);
//            em.persist(member);
//
//            // 1차 캐시가 아닌 DB에서 조회하는 쿼리를 보고 싶다면
//            em.flush();
//            em.clear();
//
//            Member findMember = em.find(Member.class, member.getId());
//            List<Member> members = findMember.getTeam().getMembers();
//
            Team team = new Team();
            team.setName("team성준");
            em.persist(team);

            Member member1 = new Member();
            member1.setUsername("람성준");
            member1.setTeam(team);
            em.persist(member1);

            em.flush();
            em.clear();

            team = em.find(Team.class, team.getId());
            List<Member> members = team.getMembers();
            System.out.println("++++++++++++++++++++++++++++++");
            for (Member m : members) {
                System.out.println("m.getUsername() = " + m.getUsername());
            }
            System.out.println("++++++++++++++++++++++++++++++");

            Member member2 = new Member();
            em.persist(member2);

//            member2.addMemberToTeam(team);

            members.add(member2);

            tx.commit();

        } catch (Exception e) {
            tx.rollback();

        } finally {
            em.close();
        }

        emf.close();

    }
}
