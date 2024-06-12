package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class AddBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		BoardVO bd = new BoardVO();
		bd.setTitle(req.getParameter("title"));
		bd.setWriter(req.getParameter("writer"));
		bd.setContent(req.getParameter("content"));
		
		
		BoardService svc = new BoardServiceImpl();
		
		if (svc.addBoard(bd)) {
			System.out.println("정상적으로 등록");
			resp.sendRedirect("main.do");
		} else {
			System.out.println("등록 실패");
			req.setAttribute("message", "처리중 오류 발생");
			req.getRequestDispatcher("WEB-INF/view/boardForm.jsp").forward(req, resp);
		}
	}
	}
