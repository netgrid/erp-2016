package it.netgrid.erp.rest.api;

import java.sql.SQLException;



import org.apache.commons.lang3.Validate;

import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;

import it.netgrid.erp.model.Order;
import it.netgrid.erp.model.OrderItem;
import it.netgrid.erp.model.dto.OrderRoot;

public class OrderRootService extends TemplateCrudService<OrderRoot, Long> {

	private Dao<Order, Long> orderDao;
	private Dao<OrderItem, Long> itemDao;
	
	@Inject
	public OrderRootService(ConnectionSource connection, Dao<Order, Long> orderDao, Dao<OrderItem, Long> itemDao) {
		super(connection);
		this.orderDao=orderDao;
		this.itemDao=itemDao;
	}

	@Override
	public int createRaw(OrderRoot order) throws SQLException, IllegalArgumentException {
		int result=0;

		return result;
	}

	@Override
	public int updateRaw(OrderRoot order) throws SQLException, IllegalArgumentException {
		
		return 0;
	}

	@Override
	public int deleteRaw(OrderRoot order) throws SQLException, IllegalArgumentException {
		
		return 0;
	}

	@Override
	public OrderRoot read(Long key) throws SQLException {
		
		return null;
	}


}
