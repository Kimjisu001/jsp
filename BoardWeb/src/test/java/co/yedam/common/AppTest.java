package co.yedam.common;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import co.yedam.mapper.ReplyMapper; 
public class AppTest {

	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession(true); // 자동 커밋 하겠습니다.

		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);

		
		List<Map<String,Object>> result = mapper.centerBysido();
		for(Map<String,Object> map : result) {
		Set<String> keyset = map.keySet();
		System.out.println(map.get("sido") + "," + map.get("cnt"));
		System.out.println("--------------------------------");
		}
		
		
//		CenterVO cvo1 = new CenterVO();
//		cvo1.setAddress("ad1");
//		cvo1.setId("1");
//		cvo1.setCenterName("cm1");
//		cvo1.setSido("sd01");
//		cvo1.setPhoneNumber("ph01");
//		CenterVO cvo2 = new CenterVO();
//		cvo2.setAddress("ad2");
//		cvo2.setId("2");
//		cvo2.setCenterName("cm2");
//		cvo2.setSido("sd02");
//		cvo2.setPhoneNumber("ph02");
//		
//		CenterVO[] centers = {cvo1, cvo2};
//		int r = mapper.insertCenter(centers);
//		System.out.println(r+ "건 입력.");
		
		//mapper.selectListPaging(1, 1).forEach(reply -> System.out.println(reply));

	}
}
