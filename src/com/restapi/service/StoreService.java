/**
 * 
 */
package com.restapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restapi.entity.City;
import com.restapi.entity.Store;
import com.restapi.exception.ServiceException;

/**
 * @author Poojashree B
 *
 */
@Service
public interface StoreService {

	Store findById(long id) throws ServiceException;

	boolean isStoreExist(Store store) throws ServiceException;

	void saveStore(Store store) throws ServiceException;

	void deleteStoreById(long id) throws ServiceException;

	void updateStore(Store currentStore) throws ServiceException; 

	List<City> findAllCities() throws ServiceException;

	List<Store> findAllStores() throws ServiceException;

	City findCityById(long id)throws ServiceException;

}
