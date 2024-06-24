package co.yedam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import co.yedam.common.CenterVO;
import co.yedam.vo.ReplyVO;

public interface ReplyMapper {

	List<ReplyVO> selectListPaging(@Param("boardNo") int boardNo, @Param("page") int page);

	List<ReplyVO> selectList(int boardNo);

	ReplyVO selectReply(int replyVO);

	int insertReply(ReplyVO rvo);

	int deleteReply(int replyNo);
	
	//센터 정보 생성
	int insertCenter(CenterVO[] array);

	//시도별 센터 갯수 차트
	List<Map<String,Object>> centerBysido();
}
