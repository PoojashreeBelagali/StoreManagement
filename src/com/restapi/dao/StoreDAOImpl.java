package com.restapi.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.restapi.entity.City;
import com.restapi.entity.Store;
import com.restapi.exception.DAOException;

/**
 * @author Poojashree B
 *
 */
@Repository
public class StoreDAOImpl implements StoreDAO {
	private Logger LOGGER = Logger.getLogger(getClass());
	private HibernateTemplate hibernateTemplate;

	/**
	 * SessionFactory is injected using IoC Create Hibernate Template using
	 * SessionFactory
	 * 
	 * @param factory
	 *            sessionfactory injected by Spring container
	 */
	@Autowired
	public void setSessionFactory(SessionFactory factory) {
		LOGGER.debug("Dependency injection of SessionFactory: " + factory);
		hibernateTemplate = new HibernateTemplate(factory);
	}

	@Override
	public Store findStoreById(long id) {

		return hibernateTemplate.get(Store.class, id);
	}

	@Override
	public boolean isStoreExist(Integer storeId) {
		Store store = hibernateTemplate.get(Store.class, storeId);
		if (store != null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void saveStore(Store store) {
		hibernateTemplate.save(store);
	}

	@Override
	public void updateStore(Store currentStore) {
		hibernateTemplate.saveOrUpdate(currentStore);

	}

	@Override
	public void deleteStore(long id) throws DAOException {
		try {
			hibernateTemplate.delete("Store", Store.class);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new DAOException(e.getMessage(), e);
		}
		
	}

	@Override
	public List<City> getAllCities() throws DAOException {
		List<City> cities = null;
		try {
			cities = hibernateTemplate.loadAll(City.class);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new DAOException(e.getMessage(), e);
		}
		return cities;
	}

	@Override
	public List<Store> getAllStores() throws DAOException {
		List<Store> stores = null;
		try {
			stores = hibernateTemplate.loadAll(Store.class);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new DAOException(e.getMessage(), e);
		}
		return stores;
	}

	@Override
	public City getCityById(long id) throws DAOException {
		return hibernateTemplate.get(City.class, id);
	}
}
