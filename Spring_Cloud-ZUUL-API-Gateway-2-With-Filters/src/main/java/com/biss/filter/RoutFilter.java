package com.biss.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class RoutFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("from ROUTE FILTER LOGIC");
		//check req/resp matching data
		RequestContext context=RequestContext.getCurrentContext();
		HttpServletRequest req=context.getRequest();
		HttpServletResponse resp=context.getResponse();
		if(req.getContentLength()>0 && req.getContentType().equals(resp.getContentType())) {
			//logic / log message
		}
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return FilterConstants.ROUTE_TYPE;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
