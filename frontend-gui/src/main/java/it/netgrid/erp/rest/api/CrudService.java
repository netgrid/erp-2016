package it.netgrid.erp.rest.api;

import java.sql.SQLException;

import it.netgrid.erp.model.CrudObject;

public interface CrudService<T extends CrudObject<ID>, ID> {
	public T create(T object) throws SQLException, IllegalArgumentException;
	public T read(ID key) throws SQLException, IllegalArgumentException;
	public T update(T object) throws SQLException, IllegalArgumentException;
	public T delete(T object) throws SQLException, IllegalArgumentException;
	
	public int createRaw(T object) throws SQLException, IllegalArgumentException;
	public int updateRaw(T object) throws SQLException, IllegalArgumentException;
	public int deleteRaw(T object) throws SQLException, IllegalArgumentException;
}