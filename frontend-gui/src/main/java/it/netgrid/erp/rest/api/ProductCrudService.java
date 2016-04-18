package it.netgrid.erp.rest.api;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.sun.xml.bind.v2.model.core.ID;

import it.netgrid.erp.model.CrudObject;
import it.netgrid.erp.model.Product;

public class ProductCrudService extends TemplateCrudService<Product, Long>{
	
	private Dao<Product, Long> dao;

	protected ProductCrudService(ConnectionSource connection, Dao<Product, Long> dao) {
		super(connection);
		this.dao = dao;
	}

	@Override
	public int createRaw(Product object) throws SQLException, IllegalArgumentException {
			if(object.getPrice() != null){
				if(object.getProduct() != null){
					if(object.getQuantity() != null){
						if(object.getUnitOfMeasure() != null){
							return dao.create(object);
						}	
						else{
							return 1;
						}
					}
					else{
						return 1;
					}
				}
				else{
					return 1;
				}
			}
			else{
				return 1;
			}
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
