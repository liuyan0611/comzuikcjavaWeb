package com.zuikc.Servlets;

import com.zuikc.PageBean;
import com.zuikc.User;
import com.zuikc.implLoginService.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/listServlet")
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        Map<String, String[]> condiction = request.getParameterMap();


        Service service = new Service();
        PageBean<User> pageBean = service.getPageBean(currentPage,pageSize,condiction);
        request.setAttribute("pageBean", pageBean);
        request.setAttribute("condiction", condiction);
        request.getRequestDispatcher("/indexMaintain.jsp").forward(request, response);
    }
}
