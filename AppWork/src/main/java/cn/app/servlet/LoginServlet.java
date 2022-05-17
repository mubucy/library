package cn.app.servlet;


import cn.app.service.*;
import cn.app.model.*;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
 
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
 
        //转换字符串
        String username = request.getParameter("username");
        String password = request.getParameter("password");
 
        
        UserManage um = new UserManageImpl();
 
        
        boolean flag = um.checkLogin(username, password);
        if(flag){
            //将提交的用户名存入session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
 
            //登录成功后跳转
            response.sendRedirect("LoginSucceed.jsp");
        }else{
            response.sendRedirect("LoginFailed.jsp");
        }
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}