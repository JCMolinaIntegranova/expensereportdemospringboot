package com.integranova.spring.expensereportdemo.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ApiVersionHeaderFilter implements Filter {

	private static final String APIVERSIONHEADER = "API-Version";
	private static final String APIVERSIONPARAM = "api.version";
	
	@Autowired
	private Environment env;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Do nothing
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String apiVersionHeader = httpServletRequest.getHeader(APIVERSIONHEADER);
		String apiVersion = env.getProperty(APIVERSIONPARAM);
		if (apiVersionHeader != null && !apiVersion.equalsIgnoreCase(apiVersionHeader)) {
			HttpServletResponse  customResponse= (HttpServletResponse) response;
			customResponse.setStatus(HttpStatus.OK.value());
			customResponse.getWriter().write("{ \"resultCode\": \"666\", \"resultDescription\": \"Unsupported version\"}");
			customResponse.getWriter().flush();
			customResponse.getWriter().close();
			return;
		}
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader(APIVERSIONHEADER, env.getProperty(APIVERSIONPARAM));
        chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// Do nothing
	}
}
