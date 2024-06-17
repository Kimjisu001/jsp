package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");

		BoardService svc = new BoardServiceImpl();

		// 관리자면 관리자 페이지, 일반회원이면 일반 페이지로 보여주기
		MemberVO mvo = svc.checkMember(id, pw);
		if (mvo != null) { // 아이디가 맞고 비번이 맞으면
			// 로그인.
			HttpSession session = req.getSession();
			session.setAttribute("logId", id);

			if (mvo.getResponsibility().equals("User")) {
				resp.sendRedirect("main.do");// 메인두로 이동
			} else if (mvo.getResponsibility().equals("Admin")) {
				resp.sendRedirect("memberList.do");// 메인두로 이동
			}
		} else {
			resp.sendRedirect("loginForm.do");// 메인두로 이동

		}

	}
}