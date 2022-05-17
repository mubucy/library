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
 
@WebServlet("/update")
public class Update extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
 
        //转换字符串
        String username = request.getParameter("username");
        String password = request.getParameter("password");
 
        
        UserManage um = new UserManageImpl();
        User u = new User();
 
        //添加用户提交的数据到数据库
        u.setName(username);
        u.setPassword(password);
 
        //处理结果跳转相应页面
        boolean flag = um.newu(u,username);
        if(flag){
            //修改成功后跳转
            response.sendRedirect("Login.jsp");
        }else{
            response.sendRedirect("UpdateFailed.jsp");
        }
 
 
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}