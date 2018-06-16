package org.sample.com.model;
// Generated Jun 16, 2018 11:48:50 AM by Hibernate Tools 5.2.1.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Company generated by hbm2java
 */
@Entity
@Table(name="company"
    ,catalog="sample"
    , uniqueConstraints = @UniqueConstraint(columnNames="name") 
)
public class Company  implements java.io.Serializable {


     private Integer id;
     private City city;
     private String name;
     private String address;
     private String state;

    public Company() {
    }

    public Company(City city, String name, String address, String state) {
       this.city = city;
       this.name = name;
       this.address = address;
       this.state = state;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cityName", nullable=false)
    public City getCity() {
        return this.city;
    }
    
    public void setCity(City city) {
        this.city = city;
    }

    
    @Column(name="name", unique=true, nullable=false, length=125)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="address", nullable=false, length=250)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    
    @Column(name="state", nullable=false, length=45)
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }




}


