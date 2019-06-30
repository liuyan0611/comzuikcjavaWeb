package com.zuikc.Servlets;

import com.zuikc.User;
import com.zuikc.implLoginService.Service;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, map);
            System.out.println(user);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Service service = new Service();
        int re = service.insertService(user);
        if (re>0){
//            request.setAttribute("msg", "信息添加成功");
//            request.getRequestDispatcher("/indexMaintain.jsp").forward(request, response);
//            response.sendRedirect("/indexMaintain.jsp");
            response.sendRedirect("listServlet?currentPage=1&pageSize=5");
        }
//        else {
//            request.setAttribute("msg", "信息添加失败");
//        }

    }
}
