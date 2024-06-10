package co.yedam;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 제어의 역전(IOC 제어하는 컨캣(서블릿 컨테이너)으로 주체가 바뀜)
// url -> tomcat -> 객체 생성 -> init -> service -> destory. 순서에 따라 만들어짐
public class SecondServlet extends HttpServlet {

	
	//서블릿의 생성주기
	//생성자
	public SecondServlet() {
		System.out.println("SecondServlet 생성자 호출.");
	}
	
	//실행
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("init 메소드 호출");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
		System.out.println("init 메소드 호출");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("init 메소드 호출");
	}
}
