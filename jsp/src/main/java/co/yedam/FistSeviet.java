package co.yedam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FistSeviet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FistSeviet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); //입력값 중에 한글 표기
		PrintWriter out = response.getWriter();//출력스트림
		String id = request.getParameter("id"); //input name ="id"
		String pw = request.getParameter("pw");
		
		out.print("안녕하세용");
		out.print("<a href = 'index.html'>인덱스 페이지로 이동</");
		out.print("<p>입력한 아이디 : " + id + "</p>");
		out.print("<p>입력한 비번 : " + pw + "</p>");
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); //입력값 중에 한글 표기
		//	doGet(request, response);
		String no = request.getParameter("StdNo");
		String name = request.getParameter("StdName");
		String phone = request.getParameter("phone");
		String btype = request.getParameter("btype");
		
		Student std = new Student();
		std.setBldType(btype);
		std.setPhone(phone);
		std.setStdName(name);
		std.setStdNo(no);
		
		
		PrintWriter out = response.getWriter();
		StudentDAO sdao = new StudentDAO();
		if (sdao.insertStudent(std)) {
			out.print("<b>OK</b>");
		}else {
			out.print("<b>Fail</b>");
		}
	}

}
