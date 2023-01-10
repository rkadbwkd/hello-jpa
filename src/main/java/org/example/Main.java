package org.example;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.example.domain.Member;
import org.example.domain.Order;

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
//
//            //Sudo code
//            //Order을 조회
//            Order order = em.find(Order.class,1L);
//            //Order에서 Member 조회
//            Long memberId = order.getMemberId();
//            // Member 조회 객체 지향이 아님
//            Member member = em.find(Member.class,memberId);

            //위 방식이 아닌
            // Member findMember = order.getMember();


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