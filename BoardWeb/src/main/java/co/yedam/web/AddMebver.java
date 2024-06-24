package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.MemberVO;

public class AddMebver implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Multipart요청 (1. 요청정보 2.저장위치 3. 최대크기 4. 인코딩 5.리네임 정책)
		String savePath = req.getServletContext().getRealPath("images");
		int maxSize = 1024 * 1024 * 5;
		String encoding = "utf-8";

		MultipartRequest mr = new MultipartRequest(req, savePath, maxSize, encoding, new DefaultFileRenamePolicy());

		String id = mr.getParameter("id");
		String pw = mr.getParameter("pw");
		String nm = mr.getParameter("nm");
		String img = mr.getFilesystemName("myImage");

		MemberVO mvo = new MemberVO();
		mvo.setUserId(id);
		mvo.setUserPw(pw);
		mvo.setUserName(nm);
		mvo.setImage(img);
		System.out.println(mvo);

		BoardService svc = new BoardServiceImpl();
		try {
			if (svc.addMemberImage(mvo)) {
				resp.sendRedirect("memberList.do");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
