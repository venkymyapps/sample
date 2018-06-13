package org.sample.com;

import java.util.List;

import org.sample.com.model.Company;
import org.sample.com.service.CompanyService;
import org.sample.com.util.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CompanyController {

	@Autowired
	CompanyService companyService;

	@ApiOperation(value = "add Company", notes = "add Company")
	@ApiResponses(value = { @ApiResponse(code = 1021, message = "Create Company Successful"),
			@ApiResponse(code = 1023, message = "Company Already Exist"),
			@ApiResponse(code = 1023, message = "Create Company Failure") })
	@RequestMapping(value = "/Company/", method = RequestMethod.POST)
	public ResponseEntity<Void> createCompany(@RequestParam String name, @RequestParam String address,
			@RequestParam String cityName, @RequestParam String state) {
		int obj = companyService.createCompany(name, address, cityName, state);
		HttpHeaders headers = new HttpHeaders();
		if (obj == 2)
			headers.set("ResponseCode", ResponseCode.CreateCompanySuccessful);
		else if (obj == 0)
			headers.set("ResponseCode", ResponseCode.CompanyAlreadyExist);
		else
			headers.set("ResponseCode", ResponseCode.CreateCompanyFailure);
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}

	/* API for retrieving the company details */

	@ApiOperation(value = "Read Company", notes = "Read Company based on Id")
	@ApiResponses(value = { @ApiResponse(code = 3111, message = "Company Read Successful"),
			@ApiResponse(code = 3112, message = "Company Read Failure") })
	@RequestMapping(value = "/getCompany/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getCompany(@PathVariable("id") int id) {
		Object obj = companyService.getCompany(id);
		HttpHeaders headers = new HttpHeaders();
		if (obj != null)
			headers.set("ResponseCode", ResponseCode.ReadCompanySuccessful);
		else
			headers.set("ResponseCode", ResponseCode.ReadCompanyFailure);
		return new ResponseEntity<Object>(obj, headers, HttpStatus.OK);
	}

	/* API for retrieving the company details */

	@ApiOperation(value = "Read Company", notes = "Read Companies")
	@ApiResponses(value = { @ApiResponse(code = 3111, message = "Company Read Successful"),
			@ApiResponse(code = 3112, message = "Company Read Failure") })
	@RequestMapping(value = "/getCom/", method = RequestMethod.GET)
	public ResponseEntity<List<Company>> readCompany() {
		List<Company> com = companyService.readCompany();
		HttpHeaders headers = new HttpHeaders();
		if (com != null)
			headers.set("ResponseCode", ResponseCode.ReadCompanySuccessful);
		else
			headers.set("ResponseCode", ResponseCode.ReadCompanyFailure);
		return new ResponseEntity<List<Company>>(com, headers, HttpStatus.OK);
	}

	@ApiOperation(value = "Read Company", notes = "Read Company based on address")
	@ApiResponses(value = { @ApiResponse(code = 3111, message = "Company Read Successful"),
			@ApiResponse(code = 3112, message = "Company Read Failure") })
	@RequestMapping(value = "/getCompany/", method = RequestMethod.GET)
	public ResponseEntity<List<Company>> getCompany(@RequestParam String address) {
		List<Company> obj = companyService.company(address);
		HttpHeaders headers = new HttpHeaders();
		if (obj != null)
			headers.set("ResponseCode", ResponseCode.ReadCompanySuccessful);
		else
			headers.set("ResponseCode", ResponseCode.ReadCompanyFailure);
		return new ResponseEntity<List<Company>>(obj, headers, HttpStatus.OK);
	}

	/* API for retrieving the company details */

	@ApiOperation(value = "Read Company", notes = "Read Companies based on name")
	@ApiResponses(value = { @ApiResponse(code = 3111, message = "Company Read Successful"),
			@ApiResponse(code = 3112, message = "Company Read Failure") })
	@RequestMapping(value = "/getCompanyDetails/", method = RequestMethod.GET)
	public ResponseEntity<Company> getCom(@RequestParam String name) {
		Company com = companyService.getCom(name);
		HttpHeaders headers = new HttpHeaders();
		if (com != null)
			headers.set("ResponseCode", ResponseCode.ReadCompanySuccessful);
		else
			headers.set("ResponseCode", ResponseCode.ReadCompanyFailure);
		return new ResponseEntity<Company>(com, headers, HttpStatus.OK);
	}

	/* API for deleting the company details */

	@ApiOperation(value = "Delete Company", notes = "Delete Company based on id")
	@ApiResponses(value = { @ApiResponse(code = 3111, message = "Remove Company Successful"),
			@ApiResponse(code = 3112, message = "Remove Company Failure") })
	@RequestMapping(value = "/RemoveCompany/", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteCompany(@RequestParam int id) {
		HttpHeaders headers = new HttpHeaders();
		if (companyService.deleteCompany(id))
			headers.set("ResponseCode", ResponseCode.RemoveCompanySuccessful);
		else
			headers.set("ResponseCode", ResponseCode.RemoveCompanyFailure);
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}

	/* API for update the company details */

	@ApiOperation(value = "update company", notes = "Update The Company Name and Address")
	@ApiResponses(value = { @ApiResponse(code = 5555, message = "Update Company Successful"),
			@ApiResponse(code = 6666, message = "Update Company Failure") })
	@RequestMapping(value = "/UpdateCompany/", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateCompany(@RequestParam int id, @RequestParam String name,
			@RequestParam String address) {
		HttpHeaders headers = new HttpHeaders();
		if (companyService.updateCompany(id, name, address))
			headers.set("ResponseCode", ResponseCode.UpdateCompanySuccessful);
		else
			headers.set("ResponseCode", ResponseCode.UpdateCompanyFailure);
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}

	/* API for retrieving the company details */

	@ApiOperation(value = "Read Company", notes = "Read Companies based on cityName")
	@ApiResponses(value = { @ApiResponse(code = 3111, message = "Company Read Successful"),
			@ApiResponse(code = 3112, message = "Company Read Failure") })
	@RequestMapping(value = "/getCompanies/", method = RequestMethod.GET)
	public ResponseEntity<List<Company>> companyDetails(@RequestParam String cityName) {
		List<Company> com = companyService.companyDetails(cityName);
		HttpHeaders headers = new HttpHeaders();
		if (com != null)
			headers.set("ResponseCode", ResponseCode.ReadCompanySuccessful);
		else
			headers.set("ResponseCode", ResponseCode.ReadCompanyFailure);
		return new ResponseEntity<List<Company>>(com, headers, HttpStatus.OK);
	}
}
