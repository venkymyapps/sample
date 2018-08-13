package org.sample.com.service.impl;

import java.util.List;
import java.util.Optional;

import org.sample.com.DAO.EmployeeDAO;
import org.sample.com.model.Employee;
import org.sample.com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	public Object getEmployee(int id) {
		return employeeDAO.getEmployee(id);
	}

	@Override
	public boolean deleteEmployee(int id) {
		return employeeDAO.deleteEmployee(id);
	}

	@Override
	public boolean updateEmployee(String empName, int id) {
		return employeeDAO.updateEmployee(empName, id);
	}

	@Override
	public int createEmployee(Employee employee) {
		return employeeDAO.createEmployee(employee);
	}

	@Override
	public boolean deleteEmployees() {
		return employeeDAO.deleteEmployees();
	}

	@Override
	public boolean updateEmailId(int id, String emailId) {
		return employeeDAO.updateEmailId(id, emailId);
	}

	@Override
	public Object getSalary(int id) {
		return employeeDAO.getSalary(id);
	}

	@Override
	public boolean updateStatus(double salary) {
		return employeeDAO.updateStatus(salary);
	}

	@Override
	public List<Employee> getEmployeeByCity(String cityName) {
		return employeeDAO.getEmployeeByCity(cityName);
	}

	@Override
	public List<Employee> getEmployeeByDesig(String desig) {
		return employeeDAO.getEmployeeByDesig(desig);
	}

	@Override
	public int getEmpExp(int id) {
		return employeeDAO.getEmpExp(id);
	}

	@Override
	public List<Employee> getEmployeeByCompany(String companyName) {
		return employeeDAO.getEmployeeByCompany(companyName);
	}

	@Override
	public List<Employee> filterEmployee(Optional<String> cityName, Optional<String> companyName, Optional<String> desig) {
		return employeeDAO.filterEmployee(cityName, companyName, desig);
	}

	@Override
	public List<Employee> viewEmployee(String State, String companyName) {
		return employeeDAO.viewEmployee(State, companyName);
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeDAO.getEmployees();
	}

	@Override
	public Object viewEmpExp(int id) {
		return employeeDAO.viewEmpExp(id);
	}

}
