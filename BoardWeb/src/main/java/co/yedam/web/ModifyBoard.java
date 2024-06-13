package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class ModifyBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		BoardVO bvo = new BoardVO();
		bvo.setBoardNo(Integer.parseInt(bno));
		bvo.setTitle(title);
		bvo.setContent(content);

		BoardService svc = new BoardServiceImpl();
		if (svc.updateBoard(bvo)) {
			resp.sendRedirect("boardList.do");
		} else {
			req.getRequestDispatcher("WEB-INF/view/modifyBoardForm.jsp").forward(req, resp);
		}

	}

}
