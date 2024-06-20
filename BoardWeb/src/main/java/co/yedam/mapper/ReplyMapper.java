package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.ReplyVO;

public interface ReplyMapper {
	
	List<ReplyVO> selectList(int boardNo);
	ReplyVO selectReply(int replyVO);
	int insertReply(ReplyVO rvo);
	int deleteReply(int replyNo);

}
