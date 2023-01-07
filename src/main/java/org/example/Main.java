package org.example;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Web 서버가 올라가는 시점에 1개만
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        //고객의 요청이 올떄마다 실행
        EntityManager em = emf.createEntityManager();

        //Transaction 생성
        EntityTransaction tx = em.getTransaction();
        tx.begin();


        try{
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("helloA");

            // 조회
            // JPA를 통해 데이터를 가져올시 1차캐시에서 관리
            // JPA가 Transaction commit 시점에 update query 날림
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember = " + findMember.getId());
            System.out.println("findMember = " + findMember.getName());
            //


            //전체 조회
            //JPA는 class로 조회 대상이 Table이 아닌 객체
//            List<Member> findMembers = em.createQuery("select m from Member as m", Member.class)
//                    .getResultList();

            // 페이징 조회
            List<Member> findMembers = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();


            for (Member member : findMembers) {
                System.out.println("member name is " + member.getName());
            }

            //수정
            findMember.setName("hellojpa!!!!!");


            //em.persist(member);
            tx.commit();

        }
        catch (Exception e){
            tx.rollback();
        }
        finally {
            em.close();
        }
        emf.close();



    }
}