package org.codehows.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.codehows.domain.Criteria;
import org.codehows.domain.ReplyVO;

public interface ReplyMapper {

	public int insert(ReplyVO vo);
	
	public ReplyVO read(Long rno);  // 특정 댓글 읽기
	
	public int delete(Long rno);  // 특정 댓글 삭제
	
	public int update(ReplyVO reply);
	
	public List<ReplyVO> getListWithPaging(
			@Param("cri") Criteria cri,
			@Param("bno") Long bno);
}
