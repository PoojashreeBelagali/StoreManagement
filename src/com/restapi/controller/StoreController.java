package com.restapi.controller;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.restapi.entity.City;
import com.restapi.entity.Store;
import com.restapi.exception.ServiceException;
import com.restapi.service.StoreService;

@RestController
public class StoreController {

	private Logger LOGGER = Logger.getLogger(getClass());
	@Autowired
	StoreService storeService;

	@ModelAttribute("cities")
	public List<City> getAllCities(Model model) {
		List<City> cities = null;
		try {

			if (!cities.isEmpty()) {
				cities = storeService.findAllCities();
				model.addAttribute("cities", cities);
			}

		} catch (ServiceException e) {
			LOGGER.error(e.getMessage(), e);
			model.addAttribute("cities", cities);
		}
		return cities;

	}

	/**
	 * Creates a <code>Store</code> in DB.
	 * 
	 * @param store
	 *            - given <code>Store</code>,
	 * @param ucBuilder
	 *            - <code>UriComponentsBuilder</code>,
	 * @return - status of store creation.
	 */
	@RequestMapping(value = "/store/", method = RequestMethod.POST)
	public ResponseEntity<Void> createStore(@RequestBody Store store, UriComponentsBuilder ucBuilder) {
		LOGGER.debug("Creating Store " + store.getStoreName());

		try {
			if (storeService.isStoreExist(store)) {
				LOGGER.debug("A Store with name " + store.getStoreName() + " already exist");
				return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			}

			storeService.saveStore(store);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/store/{id}").buildAndExpand(store.getStoreId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		} catch (ServiceException e) {
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

	}

	/**
	 * Updates a store to DB.
	 * 
	 * @param id
	 *            - Given store id,
	 * @param store
	 *            - <code>Store</code>,
	 * @return - Update status.
	 */
	@RequestMapping(value = "/Store with id /{id}", method = RequestMethod.PUT)
	public ResponseEntity<Store> updateStore(@PathVariable("storeId") long id, @RequestBody Store store) {
		LOGGER.debug("Updating Store with id  " + id);

		Store currentStore;
		try {
			currentStore = storeService.findById(id);
			if (currentStore == null) {
				LOGGER.debug("Store with id " + id + " not found");
				return new ResponseEntity<Store>(HttpStatus.NOT_FOUND);
			}

			currentStore.setStoreName(store.getStoreName());

			storeService.updateStore(currentStore);
			return new ResponseEntity<Store>(currentStore, HttpStatus.OK);
		} catch (ServiceException e) {
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<Store>(HttpStatus.NO_CONTENT);
		}

	}

	/**
	 * Deletes the given store
	 * 
	 * @param id
	 *            - Given store id,
	 * @return - status of deletion of store.
	 */
	@RequestMapping(value = "/store/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Store> deleteStore(@PathVariable("id") long id) {
		LOGGER.debug("Fetching & Deleting Store with id " + id);

		Store store;
		try {
			store = storeService.findById(id);
			if (store == null) {
				LOGGER.debug("Unable to delete. Store with id " + id + " not found");
				return new ResponseEntity<Store>(HttpStatus.NOT_FOUND);
			}

			storeService.deleteStoreById(id);
		} catch (ServiceException e) {
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<Store>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Store>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Retrieves all the stores.
	 * 
	 * @return - List of <code>Store</code>.
	 */
	@RequestMapping(value = "/store/", method = RequestMethod.GET)
	public ResponseEntity<List<Store>> listAllStores() {
		List<Store> stores;
		try {
			stores = storeService.findAllStores();
			if (stores.isEmpty()) {
				return new ResponseEntity<List<Store>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Store>>(stores, HttpStatus.OK);
		} catch (ServiceException e) {
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<List<Store>>(HttpStatus.NO_CONTENT);
		}

	}

	/**
	 * Updates a store to DB.
	 * 
	 * @param id
	 *            - Given City id,
	 */
	@RequestMapping(value = "/City with id /{id}", method = RequestMethod.GET)
	public ResponseEntity<Set<Store>> getDistance(@RequestBody long cityId) {

		City city;
		try {
			city = storeService.findCityById(cityId);
			if (city == null) {
				return new ResponseEntity<Set<Store>>(HttpStatus.NOT_FOUND);
			}

			Set<Store> stores = city.getStores();

			return new ResponseEntity<Set<Store>>(stores, HttpStatus.OK);
		} catch (ServiceException e) {
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<Set<Store>>(HttpStatus.NO_CONTENT);
		}

	}

	/**
	 * Retrieves stores based on given store id.
	 * 
	 * @param id
	 *            - store id.
	 * @return - <code>Store</code>.
	 * @throws ServiceException
	 */
	@RequestMapping(value = "/store/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public long getStore(@PathVariable("id") long id) throws ServiceException {
		Store store = storeService.findById(id);
		if (store != null) {
			return store.getDistance();
		}
		return 0;
	}
}
