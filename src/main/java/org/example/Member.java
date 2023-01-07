package org.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
//@Table(name="tableName")
public class Member {
    @Id
    private Long id;
    //@Column(name = "username")
    private String name;
    //Getter, Setter …

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

