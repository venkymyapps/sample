package org.sample.com.service.impl;

import java.util.List;

import org.sample.com.DAO.UserDAO;
import org.sample.com.model.City;
import org.sample.com.model.Locality;
import org.sample.com.model.Location;
import org.sample.com.model.State;
import org.sample.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userDAO;

	@Override
	public List<State> sateList() {
		return userDAO.sateList();
	}

	@Override
	public int city(String name) {
		return userDAO.city(name);
	}

	@Override
	public List<City> city() {
		return userDAO.city();
	}

	@Override
	public boolean deleteCity(int id) {
		return userDAO.deleteCity(id);
	}

	@Override
	public int addLocality(Locality locality) {
		return userDAO.addLocality(locality);
	}

	@Override
	public List<Locality> getLocality(int id) {
		return userDAO.getLocality(id);
	}

	@Override
	public boolean updateLocality(int id, String name) {
		return userDAO.updateLocality(id, name);
	}

	@Override
	public int addLocation(Location location) {
		return userDAO.addLocation(location);
	}

	@Override
	public List<Location> getLocation(int id) {
		return userDAO.getLocation(id);
	}

	@Override
	public boolean updateLocation(int id, String name) {
		return userDAO.updateLocation(id, name);
	}

	@Override
	public boolean deleteLocation(int id) {
		return userDAO.deleteLocation(id);
	}

	@Override
	public boolean isEmpNameExist(String empName) {
		return userDAO.isEmpNameExist(empName);
	}

	@Override
	public boolean isMobileNoExist(String mobileNo) {
		return userDAO.isMobileNoExist(mobileNo);
	}

	@Override
	public boolean isEmailIdExists(String emailId) {
		return userDAO.isEmailIdExists(emailId);
	}

}
