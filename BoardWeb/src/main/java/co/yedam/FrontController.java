package co.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.web.AddBoard;
import co.yedam.web.AddForm;
import co.yedam.web.AddMebver;
import co.yedam.web.AddReply;
import co.yedam.web.AddStudent;
import co.yedam.web.AjaxForm;
import co.yedam.web.BoardForm;
import co.yedam.web.BoardList;
import co.yedam.web.CenterChart;
import co.yedam.web.CenterInfo;
import co.yedam.web.ChartForm;
import co.yedam.web.GetBoard;
import co.yedam.web.LoginControl;
import co.yedam.web.LoginForm;
import co.yedam.web.LogoutControl;
import co.yedam.web.MainControl;
import co.yedam.web.MapFrom;
import co.yedam.web.MemberAjax;
import co.yedam.web.MemberList;
import co.yedam.web.MenberAddAjax;
import co.yedam.web.ModifyBoard;
import co.yedam.web.ModifyForm;
import co.yedam.web.ProductControl;
import co.yedam.web.PublicData;
import co.yedam.web.RemoveReply;
import co.yedam.web.ReplyList;
import co.yedam.web.StudentForm;
import co.yedam.web.scriptForm;

// front -> 요청url(*.do) - 실행컨트롤 매칭
// main.do -> FrontController -> /WEB-INF/public/main.jsp
// 객체생성 -> init -> service -> destroy
public class FrontController extends HttpServlet {

	private Map<String, Control> map; // key : url, value : control

	// 생성자
	public FrontController() {
		map = new HashMap<String, Control>();
	}

	@Override
	public void init() throws ServletException {
		// 메인페이지
		map.put("/main.do", new MainControl());
		map.put("/product.do", new ProductControl());
		// 학생 등록 화면 studentForm.do
		map.put("/studentForm.do", new StudentForm());// 등록화면
		map.put("/addStudent.do", new AddStudent());// 정보 db에 저장.
		// 게시글목록
		map.put("/boardList.do", new BoardList());
		// 상세화면
		map.put("/getBoard.do", new GetBoard());
		// 게시판등록
		map.put("/addForm.do", new BoardForm());
		map.put("/addBoard.do", new AddBoard());
		// 수정화면
		map.put("/modifyForm.do", new ModifyForm());
		map.put("/modifyBoard.do", new ModifyBoard());
		// 로그인 화면
		map.put("/loginForm.do", new LoginForm());
		// 로그인 기능
		map.put("/login.do", new LoginControl());
		// 로그아웃
		map.put("/logout.do", new LogoutControl());
		// 회원목록
		map.put("/memberList.do", new MemberList());

		// 자바스크립트 연습용 페이지
		map.put("/script.do", new scriptForm());

		// 자바스크립트 연습용 페이지
		map.put("/ajax.do", new AjaxForm());
		map.put("/membersAjax.do", new MemberAjax());
		map.put("/addAjax.do", new MenberAddAjax());

		// 댓글관련
		map.put("/replyListJson.do", new ReplyList());
		map.put("/removeReply.do", new RemoveReply());
		map.put("/addReply.do", new AddReply());

		// 공공자료 가져와서 활용
		map.put("/publicData.do", new PublicData());
		// 맵 경로 등록
		map.put("/map.do", new MapFrom());
		// json 문자열
		map.put("/centerInfo.do", new CenterInfo());
		// 센터 차트
		map.put("/ChartForm.do", new ChartForm());
		map.put("/centerChart.do", new CenterChart());
		map.put("/addMemberForm.do", new AddForm());
		map.put("/addMember.do", new AddMebver());

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI(); // url : http://localhost/BoardWeb/main.do
//		System.out.println("uri : " + uri);	// uri : /BoardWeb/main.do
		String context = req.getContextPath(); // project name
//		System.out.println("context : " + context);	// context : /BoardWeb
		String page = uri.substring(context.length());
//		System.out.println("page : " + page);	// page : /main.do

		Control result = map.get(page);
		result.exec(req, resp);
	}

}
