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
        //�����ַ�����ֹ��������
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
 
        //ת���ַ���
        String workname = request.getParameter("workname");
        String author = request.getParameter("author");
       
        WorkManage wm = new WorkManageLmpl();
 
        
        boolean flag = wm.SearchWork(workname);
        if(flag){
        //��ȡ����Ʒ���д���
    		//�������� Connection���� Statement�����ResultSet����
    		Connection conn = null;
    		Statement st = null;
    		ResultSet rs = null;
    		PreparedStatement ps = null;
    		
    		System.out.println("�ɹ�31");
    		//������ط������������ݿ⼰�������ݿ�Ĳ�
    		String sql = "select * from appwork where workname LIKE'%"+workname+"%'";
    		
    		conn = cn.app.conn.DataConnect.getConnection();
    		System.out.println("�ɹ�32");
    		try {    
    			st = conn.createStatement();
    			rs = st.executeQuery(sql);
    			System.out.println("�ɹ�32");
    			while(rs.next()) {
    				
    					System.out.println("�ɹ�33");
    					//String a=rs.getString("author");
    					
    					//���ύ���û�������session��jspҳ���ȡ
    		            HttpSession session = request.getSession();
    		            session.setAttribute("workname", rs.getString("workname"));//�޸�
    		            session.setAttribute("author", rs.getString("author"));
    		            session.setAttribute("workid", rs.getInt("workid"));
    		            session.setAttribute("ISBN", rs.getLong("ISBN"));
    			}
    		}catch (SQLException e) {
    			e.printStackTrace();
    		}finally {
    			cn.app.conn.DataConnect.close(rs, st,conn);
    		}
    		
            
            //��¼�ɹ�����ת
            response.sendRedirect("SearchSucceed.jsp");
        }else{
            response.sendRedirect("SearchFailed.jsp");
        }
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
