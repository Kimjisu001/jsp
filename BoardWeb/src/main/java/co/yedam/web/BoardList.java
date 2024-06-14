package co.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.common.PageDTO;
import co.yedam.common.SearchVO;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class BoardList implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");

		// 파라메타 안넘어 오면 1페이지라도 보여지도록 함.
		page = page == null ? "1" : page;
		// 검색 조건들을 담는 SearchVO
		SearchVO search = new SearchVO(Integer.parseInt(page), sc, kw);

		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.boardList(search);

		req.setAttribute("boardList", list);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);

		// paging 계산
		int totalCnt = svc.boardTotal(search); // 25페이지
		PageDTO dto = new PageDTO(Integer.parseInt(page), totalCnt);
		req.setAttribute("paging", dto);

		req.getRequestDispatcher("board/boardList.tiles").forward(req, resp);

	}
}
