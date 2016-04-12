package it.netgrid.erp.rest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

@Path("/version")
public class VersionResource {
	
	@XmlRootElement
	public static class SystemVersion {
		
		private  String name;
		private String version;
		private String minor;
		
		public SystemVersion() {}
		
		public SystemVersion(String name, String version, String minor) {
			this.name = name;
			this.version = version;
			this.minor = minor;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		public String getMinor() {
			return minor;
		}

		public void setMinor(String minor) {
			this.minor = minor;
		}
		
	}
	
	public static final String NAME = "Test Service";
	public static final String VERSION = "1.0";
	
	@GET
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public SystemVersion getVersionInfo(@Context HttpHeaders headers) {	
		SystemVersion retval = new SystemVersion(NAME, VERSION, "1");
		return retval;
	}
}
