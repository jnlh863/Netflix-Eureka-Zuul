package com.microservice.zuul.filters;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class TimePreFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(TimePreFilter.class);
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		StringBuffer strLog=new StringBuffer();
	    strLog.append("\n------ NUEVA PETICION ------\n");	    	    	    
	    strLog.append(String.format("Metodo: %s Path: %s \n"	    		 
					,ctx.getRequest().getMethod(),
					ctx.getRequest().getRequestURI()));
	    Enumeration<String> enume= ctx.getRequest().getHeaderNames();
		 String header;
		 while (enume.hasMoreElements())
		 {
			 header=enume.nextElement();
			 strLog.append(String.format("Headers: %s = %s \n",header,ctx.getRequest().getHeader(header)));	    			
		 };	  	    
		 log.info(strLog.toString());
		
		//log.info(String.format("%s request enrutado a %s", request.getMethod(), request.getRequestURL().toString()));
		
		Long tiempoInicio = System.currentTimeMillis();
		request.setAttribute("tiempoInicio", tiempoInicio);
		
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}
	

}
