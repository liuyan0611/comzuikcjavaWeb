//package com.zuikc.Filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter("/*")
//public class Filter implements javax.servlet.Filter {
//    public void destroy() {
//    }
//
//    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) resp;
//        String uri = request.getRequestURI();
//        System.out.println(uri);
//        chain.doFilter(request, response);
//        if (uri.contains("/login.jsp") || uri.contains("/checkCodeServlet") || uri.contains("/loginCheckCodeAjaxServlet") || uri.contains("/loginServlet")||uri.contains("/css/")||uri.contains("/js/")||uri.contains("/font/")) {
//
//            chain.doFilter(req, resp);
//        } else {
//            Object username = request.getSession().getAttribute("user");
//            System.out.println(username);
//            if (username != null) {
//                chain.doFilter(req, resp);
//            } else {
////                request.getRequestDispatcher("/login.jsp").forward(request, response);
//                response.sendRedirect("/login.jsp");
//            }
////
//        }
//    }
//
//
//    public void init(FilterConfig config) throws ServletException {
//
//    }
//
//}
