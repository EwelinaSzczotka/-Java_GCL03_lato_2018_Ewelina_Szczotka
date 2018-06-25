
package com.example.hibernate.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Type(type="date")
    private Date date;
    
    @NotBlank
    private String host;
    
    @NotBlank
    private String guest;

    public String getGuest() {
        return guest;
    }

    public String getHost() {
        return host;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public void setHost(String host) {
        this.host = host;
    }
    

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }


    
    
     
}
