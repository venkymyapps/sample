package org.sample.com.DAO;

import java.util.List;

import org.sample.com.model.Company;

public interface CompanyDAO {

		int createCompany(String name, String address, String cityName, String state);
		Object getCompany(int id);
		List<Company> readCompany();
		Company getCom(String name);
		List<Company> company(String address);
		boolean deleteCompany(int id);
		boolean updateCompany(int id, String name, String address);
	}

