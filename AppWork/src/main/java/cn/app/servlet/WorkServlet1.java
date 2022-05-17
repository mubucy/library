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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/WorkServlet1")
public class WorkServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符，防止中文乱码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
 
        //转换字符串
        String workname = request.getParameter("workname");
        String author = request.getParameter("author");
       
        WorkManage wm = new WorkManageLmpl();
 
        
        boolean flag = wm.SearchWork(workname);
        if(flag){
        //提取该作品所有词条
    		//创建链接 Connection对象 Statement对象和ResultSet对象
    		Connection conn = null;
    		Statement st = null;
    		ResultSet rs = null;
    		PreparedStatement ps = null;
    		
    		System.out.println("成功31");
    		//调用相关方法，连接数据库及处理数据库的查
    		String sql = "select * from appwork where workname LIKE'%"+workname+"%'";
    		
    		conn = cn.app.conn.DataConnect.getConnection();
    		System.out.println("成功32");
    		try {    
    			st = conn.createStatement();
    			rs = st.executeQuery(sql);
    			System.out.println("成功32");
    			while(rs.next()) {
    				
    					System.out.println("成功33");
    					//String a=rs.getString("author");
    					
    					//将提交的用户名存入session，jsp页面调取
    		            HttpSession session = request.getSession();
    		            session.setAttribute("workname", rs.getString("workname"));//修改
    		            session.setAttribute("author", rs.getString("author"));
    		            session.setAttribute("workid", rs.getInt("workid"));
    		            session.setAttribute("ISBN", rs.getLong("ISBN"));
    			}
    		}catch (SQLException e) {
    			e.printStackTrace();
    		}finally {
    			cn.app.conn.DataConnect.close(rs, st,conn);
    		}
    		
            
            //登录成功后跳转
            response.sendRedirect("SearchSucceed.jsp");
        }else{
            response.sendRedirect("SearchFailed.jsp");
        }
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
