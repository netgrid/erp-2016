package it.netgrid.erp.rest;

import javax.servlet.ServletContext;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.guice.web.ShiroWebModule;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.PropertiesRealm;
import org.apache.shiro.util.SimpleByteSource;

public class BootstrapInMemoryShiroModule extends ShiroWebModule {
	
	private static final int HASH_ITERATIONS = 7;
	private static final String PRIVATE_SALT = "Duis et molestie est, in faucibus ex. Nulla venenatis nisi sem, bibendum pulvinar tortor accumsan nec. Fusce hendrerit, justo in posuere consequat, orci arcu venenatis est, sit amet rhoncus felis nisl in lorem. Morbi ultrices, turpis et aliquam tempor, dui eros gravida tortor, vel rutrum augue leo eu risus. Pellentesque ex nisi, porta efficitur luctus ac, ultricies rutrum arcu. Praesent vitae neque ullamcorper odio facilisis viverra viverra vel orci. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Donec sagittis nulla ut lorem scelerisque viverra. Pellentesque a venenatis urna.";
	//private static final String AUTH_QUERY = "SELECT pas_password FROM dbe_accounts_passwords WHERE pas_login = ?";
	//private static final String ROLES_QUERY = "SELECT gro_name FROM dbe_accounts_groups_view WHERE acc_login = ?";
	//private static final String PERM_QUERY = "SELECT 'all'";
	//private static final String JDBC_URL = "jdbc:h2:mem:siquri";
	//private static final String JDBC_PASSWORD = null;
	//private static final String JDBC_USER = null;
	
	private final PasswordService passwordService;
	
	public BootstrapInMemoryShiroModule(ServletContext servletContext) {
		super(servletContext);
		DefaultHashService hashService = new DefaultHashService();
		hashService.setHashIterations(HASH_ITERATIONS);
		hashService.setHashAlgorithmName(Sha256Hash.ALGORITHM_NAME);
		hashService.setPrivateSalt(new SimpleByteSource(PRIVATE_SALT));
		hashService.setGeneratePublicSalt(true);

		DefaultPasswordService passwordService = new DefaultPasswordService();
		passwordService.setHashService(hashService);
		this.passwordService = passwordService;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void configureShiroWeb() {
		//JdbcDataSource h2 = new JdbcDataSource();
		//h2.setURL(JDBC_URL);
		//h2.setUser(JDBC_USER);
		//h2.setPassword(JDBC_PASSWORD);
		
		//JdbcRealm realm = new JdbcRealm();
		//realm.setDataSource(h2);
		//realm.setAuthenticationQuery(AUTH_QUERY);
		//realm.setUserRolesQuery(ROLES_QUERY);
		//realm.setPermissionsQuery(PERM_QUERY);
		
		PropertiesRealm realm = new PropertiesRealm();
		realm.setResourcePath("classpath:auth.properties");
		
		PasswordMatcher matcher = new PasswordMatcher();
		matcher.setPasswordService(this.passwordService);
		realm.setCredentialsMatcher(matcher);
		
		bindRealm().toInstance(realm);
        addFilterChain("/**", ANON);
	}

}
