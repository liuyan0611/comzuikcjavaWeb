package com.zuikc.LoginServlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/loginCheckCodeAjaxServlet")
public class LoginCheckCodeAjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String checkCode = request.getParameter("checkCode");
        String checkCode_session = (String) request.getSession().getAttribute("checkCode_session");
        Map<String,Object> map = new HashMap<>();
        if (checkCode!=null&&!checkCode.equals("")){
            if (checkCode.equalsIgnoreCase(checkCode_session)){
                map.put("exsit", true);
                map.put("msg", "验证码正确");

            }else {
                map.put("exsit", false);
                map.put("msg", "验证码错误");

            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getWriter(), map);
        }
    }
}
