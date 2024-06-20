package co.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.MemberVO;

public class MenberAddAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라메터 4개 아이디 패스워드 권한.. -> DB입력 -> OK반환
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String nm = req.getParameter("nm");
		String auth = req.getParameter("auth");
		
		MemberVO mvo = new MemberVO();
		mvo.setUserId(id);
		mvo.setUserPW(pw);
		mvo.setUserName(nm);
		mvo.setResponsibility(auth);

		BoardService svc = new BoardServiceImpl();
		if(svc.addMemberAjax(mvo)) {//{"retCode": "OK", "retMsg": "Success"}
			resp.getWriter().print("{\"retCode\": \"OK\", \"retMsg\": \"Success\"}");
		}else { //{"retCode": "NG", "retMsg": "Fail"}
			resp.getWriter().print("{\"retCode\": \"NG\", \"retMsg\": \"Fail\"}");
			
		}
	}

}