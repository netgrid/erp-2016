package it.netgrid.erp.rest.aspects;

import java.util.List;
import java.util.Locale;

import javax.ws.rs.core.HttpHeaders;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


/**
 * To support AspectJ properly you should install http://download.eclipse.org/tools/ajdt/44/dev/update/
 * and 
 * m2e AspectJ connector plugin in eclipse
 * 
 * In order to enable Aspects waving at load time add this variable to Maven run configuration:
 * Run Configurations... -> Maven Build -> New
 * 	Name: Jetty_Run
 * 	Main -> Goals: jetty:run
 *  Envrinoment -> New
 *     Variable Name:  MAVEN_OPTS 
 *     Variable Value: -javaagent:lib/aspectjweaver-1.8.6.jar
 *     
 * Apply configuration. Run application in Debug or Release mode using this maven configuration.
 */

@Aspect
public class VersionAspect {
	
	@Pointcut("@annotation(javax.ws.rs.GET) || @annotation(javax.ws.rs.POST) || @annotation(javax.ws.rs.PUT) || @annotation(javax.ws.rs.DELETE)")
	public void crudEntryPoint() {}
	
	@Before("crudEntryPoint() && args(httpHeaders,..)")
    public void httpHeadersToSession(JoinPoint joinPoint, HttpHeaders httpHeaders) {
		Session session = SecurityUtils.getSubject().getSession();
		Locale locale = this.getLocale(httpHeaders);
		String domain = this.getDomain(httpHeaders);
		//session.setAttribute(ShiroSessionProvider.CURRENT_HEADER_LANG_KEY, locale);
		//session.setAttribute(ShiroSessionProvider.CURRENT_DOMAIN_KEY, domain);
    }
	
	public String getDomain(HttpHeaders headers) {
		List<String> hostnames = headers.getRequestHeader(HttpHeaders.HOST);
		return hostnames.get(0);
	}
	
	public Locale getLocale(HttpHeaders headers) {
/* 		List<Locale> locales = headers.getAcceptableLanguages();
		if(locales.isEmpty()) {
			return null;
		}
		
		for(Locale locale : locales) {
			if(Localization.LOCALES.contains(locale)) {
				return locale;
			}
		}
		*/
		return null;
	}
}
