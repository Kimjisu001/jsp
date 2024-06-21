package co.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.yedam.vo.ReplyVO;

public interface ReplyMapper {

	List<ReplyVO> selectListPaging(@Param("boardNo") int boardNo, @Param("page") int page);

	List<ReplyVO> selectList(int boardNo);

	ReplyVO selectReply(int replyVO);

	int insertReply(ReplyVO rvo);

	int deleteReply(int replyNo);

}
