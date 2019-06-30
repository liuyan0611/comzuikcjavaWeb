package com.zuikc.LoginServlet;

import com.zuikc.LoginUser;
import com.zuikc.implLoginService.LoginService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        String checkCode_session = (String) request.getSession().getAttribute("checkCode_session");
        request.getSession().removeAttribute("checkCode_session");
        LoginService loginService = new LoginService();
        String s = loginService.selectUsernameService(username);
        String p = loginService.selectUserPasswordService(username);


        if (checkCode!=null&&!checkCode.equals("")){
            if (checkCode.equalsIgnoreCase(checkCode_session)){
                if (username!=null){
                    if (username.equals(s)&&password.equals(p)){
//                        Map<String, String[]> parameterMap = request.getParameterMap();
//                        LoginUser user = new LoginUser();
//                        try {
//                            BeanUtils.populate(user, parameterMap);
//                            int re = loginService.insertLoginUser(user);
                            response.sendRedirect("/indexMap.jsp");
                            request.getSession().setAttribute("user", username);
//                            if (re>0){
//                                System.out.println("insert LoginUser success!");
//                            }
//                        } catch (IllegalAccessException e) {
//                            e.printStackTrace();
//                        } catch (InvocationTargetException e) {
//                            e.printStackTrace();
//                        }
                    }else {
                        request.setAttribute("msg", "用户名密码不匹配！");
                        request.getRequestDispatcher(request.getContextPath()+"/login.jsp").forward(request, response);
                    }

                }else {
                    request.setAttribute("msg", "用户名不能为空！");
                    request.getRequestDispatcher(request.getContextPath()+"/login.jsp").forward(request, response);
                }
            }
            else {
                request.setAttribute("msg", "验证码错误！");
                request.getRequestDispatcher(request.getContextPath()+"/login.jsp").forward(request, response);
            }
        }
    }
}
