package org.example;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
//@Table(name="MBR")
//@Table(name="tableName")

public class Member {

    @Id
    private Long id;
     // insert update시 변경을 반영 여부 (updateablel = false) jpa사용시 반영 X
    // nullable = false  == not null
    // columnDefinition = "varchar(100) default 'EMPTY'")
    @Column(name = "name", insertable = true, updatable = true)
    private String username;

    private Integer age;

    //DB에는 Enum Type이 없음 매핑하기
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    //날짜 타입
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDates;


    //private LocalDate create2;

    @Lob
    private String description;

    //db랑은 하지말아줘
    //@Transient
    private int temp;

    public Member() {

    }


    //    @Id
//    private Long id;
//    //@Column(name = "username")
//    //@Column(unique=true, length= 10)
//    private String name;
//    //Getter, Setter …
//
//    //JPA는 기본 생성자가 한개 있어야됨
//    public Member(){}
//
//    public Member(Long id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}

