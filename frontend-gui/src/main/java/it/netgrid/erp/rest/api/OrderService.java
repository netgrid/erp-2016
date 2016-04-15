package it.netgrid.erp.rest.api;

import java.sql.SQLException;

import com.j256.ormlite.support.ConnectionSource;

import it.netgrid.erp.model.Order;

public class OrderService extends TemplateCrudService<Order, Long> {

	protected OrderService(ConnectionSource connection) {
		super(connection);
	}

	@Override
	public int createRaw(Order order) throws SQLException, IllegalArgumentException {
		
		return 0;
	}

	@Override
	public int updateRaw(Order order) throws SQLException, IllegalArgumentException {
		
		return 0;
	}

	@Override
	public int deleteRaw(Order order) throws SQLException, IllegalArgumentException {
		
		return 0;
	}

	@Override
	public Order read(Long key) throws SQLException {
		
		return null;
	}


}
