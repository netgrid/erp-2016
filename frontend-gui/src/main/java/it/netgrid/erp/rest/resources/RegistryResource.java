package it.netgrid.erp.rest.resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;

import it.netgrid.erp.model.RegistryGroup;
import it.netgrid.erp.rest.api.CrudService;

@Path("/registry")
public class RegistryResource {

	private final CrudService<RegistryGroup, Long> registryGroupService;
	private final Dao<RegistryGroup, Long> registryGroupDao;
	
	@Inject
	public RegistryResource(CrudService<RegistryGroup, Long> registryGroupService, Dao<RegistryGroup, Long> registryGroupDao) {
		this.registryGroupService = registryGroupService;
		this.registryGroupDao = registryGroupDao;
	}
	
	@GET
	@Path("groups")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<RegistryGroup> getRegistryGroups(@Context HttpHeaders headers) throws SQLException {
		return this.registryGroupDao.queryForAll();
	}
	
	@PUT
	@Path("groups")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public RegistryGroup updateRegistryGroup(@Context HttpHeaders headers, RegistryGroup group) throws IllegalArgumentException, SQLException {
		this.registryGroupService.update(group);
		return group;
	}
	
	@POST
	@Path("groups")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public RegistryGroup createRegistryGroup(@Context HttpHeaders headers, RegistryGroup group) throws IllegalArgumentException, SQLException {
		this.registryGroupService.create(group);
		return group;
	}
	
	@DELETE
	@Path("groups/{id}")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public RegistryGroup deleteRegistryGroup(@Context HttpHeaders headers, @PathParam("id") Long groupId) throws IllegalArgumentException, SQLException {
		RegistryGroup group = this.registryGroupService.read(groupId);
		this.registryGroupService.delete(group);
		return group;
	}
}
