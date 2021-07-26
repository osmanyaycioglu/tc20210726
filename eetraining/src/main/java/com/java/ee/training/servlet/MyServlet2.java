package com.java.ee.training.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myservlet2")
public class MyServlet2 extends HttpServlet {

    private static final long serialVersionUID = -6199980274541168986L;

    @Override
    protected void doGet(final HttpServletRequest reqParam,
                         final HttpServletResponse respParam) throws ServletException, IOException {
        System.out.println("myservlet2 GET Method");
    }

}
