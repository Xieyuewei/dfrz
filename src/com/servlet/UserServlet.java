package com.servlet;

import com.entity.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user.do")
public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request,response);
    }

//    注册
    public void register(HttpServletRequest request,HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User user = new User(username,password,email);
        int result = userService.register(user);
        System.out.println(result);
    }

//    登录
    public void login(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.login(new User(username,password,null));
        if (user != null){
//            登录成功
//            response.sendRedirect(request.getContextPath() + "/list.jsp");
            HttpSession session = request.getSession();
            session.setAttribute("user",user);

            request.getRequestDispatcher("/message.do?action=queryList").forward(request,response);;
        }else {
//            登录失败
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }
}
