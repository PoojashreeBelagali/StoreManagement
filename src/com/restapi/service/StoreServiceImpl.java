/**
 * 
 */
package com.restapi.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.restapi.dao.StoreDAO;
import com.restapi.entity.City;
import com.restapi.entity.Store;
import com.restapi.exception.DAOException;
import com.restapi.exception.ServiceException;

/**
 * @author Poojashree B
 *
 */
@Service
public class StoreServiceImpl implements StoreService {
	private Logger LOGGER = Logger.getLogger(getClass());

	@Autowired
	private StoreDAO storeDao;

	@Override
	public Store findById(long id) {

		return storeDao.findStoreById(id);
	}

	@Override
	public boolean isStoreExist(Store store) {
		boolean storeExists = false;
		storeExists = storeDao.isStoreExist(store.getStoreId());
		return storeExists;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = ServiceException.class)
	public void saveStore(Store store) {
		storeDao.saveStore(store);

	}

	@Override
	public void deleteStoreById(long id) throws ServiceException {
		try {
			storeDao.deleteStore(id);
		} catch (DAOException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void updateStore(Store currentStore) {
		storeDao.updateStore(currentStore);
	}

	@Override
	public List<City> findAllCities() throws ServiceException {

		try {
			return storeDao.getAllCities();
		} catch (DAOException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<Store> findAllStores() throws ServiceException {

		try {
			return storeDao.getAllStores();
		} catch (DAOException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public City findCityById(long id) throws ServiceException {
		try {
			return storeDao.getCityById(id);
		} catch (DAOException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
