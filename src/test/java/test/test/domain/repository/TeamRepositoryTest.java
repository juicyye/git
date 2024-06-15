package test.test.domain.repository;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import test.test.domain.entity.Member;
import test.test.domain.entity.Team;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class TeamRepositoryTest {

    @Autowired
    EntityManager em;

    @Test
    public void contextLoads() {

        Team team = new Team();
        team.setName("teamA");
        em.persist(team);

        Member member1 = new Member();
        member1.setUsername("m1");
        member1.setTeam(team);
        em.persist(member1);

        Member member2 = new Member();
        member2.setUsername("m2");
        member2.setTeam(team);
        em.persist(member2);

        em.flush();
        em.clear();

        List<Team> result = em.createQuery("select t from Team t join fetch t.members m where m.username = 'm1'", Team.class)
                .getResultList();

        for (Team team1 : result) {
            System.out.println("team1 = " + team1.getName());
            List<Member> members = team1.getMembers();
            for (Member member : members) {
                System.out.println("member = " + member.getUsername());
            }
        }
        List<Team> resultList = em.createQuery("select t from Team t join fetch t.members", Team.class)
                .getResultList();
        for (Team team1 : resultList) {
            System.out.println("team1 = " + team1);
            List<Member> members = team1.getMembers();
            for (Member member : members) {
                System.out.println("member = " + member);
            }
        }

    }

}