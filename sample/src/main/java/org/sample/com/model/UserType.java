package org.sample.com.model;
// Generated Jun 16, 2018 11:48:50 AM by Hibernate Tools 5.2.1.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * UserType generated by hbm2java
 */
@Entity
@Table(name="user_type"
    ,catalog="sample"
    , uniqueConstraints = @UniqueConstraint(columnNames="name") 
)
public class UserType  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Boolean id;
     private String name;

    public UserType() {
    }

    public UserType(String name) {
       this.name = name;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Boolean getId() {
        return this.id;
    }
    
    public void setId(Boolean id) {
        this.id = id;
    }

    
    @Column(name="name", unique=true, nullable=false, length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }




}


