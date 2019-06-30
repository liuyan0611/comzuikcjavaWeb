package com.zuikc.Servlets;

import com.zuikc.User;
import com.zuikc.implLoginService.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/idServlet")
public class IdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String[] uids = request.getParameterValues("uid");

        if(uids == null ){
            response.sendRedirect("listServlet?currentPage=1&pageSize=5");
            return;
        }

            Service service = new Service();
            User user = service.selectUserServiceById(uids);

            request.setAttribute("user", user);
            request.getRequestDispatcher("/update.jsp").forward(request, response);


    }
}
