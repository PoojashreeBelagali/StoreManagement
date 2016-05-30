package com.restapi.controller;

import java.util.List;

import javax.ws.rs.Path;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.entity.City;
import com.restapi.exception.ServiceException;
import com.restapi.service.StoreService;

/**
 * @author Poojashree B
 *
 */
@Path("/city")
@RestController
public class CityController {
	
	private Logger LOGGER = Logger.getLogger(getClass());
	@Autowired
	StoreService storeService;

	/**
	 * Retrieves all the stores.
	 * 
	 * @return - List of <code>Store</code>.
	 */
	public ResponseEntity<List<City>> listAllCities() {
		List<City> cities = null;
		try {
			cities = storeService.findAllCities();
			if (cities.isEmpty()) {
				return new ResponseEntity<List<City>>(HttpStatus.NO_CONTENT);
			}
			
		} catch (ServiceException e) {
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<List<City>>(cities, HttpStatus.EXPECTATION_FAILED);
		}
		
		return new ResponseEntity<List<City>>(cities, HttpStatus.OK);
	}

}
