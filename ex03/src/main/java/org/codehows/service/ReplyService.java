package org.codehows.service;

import java.util.List;

import org.codehows.domain.Criteria;
import org.codehows.domain.ReplyVO;

public interface ReplyService {
	
	public int register(ReplyVO vo);     // 리플 등록
	
	public ReplyVO get(Long rno);		 // 리플 상세 정보
	
	public int modify(ReplyVO vo);		 // 리플 수정
	
	public int remove(Long rno);		 // 리플 삭제
	
	public List<ReplyVO> getList(Criteria cri, Long bno);  	// 게시물에 리플 목록

}
