package com.zxl.filter.config;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

@Component
@Order(1)
@WebFilter(filterName = "pageSizeFilter", urlPatterns = "/*")
public class PageSizeFilter implements Filter {

    int maxPageSize = 50;
    /**
     * 分页参数常量
     */
    private String PAGE_SIZE = "pageSize";

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(new HttpServletRequestWrapper((HttpServletRequest) request) {
            @Override
            public String[] getParameterValues(String name) {
                if (PAGE_SIZE.equals(name)) {
                    int pageSize = Integer.valueOf(super.getParameter(PAGE_SIZE));
                    if (pageSize > maxPageSize) {
                        return new String[]{String.valueOf(maxPageSize)};
                    }
                }
                return super.getParameterValues(name);
            }
        }, response);
    }

    @Override
    public void destroy() {

    }
}