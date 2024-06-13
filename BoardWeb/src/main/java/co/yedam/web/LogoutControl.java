package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Control;

public class LogoutControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//정보들을 넣어놓고 계속 공유함.
		HttpSession session = req.getSession();
		//톰캣이 가지고 있다가 지움
		//어트리뷰트 값을 초기화 시킴
		session.invalidate(); //세션 정보 삭제.

		resp.sendRedirect("loginForm.do");
	}

}
