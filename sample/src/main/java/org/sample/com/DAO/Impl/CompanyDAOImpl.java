package org.sample.com.DAO.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.sample.com.DAO.CompanyDAO;
import org.sample.com.model.Company;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDAOImpl implements CompanyDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public int createCompany(String name, String address, String cityName, String state) {
		boolean value = entityManager
				.createNativeQuery(
						"INSERT IGNORE INTO sample.company(name, address, cityName, state)VALUES(:name, :address, :cityName, :state)")
				.setParameter("name", name).setParameter("address", address).setParameter("cityName", cityName)
				.setParameter("state", state).executeUpdate() == 0 ? false : true;
		if (value == false)
			return 0;
		return 2;
	}

	@Override
	public Object getCompany(int id) {
		return entityManager.createNativeQuery(
				"SELECT c.id, c.name, c.address, c.cityName, c.state FROM sample.company c WHERE c.id= :id",
				"company_details").setParameter("id", id).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> readCompany() {
		return entityManager
				.createNativeQuery("SELECT c.id, c.name, c.address, c.cityName, c.state FROM sample.company c",
						"company_details")
				.getResultList();
	}

	@Override
	public Company getCom(String name) {
		return (Company) entityManager.createNativeQuery(
				"SELECT c.id, c.name, c.address, c.cityName, c.state FROM sample.company c WHERE c.name= :name",
				"company_details").setParameter("name", name).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> company(String address) {
		return entityManager.createNativeQuery(
				"SELECT c.id, c.name, c.address, c.cityName, c.state FROM sample.company c WHERE c.address= :address",
				"company_details").setParameter("address", address).getResultList();
	}

	@Override
	public boolean deleteCompany(int id) {
		return entityManager.createNativeQuery("DELETE c.* FROM sample.company c WHERE c.id =:id")
				.setParameter("id", id).executeUpdate() == 0 ? false : true;
	}

	@Override
	public boolean updateCompany(int id, String name, String address) {
		return entityManager
				.createNativeQuery("UPDATE sample.company c SET c.name= :name, c.address= :address WHERE c.id= :id")
				.setParameter("id", id).setParameter("name", name).setParameter("address", address).executeUpdate() == 0
						? false : true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> companyDetails(String cityName) {
		return entityManager.createNativeQuery(
				"SELECT c.id, c.name, c.address, c.cityName, c.state FROM sample.company c WHERE c.cityName= :cityName",
				"company_details").setParameter("cityName", cityName).getResultList();
	}
}
