package org.sample.com.DAO;

import java.util.List;

import org.sample.com.model.City;
import org.sample.com.model.Locality;
import org.sample.com.model.Location;
import org.sample.com.model.State;

public interface UserDAO {
	
	List<State> sateList();
	int city(String name);
	List<City> city();
	boolean deleteCity(int id);
	int addLocality(Locality locality);
	List<Locality> getLocality(int id);
	boolean updateLocality(int id, String name);
	int addLocation(Location location);
	List<Location> getLocation(int id);
	boolean updateLocation(int id, String name);
	boolean deleteLocation(int id);
	boolean isEmpNameExist(String empName);
	boolean isMobileNoExist(String mobileNo);
	boolean isEmailIdExists(String emailId);
}
