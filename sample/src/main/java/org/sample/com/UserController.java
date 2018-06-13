package org.sample.com;

import java.util.List;

import org.sample.com.model.City;
import org.sample.com.model.Locality;
import org.sample.com.model.Location;
import org.sample.com.model.State;
import org.sample.com.service.UserService;
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
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/stateList/", method = RequestMethod.GET)
	public ResponseEntity<List<State>> stateList() {
		return new ResponseEntity<List<State>>(userService.sateList(), HttpStatus.OK);
	}

	@ApiOperation(value = "Add City", notes = "To add a new city to the city list by product owner")
	@ApiResponses(value = { @ApiResponse(code = 1511, message = "City Add Successful"),
			@ApiResponse(code = 1512, message = "City Add Failure") })
	@RequestMapping(value = "/city/", method = RequestMethod.POST)
	public ResponseEntity<Void> city(@RequestParam String name) {
		HttpHeaders headers = new HttpHeaders();
		int city = userService.city(name);
		if (city == 0)
			headers.set("ResponseCode", ResponseCode.CreateCitySuccessful);
		else if (city == 1)
			headers.set("ResponseCode", ResponseCode.CityAlreadyAdded);
		else
			headers.set("ResponseCode", ResponseCode.CreateCityFailure);
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}

	@ApiOperation(value = "Read City", notes = "To Read the list of cities by users")
	@ApiResponses(value = { @ApiResponse(code = 1611, message = "City Read Successful"),
			@ApiResponse(code = 1612, message = "City Read Failure") })
	@RequestMapping(value = "/city/", method = RequestMethod.GET)
	public ResponseEntity<List<City>> city() {
		HttpHeaders headers = new HttpHeaders();
		List<City> city = userService.city();
		if (city != null)
			headers.set("ResponseCode", ResponseCode.ReadCitySuccessful);
		else
			headers.set("ResponseCode", ResponseCode.ReadCityFailure);
		return new ResponseEntity<List<City>>(city, headers, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete City", notes = "To Delete the city")
	@ApiResponses(value = { @ApiResponse(code = 1611, message = "City Remove Successful"),
			@ApiResponse(code = 1612, message = "City Remove Failure") })
	@RequestMapping(value = "/city/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteCity(@PathVariable("id") int id) {
		HttpHeaders headers = new HttpHeaders();
		if (userService.deleteCity(id))
			headers.set("ResponseCode", ResponseCode.RemoveCitySuccessful);
		else
			headers.set("ResponseCode", ResponseCode.RemoveCityFailure);
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}

	@ApiOperation(value = "Add Locality", notes = "To add a new locality by administrator")
	@ApiResponses(value = { @ApiResponse(code = 1811, message = "Locality Add Successful"),
			@ApiResponse(code = 1812, message = "Locality Add Failure"),
			@ApiResponse(code = 1813, message = "Locality Already Added") })
	@RequestMapping(value = "/locality/", method = RequestMethod.POST)
	public ResponseEntity<Void> addlocality(@RequestBody Locality locality) {
		HttpHeaders headers = new HttpHeaders();
		int local = userService.addLocality(locality);
		if (local == 0)
			headers.set("ResponseCode", ResponseCode.LocalityAddSuccessful);
		else if (local == 1)
			headers.set("ResponseCode", ResponseCode.LocalityAlreadyExist);
		else
			headers.set("ResponseCode", ResponseCode.LocalityAddFailure);
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}

	@ApiOperation(value = "Read Locality", notes = "To read the localities in a city")
	@ApiResponses(value = { @ApiResponse(code = 1911, message = "Read Locality Successful"),
			@ApiResponse(code = 1912, message = "Read Locality Failure") })
	@RequestMapping(value = "/localities/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Locality>> getLocality(@PathVariable("id") int id) {
		HttpHeaders headers = new HttpHeaders();
		List<Locality> loc = userService.getLocality(id);
		if (loc != null)
			headers.set("ResponseCode", ResponseCode.ReadLocalitySuccessful);
		else
			headers.set("ResponseCode", ResponseCode.ReadLocalityFailure);
		return new ResponseEntity<List<Locality>>(loc, headers, HttpStatus.OK);
	}

	@ApiOperation(value = "update Locality", notes = "To update the locality based on id")
	@ApiResponses(value = { @ApiResponse(code = 2111, message = "UPDATE Locality Successful"),
			@ApiResponse(code = 2112, message = "UPDATE Locality Failure") })
	@RequestMapping(value = "/locality/", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateLocality(@RequestParam int id, @RequestParam String name) {
		HttpHeaders headers = new HttpHeaders();
		if (userService.updateLocality(id, name))
			headers.set("ResponseCode", ResponseCode.updateLocalitySuccessful);
		else
			headers.set("ResponseCode", ResponseCode.updateLocalityFailure);
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}

	@ApiOperation(value = "To Add Location", notes = " To add a location by service provider")
	@ApiResponses(value = { @ApiResponse(code = 2211, message = "Location Add Successful"),
			@ApiResponse(code = 2212, message = "Location Add Failure") })
	@RequestMapping(value = "/location/", method = RequestMethod.POST)
	public ResponseEntity<Void> addLocation(@RequestBody Location location) {
		HttpHeaders headers = new HttpHeaders();
		int local = userService.addLocation(location);
		if (local == 0)
			headers.set("ResponseCode", ResponseCode.AddLocationSuccessful);
		else
			headers.set("ResponseCode", ResponseCode.AddLocationFailure);
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}

	@ApiOperation(value = "To Read Location", notes = " To read location details")
	@ApiResponses(value = { @ApiResponse(code = 2311, message = "Read Location Successful"),
			@ApiResponse(code = 2312, message = "Read Location Failure") })
	@RequestMapping(value = "/getLocation/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Location>> getLocation(@PathVariable("id") int id) {
		HttpHeaders headers = new HttpHeaders();
		List<Location> loc = userService.getLocation(id);
		if (loc != null)
			headers.set("ResponseCode", ResponseCode.ReadLocationSuccessful);
		else
			headers.set("ResponseCode", ResponseCode.ReadLocationFailure);
		return new ResponseEntity<List<Location>>(loc, headers, HttpStatus.OK);

	}

	@ApiOperation(value = "To update Location", notes = " To update location details")
	@ApiResponses(value = { @ApiResponse(code = 2321, message = "update Location Successful"),
			@ApiResponse(code = 2322, message = "update Location Failure") })
	@RequestMapping(value = "/updateLocation/", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateLocation(@RequestParam int id, @RequestParam String name) {
		HttpHeaders headers = new HttpHeaders();
		if (userService.updateLocation(id, name))
			headers.set("ResponseCode", ResponseCode.UpdateLocationSuccessful);
		else
			headers.set("ResponseCode", ResponseCode.UpdateLocationFailure);
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}

	@ApiOperation(value = "To Delete Location", notes = " To Delete location details")
	@ApiResponses(value = { @ApiResponse(code = 2411, message = "Delete Location Successful"),
			@ApiResponse(code = 2412, message = "Delete Location Failure") })
	@RequestMapping(value = "/DeleteLocation/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteLocation(@PathVariable("id") int id) {
		HttpHeaders headers = new HttpHeaders();
		if (userService.deleteLocation(id))
			headers.set("ResponseCode", ResponseCode.DeleteLocationFailure);
		else
			headers.set("ResponseCode", ResponseCode.DeleteLocationSuccessful);
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}
}
