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


            Member member = new Member(200L, "member200");
            em.persist(member);

            //1차 캐시 지워지지 않습니다!
            // 영속성 컨텍스트에 쓰기 지연 SQL 저장소에 있는 SQL 쿼리르 날림
            em.flush();

            System.out.println("=======================");

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