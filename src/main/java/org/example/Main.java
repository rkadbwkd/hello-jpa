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

            //비영속 상태
            Member member = new Member();
            member.setId(100L);
            member.setName("Hello?Jpa");

            //영속
            System.out.println("===Before===");
            em.persist(member);
            System.out.println("===After===");

            //회원 엔티티를 영속성 컨텍스트에서 분리 , 준영속 상태
            //em.detach(member);

            //객체를 상제한 상태
            //em.remove(member);
            // 영속성 Context에 SQL 쓰기 지연 저장소에 있는 쿼리가 전송
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