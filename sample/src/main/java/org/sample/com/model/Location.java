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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * Location generated by hbm2java
 */
@Entity
@Table(name="location"
    ,catalog="sample"
)
public class Location  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
     private City city;
     private Locality locality;
     private String name;
     private String address;
     private String landmark;
     private String nearBy;

    public Location() {
    }

    public Location(City city, Locality locality, String name, String address, String landmark, String nearBy) {
       this.city = city;
       this.locality = locality;
       this.name = name;
       this.address = address;
       this.landmark = landmark;
       this.nearBy = nearBy;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty(access = Access.WRITE_ONLY)
@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="cityId", nullable=false)
    public City getCity() {
        return this.city;
    }
    
    public void setCity(City city) {
        this.city = city;
    }

    @JsonProperty(access = Access.WRITE_ONLY)
@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="localityId", nullable=false)
    public Locality getLocality() {
        return this.locality;
    }
    
    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    
    @Column(name="name", nullable=false, length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="address", nullable=false, length=45)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    
    @Column(name="landmark", nullable=false, length=45)
    public String getLandmark() {
        return this.landmark;
    }
    
    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    
    @Column(name="nearBy", nullable=false, length=45)
    public String getNearBy() {
        return this.nearBy;
    }
    
    public void setNearBy(String nearBy) {
        this.nearBy = nearBy;
    }
}


