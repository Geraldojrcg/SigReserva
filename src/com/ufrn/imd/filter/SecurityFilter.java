package com.ufrn.imd.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ufrn.imd.model.Usuario;

/**
 * Servlet Filter implementation class SecurityFilter
 */
@WebFilter("/pages/*")
public class SecurityFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SecurityFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		Usuario usuarioLogado = (Usuario) req.getSession().getAttribute("usuarioLogado");
		
		if(usuarioLogado == null) {
			res.sendRedirect("/SigReserva/login.jsf");
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
