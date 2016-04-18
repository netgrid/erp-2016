package it.netgrid.erp.rest.api;

import java.sql.SQLException;

import org.apache.commons.lang3.Validate;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorResources;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.sun.xml.bind.v2.model.core.ID;

import it.netgrid.erp.model.CrudObject;
import it.netgrid.erp.model.Product;

public class ProductCrudService extends TemplateCrudService<Product, Long>{
	
	private Dao<Product, Long> dao;
	
	Validate validator = new Validate();

	protected ProductCrudService(ConnectionSource connection, Dao<Product, Long> dao) {
		super(connection);
		this.dao = dao;
	}
	 
	@Override
	public int createRaw(Product object) throws SQLException, IllegalArgumentException {
			validator.notNull(object.getUnitOfMeasure());
			validator.notNull(object.getProduct());
			return dao.create(object);
	}

	@Override
	public int updateRaw(Product object) throws SQLException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRaw(Product object) throws SQLException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Product read(Long key) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	

}
