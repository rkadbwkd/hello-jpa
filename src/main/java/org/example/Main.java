package org.example;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.example.domain.Member;
//import org.example.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Web 서버가 올라가는 시점에 1개만 (persistence.xml의 유닛네임)
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        //고객의 요청이 올떄마다 실행
        EntityManager em = emf.createEntityManager();

        //Transaction 생성
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

//            Member member1 = new Member(150L,"A");
//            Member member2 = new Member(160L,"B");
//
//            em.persist(member1);
//            em.persist(member2);

            Member member = em.find(Member.class, 150L);
            member.setName("지화니니니");

            System.out.println("=============");

            //Member findMember1 = em.find(Member.class, 1L);
            //Member findMember2 = em.find(Member.class, 1L);

            //System.out.println("result : " + (findMember1 == findMember2));
            //System.out.println("findMember id " + findMember.getId());
            //System.out.println("findMember name " + findMember.getName());
            /*조회
            Member findMember = em.find(Member.class, 1L);
            System.out.println(findMember.getId());
            System.out.println(findMember.getName());
            */
            /*삭제*/
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HELLO JPA"); // em.persist 사용 X
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .getResultList();
//
//            for(Member member : result){
//                System.out.println(member.getName());
//            }

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();

        }

        emf.close();






    }
}