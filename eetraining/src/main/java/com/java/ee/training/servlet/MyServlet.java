package com.java.ee.training.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import javax.enterprise.context.ApplicationScoped;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myservlet")
@ApplicationScoped
public class MyServlet implements Servlet {

    private final List<String>        strs    = new Vector<>();
    private final List<String>        strs2   = Collections.synchronizedList(new ArrayList<>());
    private final Map<String, String> map1    = new ConcurrentHashMap<>();
    private AtomicLong                counter = new AtomicLong();

    @Override
    public void destroy() {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void init(final ServletConfig arg0Param) throws ServletException {
        System.out.println("----------************** init ****************------------");
    }

    @Override
    public void service(final ServletRequest arg0Param,
                        final ServletResponse arg1Param) throws ServletException, IOException {
        List<String> strInternal = new ArrayList<>();
        counter.incrementAndGet();
        HttpServletRequest requestLoc = (HttpServletRequest) arg0Param;
        String methodLoc = requestLoc.getMethod();
        System.out.println("myservlet : " + methodLoc);
        HttpServletResponse response = (HttpServletResponse) arg1Param;
        this.strs.add("xyz");
        response.getWriter()
                .println("Hello world");
        response.addHeader("Content-Type",
                           "text/plain");

    }

}
