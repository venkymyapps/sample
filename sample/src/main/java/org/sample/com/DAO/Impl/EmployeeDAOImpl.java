package org.sample.com.DAO.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.sample.com.DAO.EmployeeDAO;
import org.sample.com.model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@PersistenceContext(unitName = "sample")
	private EntityManager entityManager;

	/* for retrieving the employee */

	@Override
	public Employee getEmployee(int id) {
		return (Employee) entityManager
				.createNativeQuery("SELECT e.*  FROM sample.employee e where e.id= :id", "employee_details")
				.setParameter("id", id).getSingleResult();
	}

	/* for deleting employee */

	@Override
	public boolean deleteEmployee(int id) {
		return (entityManager.createNativeQuery("DELETE FROM sample.employee WHERE id = :id").setParameter("id", id)
				.executeUpdate()) == 0 ? false : true;
	}

	/* for update the employee */

	@Override
	public boolean updateEmployee(String empName, int id) {
		return entityManager.createNativeQuery("UPDATE sample.employee e SET e.empName =:empName WHERE e.id =:id")
				.setParameter("empName", empName).setParameter("id", id).executeUpdate() == 0 ? false : true;
	}

	/* for creating the employee */

	@Override
	public int createEmployee(Employee employee) {
		boolean value = entityManager
				.createNativeQuery(
						"INSERT IGNORE INTO sample.employee(firstName, empName, joinDate, salary, emailId, status, cityName, companyName, desig, exp, mobileNo)values(:firstName, :empName, :joinDate, :salary, :emailId, :status, :cityName, :companyName, :desig, :exp, :mobileNo)")
				.setParameter("firstName", employee.getFirstName()).setParameter("empName", employee.getEmpName())
				.setParameter("joinDate", employee.getJoinDate()).setParameter("salary", employee.getSalary())
				.setParameter("emailId", employee.getEmailId()).setParameter("status", employee.getStatus())
				.setParameter("cityName", employee.getcity().getName())
				.setParameter("companyName", employee.getCompany().getName()).setParameter("desig", employee.getDesig())
				.setParameter("exp", employee.getExp()).setParameter("mobileNo", employee.getMobileNo())
				.executeUpdate() == 0 ? false : true;
		if (value == false)
			return 0;
		return 2;
	}

	/* to retrieve all the employee details */

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployees() {
		return entityManager.createNativeQuery(
				"select id, firstName, empName, joinDate, salary, emailId, status, cityName, companyname, desig , exp, mobileNo from sample.employee",
				"employee_view").getResultList();
	}

	/* to Delete All Employees */

	@Override
	public boolean deleteEmployees() {
		return (entityManager.createNativeQuery("DELETE e FROM employee e").executeUpdate()) == 0 ? false : true;
	}

	/* update emailId based on id */

	@Override
	public boolean updateEmailId(int id, String emailId) {
		entityManager.createNativeQuery("UPDATE sample.employee e SET e.emailId= :emailId WHERE e.id= :id")
				.setParameter("id", id).setParameter("emailId", emailId).executeUpdate();
		return true;
	}

	/* get employee salary based on id */

	@Override
	public Object getSalary(int id) {
		return entityManager.createNativeQuery("SELECT t.salary FROM sample.employee t WHERE t.id= :id")
				.setParameter("id", id).getSingleResult();
	}

	/* update status based on salary */

	@SuppressWarnings("unused")
	@Override
	public boolean updateStatus(double salary) {
		boolean flag = false;
		if (salary >= 10000)
			flag = entityManager.createNativeQuery("UPDATE sample.employee t SET t.status = 1 WHERE t.salary > :sal")
					.setParameter("sal", salary).executeUpdate() == 0 ? false : true;

		if (flag = true)
			return true;
		else
			return false;
	}

	/* get employee details based on city */

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeeByCity(String cityName) {
		return entityManager
				.createNativeQuery("SELECT e.* FROM sample.employee e JOIN sample.city c ON "
						+ "e.cityName = c.name WHERE c.name = :cityName", "employee_details")
				.setParameter("cityName", cityName).getResultList();

	}

	/* get employee details based on desig */

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeeByDesig(String desig) {
		return entityManager.createNativeQuery("SELECT e.* FROM employee e where e.desig = :desig", "employee_details")
				.setParameter("desig", desig).getResultList();
	}

	/* update the employee experience based on id */

	@Override
	public int getEmpExp(int id) {

		StoredProcedureQuery spQuery = entityManager.createStoredProcedureQuery("emp_exp")
				.registerStoredProcedureParameter("v_id", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("v_exp", String.class, ParameterMode.OUT).setParameter("v_id", id);
		spQuery.execute();
		if (spQuery.getOutputParameterValue("v_exp") != null)
			return 0;
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeeByCompany(String companyName) {
		return (List<Employee>) entityManager
				.createNativeQuery("SELECT e.* FROM sample.employee e JOIN sample.company c ON "
						+ "e.companyName = c.name WHERE c.name = :companyName", "employee_details")
				.setParameter("companyName", companyName).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> filterEmployee(Optional<String> cityName, Optional<String> companyName,
			Optional<String> desig) {
		StoredProcedureQuery spQuery = entityManager.createStoredProcedureQuery("employee_filter", "employee_details")
				.registerStoredProcedureParameter("v_cityName", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("v_companyName", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("v_desig", String.class, ParameterMode.IN)
				.setParameter("v_cityName", cityName.isPresent() ? cityName.get().toString() : null)
				.setParameter("v_companyName", companyName.isPresent() ? companyName.get().toString() : null)
				.setParameter("v_desig", desig.isPresent() ? desig.get().toString() : null);
		spQuery.execute();
		List<Employee> employees = new ArrayList<Employee>();
		employees = spQuery.getResultList();
		return employees;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> viewEmployee(String State, String companyName) {
		return entityManager
				.createNativeQuery(
						"SELECT e.* from sample.employee e JOIN sample.company c on e.companyName = c.name WHERE c.state = :state and c.name= :companyname",
						"employee_details")
				.setParameter("state", State).setParameter("companyname", companyName).getResultList();
	}

	@Override
	public Object viewEmpExp(int id) {
		StoredProcedureQuery spQuery = entityManager.createStoredProcedureQuery("view_exp")
				.registerStoredProcedureParameter("v_id", Integer.class, ParameterMode.IN).setParameter("v_id", id);
		spQuery.execute();
		return spQuery.getSingleResult();

	}
}