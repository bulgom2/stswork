package org.codehows.mapper;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.codehows.domain.Criteria;
import org.codehows.domain.ReplyVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	// 테스트 전에 해당 번호의 게시물이 존재하는지 반드시 확인
	private Long[] bnoArr = { 166L, 165L, 164L, 163L, 162L };

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[2]);
		
		replies.forEach(reply -> log.info(reply));
	}
	
	/*
	 * @Test public void testUpdate() { Long targetRno = 10L;
	 * 
	 * ReplyVO vo = mapper.read(targetRno);
	 * 
	 * vo.setReply("Update Reply");
	 * 
	 * int count = mapper.update(vo);
	 * 
	 * log.info("UPDATE COUNT: " + count); }
	 */
	
	/*
	 * @Test public void testDelete() {
	 * 
	 * Long targetRno = 1L;
	 * 
	 * mapper.delete(targetRno); }
	 */
	
	/*
	 * @Test public void testRead() {
	 * 
	 * Long targetRno = 10L;
	 * 
	 * ReplyVO vo = mapper.read(targetRno);
	 * 
	 * log.info(vo); }
	 * 
	 */
	
	// 댓글 삽입 테스트 
//	@Test
//	public void testCreate() {
//		IntStream.rangeClosed(1, 10).forEach(i -> {
//			
//			ReplyVO vo = new ReplyVO();
//			
//			// 게시물의 번호
//			vo.setBno(bnoArr[i % 5]);
//			vo.setReply("댓글 테스트 " + i);
//			vo.setReplyer("replyer" + i);
//			
//			mapper.insert(vo);
//		});
//	}
//	
//	@Test
//	public void testMapper() {
//		
//		log.info(mapper);
//	}
}
