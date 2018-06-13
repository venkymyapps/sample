package org.sample.com.model;
// Generated Feb 6, 2018 1:18:09 PM by Hibernate Tools 5.2.1.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * State generated by hbm2java
 */

@Entity
@Table(name = "state", catalog = "sample", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class State implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private int id;
	private String name;
	private List<Company> companies = new ArrayList<Company>(0);

	public State() {
	}

	public State(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public State(String name, List<Company> companies) {
		this.name = name;
		this.companies = companies;
	}

	public State(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name", unique = true, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "state")
	public List<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

}