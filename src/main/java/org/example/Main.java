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

            // 조회시 영속성 Context에 올림
            Member member = em.find(Member.class, 150L);
            member.setName("AAAAAA");

            // 영속성 컨텍스트에서 분리
            // 특정 엔티티만 준영속 상태로 변환
            //em.detach(member);
            
            // 1차캐시 통으로 날림
            em.clear(); 
            Member member1 = em.find(Member.class, 150L);



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