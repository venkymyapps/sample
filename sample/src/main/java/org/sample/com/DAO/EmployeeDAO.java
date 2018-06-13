package org.sample.com.DAO;

import java.util.List;
import java.util.Optional;

import org.sample.com.model.Employee;

public interface EmployeeDAO {

		Employee getEmployee(int id);
		boolean deleteEmployee(int id);
		boolean updateEmployee(String empName, int id);
		int createEmployee(Employee employee);
		boolean deleteEmployees();
		boolean updateEmailId(int id, String emailId);
		Object getSalary(int id);
		boolean updateStatus(double salary);
		List<Employee> getEmployeeByCity(String cityName);
		List<Employee> getEmployeeByDesig(String desig);
		int getEmpExp(int id);
		List<Employee> getEmployeeByCompany(String companyName);
		List<Employee> viewEmployee(String State, String companyName);
		List<Employee> getEmployees();
		Object viewEmpExp(int id);
		List<Employee> filterEmployee(Optional<String> cityName, Optional<String> companyName, Optional<String> desig);
	}
