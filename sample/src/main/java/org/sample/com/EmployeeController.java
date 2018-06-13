package org.sample.com;

import java.util.List;
import java.util.Optional;

import org.sample.com.model.Employee;
import org.sample.com.service.EmployeeService;
import org.sample.com.util.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	/* API for deleting employee */

	@ApiOperation(value = "Delete Employee", notes = "Delete Employee based on Id")
	@ApiResponses(value = { @ApiResponse(code = 1411, message = "Employee delete Successful"),
			@ApiResponse(code = 1412, message = "Delete Employee Failure") })
	@RequestMapping(value = "/delEmployee/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int id) {
		Employee employee = employeeService.getEmployee(id);
		System.out.println("Fetching & Deleting Employee with id " + id);
		HttpHeaders headers = new HttpHeaders();

		if (employee == null) {
			System.out.println("Unable to delete. Employee with id " + id + " not found");
			headers.set("ResponseCode", ResponseCode.deleteEmployeeFailure);
			return new ResponseEntity<Void>(headers, HttpStatus.OK);
		}

		employeeService.deleteEmployee(id);
		headers.set("ResponseCode", ResponseCode.deleteEmployeeSuccessful);
		return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
	}

	/* API for retrieving the employee */

	@ApiOperation(value = "Read Employee", notes = "Read Employee based on Id")
	@ApiResponses(value = { @ApiResponse(code = 1311, message = "Employee Read Successful"),
			@ApiResponse(code = 1312, message = "Employee Read Failure") })
	@RequestMapping(value = "/getEmp/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> getTask(@PathVariable("id") int id) {
		Employee employee = employeeService.getEmployee(id);
		HttpHeaders headers = new HttpHeaders();
		if (employee != null)
			headers.set("ResponseCode", ResponseCode.getEmployeeSuccessful);
		else
			headers.set("ResponseCode", ResponseCode.getEmployeeFailure);
		return new ResponseEntity<Employee>(employee, headers, HttpStatus.OK);
	}

	/* API for creating the employee */
	@ApiOperation(value = "Add Employee", notes = "Add Employee")
	@ApiResponses(value = { @ApiResponse(code = 1011, message = "Employee Add Successful"),
			@ApiResponse(code = 1012, message = "Employee Add Failure") })
	@RequestMapping(value = "/createEmployee/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody Employee employee) {
		HttpHeaders headers = new HttpHeaders();
		int emp = employeeService.createEmployee(employee);
		if (emp == 2)
			headers.set("ResponseCode", ResponseCode.CreateEmployeeSuccessful);
		else if (emp == 0)
			headers.set("ResponseCode", ResponseCode.EmployeeAlreadyExist);
		else
			headers.set("ResponseCode", ResponseCode.CreateEmployeeFailure);
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}

	/* API for update the employee */

	@ApiOperation(value = "Update Employee", notes = "To update Employee")
	@ApiResponses(value = { @ApiResponse(code = 1111, message = "update Employee Successful"),
			@ApiResponse(code = 1112, message = "update Employee Failure") })
	@RequestMapping(value = "/updateEmpName/", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateEmployee(@RequestParam String empName, @RequestParam int id) {
		HttpHeaders headers = new HttpHeaders();
		if (employeeService.updateEmployee(empName, id))
			headers.set("ResponseCode", ResponseCode.UpdateEmployeeSuccessful);
		else
			headers.set("ResponseCode", ResponseCode.UpdateEmployeeFailure);
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}

	/* API to retrieve all the employee details */

	@ApiOperation(value = "Read Employees", notes = "To Read Employees")
	@ApiResponses(value = { @ApiResponse(code = 1311, message = "Read Employee Successful"),
			@ApiResponse(code = 1312, message = "Read Employee Failure") })
	@RequestMapping(value = "/getEmployees/", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getEmployees() {

		List<Employee> employee = employeeService.getEmployees();
		HttpHeaders headers = new HttpHeaders();

		if (employee == null) {
			headers.set("ResponseCode", ResponseCode.getEmployeeFailure);
		} else
			headers.set("ResponseCode", ResponseCode.getEmployeeSuccessful);
		return new ResponseEntity<List<Employee>>(employee, headers, HttpStatus.OK);
	}

	/* API to Delete All Employees */

	@ApiOperation(value = "Delete Employee", notes = "To Delete Employee")
	@ApiResponses(value = { @ApiResponse(code = 1411, message = "Employee Delete Successful"),
			@ApiResponse(code = 1412, message = "Employee Delete Failure") })
	@RequestMapping(value = "/delEmployees/", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEmployees() {

		HttpHeaders headers = new HttpHeaders();
		if (employeeService.deleteEmployees())
			;
		headers.set("ResponseCode", ResponseCode.deleteEmployeeSuccessful);
		System.out.println("delete employee successful");

		headers.set("ResponseCode", ResponseCode.deleteEmployeeFailure);
		return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
	}

	/* update emailId based on id */

	@ApiOperation(value = "Update Email", notes = "Update EmailId of an Employee based on Id")
	@ApiResponses(value = { @ApiResponse(code = 1121, message = "Update EmailId Successful"),
			@ApiResponse(code = 1122, message = "Update EmailId Failure") })
	@RequestMapping(value = "/updateEmail/{id}/{emailId}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateEmailId(@PathVariable("id") int id, @PathVariable("emailId") String emailId) {
		HttpHeaders headers = new HttpHeaders();
		if (employeeService.updateEmailId(id, emailId))
			headers.set("ResponseCode", ResponseCode.updateEmailIdSuccessful);
		else
			headers.set("ResponseCode", ResponseCode.updateEmailIdFailure);
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}

	/* get employee salary based on id */

	@ApiOperation(value = "Get Salary", notes = "Get Salary based on Id")
	@ApiResponses(value = { @ApiResponse(code = 1211, message = "Get Salary Successful"),
			@ApiResponse(code = 1212, message = "Get Salary Failure") })
	@RequestMapping(value = "/getSalary/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getSalary(@PathVariable("id") int id) {
		HttpHeaders headers = new HttpHeaders();
		Object sal = employeeService.getSalary(id);
		if (sal != null)
			headers.set("ResponseCode", ResponseCode.getSalarySuccessful);
		else
			headers.set("ResponseCode", ResponseCode.getSalaryFailure);
		return new ResponseEntity<Object>(sal, headers, HttpStatus.OK);
	}

	/* update status based on salary */

	@ApiOperation(value = "Update Status", notes = "Update the Status based on Salary")
	@ApiResponses(value = { @ApiResponse(code = 1131, message = "Update Status Successful"),
			@ApiResponse(code = 1132, message = "Update Status Failure") })
	@RequestMapping(value = "/updateStatus/{salary}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateStatus(@PathVariable("salary") int salary) {
		HttpHeaders headers = new HttpHeaders();
		if (employeeService.updateStatus(salary))
			headers.set("ResponseCode", ResponseCode.updateStatusSuccessful);
		else
			headers.set("ResponseCode", ResponseCode.updateStatusFailure);
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}

	/* get employee details based on city */

	@ApiOperation(value = "Get Employees", notes = "Get Employees based on City")
	@ApiResponses(value = { @ApiResponse(code = 1311, message = "Get Employee Successful"),
			@ApiResponse(code = 1312, message = "Get Employee Failure") })
	@RequestMapping(value = "/getEmployees/{city}", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getEmployeeByCity(@PathVariable("city") String cityName) {
		HttpHeaders headers = new HttpHeaders();
		List<Employee> employee = employeeService.getEmployeeByCity(cityName);
		if (!employee.isEmpty())
			headers.set("ResponseCode", ResponseCode.getEmployeeSuccessful);
		else
			headers.set("ResponseCode", ResponseCode.getEmployeeFailure);
		return new ResponseEntity<List<Employee>>(employee, headers, HttpStatus.OK);
	}

	/* get employee details based on desig */

	@ApiOperation(value = "Get Employees", notes = "Get Employee List based on Desig")
	@ApiResponses(value = { @ApiResponse(code = 1311, message = "Get Employee Successful"),
			@ApiResponse(code = 1312, message = "Get Employees Failure") })
	@RequestMapping(value = "/getEmployeeList/{desig}", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getEmployeeByDesig(@PathVariable("desig") String desig) {
		HttpHeaders headers = new HttpHeaders();
		List<Employee> emp = employeeService.getEmployeeByDesig(desig);
		if (!emp.isEmpty())
			headers.set("ResponseCode", ResponseCode.getEmployeeSuccessful);
		else
			headers.set("ResponseCode", ResponseCode.getEmployeeFailure);
		return new ResponseEntity<List<Employee>>(emp, headers, HttpStatus.OK);
	}

	@ApiOperation(value = "Update EXP", notes = "Get Exp based on Id")
	@ApiResponses(value = { @ApiResponse(code = 1141, message = "Get Exp Successful"),
			@ApiResponse(code = 1142, message = "Get Exp Failure") })
	@RequestMapping(value = "/getExp/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Employee> getEmpExp(@PathVariable("id") int id) {
		HttpHeaders headers = new HttpHeaders();
		int exp = employeeService.getEmpExp(id);
		if (exp != 0)
			headers.set("ResponseCode", ResponseCode.updateExpSuccessful);
		else
			headers.set("ResponseCode", ResponseCode.updateExpFailure);
		return new ResponseEntity<Employee>(headers, HttpStatus.OK);
	}

	@ApiOperation(value = "Read Employees", notes = "Read Employees based on CompanyName")
	@ApiResponses(value = { @ApiResponse(code = 1311, message = "Get Employees Successful"),
			@ApiResponse(code = 1312, message = "Get Employees Failure") })
	@RequestMapping(value = "/getEmployee/{companyName}", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getEmployeeByCompany(@PathVariable("companyName") String companyName) {
		List<Employee> employee = employeeService.getEmployeeByCompany(companyName);
		HttpHeaders headers = new HttpHeaders();
		if (employee != null)
			headers.set("ResponseCode", ResponseCode.getEmployeeSuccessful);
		else
			headers.set("ResponseCode", ResponseCode.getEmployeeFailure);
		return new ResponseEntity<List<Employee>>(employee, headers, HttpStatus.OK);

	}

	@ApiOperation(value = "filter the Employees", notes = "Read Employees based on city&companyName&desig")
	@ApiResponses(value = { @ApiResponse(code = 1311, message = "Get Employees Successful"),
			@ApiResponse(code = 1312, message = "Get Employees Failure") })
	@RequestMapping(value = "/filterEmployee/", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> filterEmployee(@RequestParam Optional<String> cityName,
			@RequestParam Optional<String> companyName, @RequestParam Optional<String> desig) {
		List<Employee> employee = employeeService.filterEmployee(cityName, companyName, desig);
		HttpHeaders headers = new HttpHeaders();
		if (employee != null)
			headers.set("ResponseCode", ResponseCode.getEmployeeSuccessful);
		else
			headers.set("ResponseCode", ResponseCode.getEmployeeFailure);
		return new ResponseEntity<List<Employee>>(employee, headers, HttpStatus.OK);

	}

	@ApiOperation(value = "filter the Employees based on State", notes = "Read Employees based on state")
	@ApiResponses(value = { @ApiResponse(code = 1311, message = "Get Employees Successful"),
			@ApiResponse(code = 1312, message = "Get Employees Failure") })
	@RequestMapping(value = "/viewEmployee/", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> viewEmployee(@RequestParam String State, @RequestParam String companyName) {
		List<Employee> employee = employeeService.viewEmployee(State, companyName);
		HttpHeaders headers = new HttpHeaders();
		if (employee != null)
			headers.set("ResponseCode", ResponseCode.getEmployeeSuccessful);
		else
			headers.set("ResponseCode", ResponseCode.getEmployeeFailure);
		return new ResponseEntity<List<Employee>>(employee, headers, HttpStatus.OK);

	}

	@ApiOperation(value = "get EXP", notes = "Get Exp based on Id")
	@ApiResponses(value = { @ApiResponse(code = 1141, message = "Get Exp Successful"),
			@ApiResponse(code = 1142, message = "Get Exp Failure") })
	@RequestMapping(value = "/viewExp/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> viewEmpExp(@PathVariable("id") int id) {
		HttpHeaders headers = new HttpHeaders();
		Object exp = employeeService.viewEmpExp(id);
		if (exp != null)
			headers.set("ResponseCode", ResponseCode.getEmpExpSuccessful);
		else
			headers.set("ResponseCode", ResponseCode.getEmpExpFailure);
		return new ResponseEntity<Object>(exp, headers, HttpStatus.OK);
	}
}
