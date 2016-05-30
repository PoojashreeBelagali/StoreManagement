package com.restapi.dao;

import java.util.List;

import com.restapi.entity.City;
import com.restapi.entity.Store;
import com.restapi.exception.DAOException;

/**
 * @author Poojashree B
 *
 */
public interface StoreDAO {

	Store findStoreById(long id);

	boolean isStoreExist(Integer storeId);

	void saveStore(Store store);

	void updateStore(Store currentStore);

	void deleteStore(long id) throws DAOException;

	List<City> getAllCities() throws DAOException;

	List<Store> getAllStores() throws DAOException;

	City getCityById(long id) throws DAOException;

}
