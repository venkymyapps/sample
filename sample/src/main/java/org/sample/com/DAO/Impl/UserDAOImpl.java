package org.sample.com.DAO.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.sample.com.DAO.UserDAO;
import org.sample.com.model.City;
import org.sample.com.model.Locality;
import org.sample.com.model.Location;
import org.sample.com.model.State;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<State> sateList() {
		return entityManager.createQuery("SELECT s FROM State s").getResultList();
	}

	@Override
	public int city(String name) {
		boolean value = entityManager.createNativeQuery("INSERT IGNORE INTO sample.city (name) VALUES (:name)")
				.setParameter("name", name).executeUpdate() == 0 ? false : true;
		if (value == true)
			return 0;
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<City> city() {
		return entityManager.createNativeQuery("SELECT c.* FROM sample.city c ORDER BY c.name", "city_details").getResultList();
	}

	@Override
	public boolean deleteCity(int id) {
		return entityManager.createNativeQuery("DELETE c FROM sample.city c WHERE id =:id").setParameter("id", id)
				.executeUpdate() == 0 ? false : true;
	}

	@Override
	public int addLocality(Locality locality) {
		boolean value = entityManager
				.createNativeQuery("INSERT IGNORE INTO sample.locality(name,cityId)values(:name, :cityId)")
				.setParameter("name", locality.getName()).setParameter("cityId", locality.getCity().getId())
				.executeUpdate() == 0 ? false : true;
		if (value == true)
			return 0;
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Locality> getLocality(int id) {
		return entityManager
				.createQuery("SELECT l FROM Locality l JOIN FETCH l.city c WHERE c.id =:cityId ORDER BY l.name")
				.setParameter("cityId", id).getResultList();
	}

	@Override
	public boolean updateLocality(int id, String name) {
		return (entityManager.createNativeQuery("UPDATE sample.locality SET name= :name WHERE id= :id")
				.setParameter("name", name).setParameter("id", id).executeUpdate() == 0) ? false : true;
	}

	@Override
	public int addLocation(Location location) {
		Object obj = entityManager
				.createNativeQuery("SELECT l.name FROM locality l WHERE l.cityId =:cityId AND l.id =:id")
				.setParameter("cityId", location.getCity().getId()).setParameter("id", location.getLocality().getId())
				.getSingleResult();
		if (obj == null)
			return 1;
		entityManager.persist(location);
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> getLocation(int id) {
		return entityManager.createQuery("SELECT l FROM Location l JOIN FETCH l.locality k WHERE k.id= :id")
				.setParameter("id", id).getResultList();

	}

	@Override
	public boolean updateLocation(int id, String name) {
		return (entityManager.createNativeQuery("UPDATE sample.location SET name= :name where id= :id")
				.setParameter("name", name).setParameter("id", id).executeUpdate() == 0) ? false : true;
	}

	@Override
	public boolean deleteLocation(int id) {
		entityManager.createNativeQuery("delete l.* from sample.location l where l.id= :id").setParameter("id", id)
				.executeUpdate();
		return false;
	}
	
	@Override
	public boolean isEmpNameExist(String empName) {
		return (String) entityManager
				.createQuery("SELECT empName FROM Employee e WHERE empName = :empName OR mobileNo = :empName")
				.setParameter("empName", empName).getSingleResult() != null;
	}

	@Override
	public boolean isMobileNoExist(String mobileNo) {
		return (String) entityManager
				.createQuery("SELECT mobileNo FROM Employee WHERE empName = :mobileNo OR mobileNo = :mobileNo")
				.setParameter("mobileNo", mobileNo).getSingleResult() != null;
	}

	@Override
	public boolean isEmailIdExists(String emailId) {
		return entityManager.createQuery("SELECT emailId FROM Employee WHERE emailId = :emailId")
				.setParameter("emailId", emailId).getSingleResult() != null;
	}
}
