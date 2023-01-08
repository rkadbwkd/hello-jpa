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

//            //비영속 상태
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("Hello?Jpa");
//
//            //영속
//            System.out.println("===Before===");
//            em.persist(member);
//            System.out.println("===After===");

//            Member findMember1 = em.find(Member.class, 101L);
 //           Member findMember2 = em.find(Member.class, 101L);

//            System.out.println("result = " + (findMember1 == findMember2));

//            System.out.println("findMember.id = " + findMember.getId() );
//            System.out.println("findMember.name = " + findMember.getName());

              //Member member1 = new Member(150L, "A");
              //Member member2 = new Member(160L, "B");

              //em.persist(member1);
              //em.persist(member2);
              //System.out.println("===================================");

            Member member = em.find(Member.class, 150L);
            member.setName("Zzzzzzzzz");


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