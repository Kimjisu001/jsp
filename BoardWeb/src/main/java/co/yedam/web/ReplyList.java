package co.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.service.ReplyService;
import co.yedam.service.ReplyServiceImpl;
import co.yedam.vo.ReplyVO;

public class ReplyList implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//한글로 댓글 나오게 하기
		resp.setContentType("text/josn;charset=utf-8");
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		
		page = page == null ? "1" : page;
		//댓글 목록.
		ReplyService svc = new ReplyServiceImpl();
		List<ReplyVO> list = svc.replyList(Integer.parseInt(bno),Integer.parseInt(page));
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create(); //gson 객체생성(외워)
		String json = gson.toJson(list);//객체-> 문자열
		//{"test":"a"} => json
		//{ test :"a"} => 객체
		resp.getWriter().print(json);//사용자 웹브라우저 출력
	}

}
