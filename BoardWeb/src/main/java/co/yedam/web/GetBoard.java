package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class GetBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String bno = req.getParameter("bno");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		String page = req.getParameter("page");
		
		BoardService svc = new BoardServiceImpl();
	    BoardVO brd = svc.getBoard(Integer.parseInt(bno));
	    
	    req.setAttribute("board", brd);
	    req.setAttribute("searchCondition",sc);
	    req.setAttribute("keyword", kw);
	    req.setAttribute("page", page);
	    
	    req.getRequestDispatcher("board/borad.tiles").forward(req,resp);
	}

}
