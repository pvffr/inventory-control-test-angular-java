package br.com.paulorezende.inventorycontrol.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class CORSFilter implements Filter {
	
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		
		response.addHeader("Access-Control-Allow-Origin", "*"); 
		response.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, OPTIONS, X-XSRF-TOKEN"); 
		response.addHeader("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type");
		
		chain.doFilter(req, res);
	}

	public void init(FilterConfig filterConfig) {
		
	}

	public void destroy() {
		
	}

}
