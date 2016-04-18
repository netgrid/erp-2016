package it.netgrid.erp.rest.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.codearte.jfairy.Fairy;
import it.netgrid.erp.model.RegistryGroup;

@Path("/registry")
public class RegistryResource {

	@GET
	@Path("groups")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<RegistryGroup> getRegistryGroups() {
		List<RegistryGroup> retval = new ArrayList<>();
		Fairy fairy = Fairy.create();
		
		for(long i=0; i<fairy.baseProducer().randomBetween(3, 10); i++) {
			RegistryGroup group = new RegistryGroup();
			group.setId(i+1);
			group.setHidden(false);
			group.setName(fairy.textProducer().word());
			retval.add(group);
		}
		
		return retval;
	}
}
