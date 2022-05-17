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
 
        //ת���ַ���
        String username = request.getParameter("username");
        String password = request.getParameter("password");
 
        
        UserManage um = new UserManageImpl();
        User u = new User();
 
        //����û��ύ�����ݵ����ݿ�
        u.setName(username);
        u.setPassword(password);
 
        //��������ת��Ӧҳ��
        boolean flag = um.newu(u,username);
        if(flag){
            //�޸ĳɹ�����ת
            response.sendRedirect("Login.jsp");
        }else{
            response.sendRedirect("UpdateFailed.jsp");
        }
 
 
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}