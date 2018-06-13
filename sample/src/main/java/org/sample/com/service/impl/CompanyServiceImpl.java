package org.sample.com.service.impl;

import java.util.List;

import org.sample.com.DAO.CompanyDAO;
import org.sample.com.model.Company;
import org.sample.com.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	CompanyDAO companyDAO;

	@Override
	public int createCompany(String name, String address, String cityName, String state) {
		return companyDAO.createCompany(name, address, cityName, state);
	}

	@Override
	public Object getCompany(int id) {
		return companyDAO.getCompany(id);
	}

	@Override
	public List<Company> readCompany() {
		return companyDAO.readCompany();
	}

	@Override
	public Company getCom(String name) {
		return companyDAO.getCom(name);
	}

	@Override
	public List<Company> company(String address) {
		return companyDAO.company(address);
	}

	@Override
	public boolean deleteCompany(int id) {
		return companyDAO.deleteCompany(id);
	}

	@Override
	public boolean updateCompany(int id, String name, String address) {
		return companyDAO.updateCompany(id, name, address);		
	}

	@Override
	public List<Company> companyDetails(String cityName) {
		return companyDAO.companyDetails(cityName);
	}

}
