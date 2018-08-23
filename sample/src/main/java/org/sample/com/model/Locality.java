package org.sample.com.model;
// Generated Jun 16, 2018 11:48:50 AM by Hibernate Tools 5.2.1.Final


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * Locality generated by hbm2java
 */
@Entity
@Table(name="locality"
    ,catalog="sample"
    , uniqueConstraints = @UniqueConstraint(columnNames="name") 
)
public class Locality  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
     private City city;
     private String name;
     private Set<Location> locations = new HashSet<Location>(0);

    public Locality() {
    }

	
    public Locality(City city, String name) {
        this.city = city;
        this.name = name;
    }
    public Locality(City city, String name, Set<Location> locations) {
       this.city = city;
       this.name = name;
       this.locations = locations;
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
    @JoinColumn(name="cityId", nullable=false)
    public City getCity() {
        return this.city;
    }
    
    public void setCity(City city) {
        this.city = city;
    }

    
    @Column(name="name", unique=true, nullable=false, length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty(access = Access.WRITE_ONLY)
@OneToMany(fetch=FetchType.EAGER, mappedBy="locality")
    public Set<Location> getLocations() {
        return this.locations;
    }
    
    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }




}


