package it.netgrid.erp.rest;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Singleton;

@Singleton
public class CORSServletFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// NOTHING TO DO
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;
		res.setHeader("Access-Control-Allow-Origin", "*");
		res.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		res.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Netgrid");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// NOTHING TO DO
	}

}
