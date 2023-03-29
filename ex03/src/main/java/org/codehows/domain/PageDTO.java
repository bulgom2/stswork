package org.codehows.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	
	private int startPage;		// 페이징 시작 번호
	private int endPage;		// 페이징 끝 번호
	private boolean prev, next;  // 이전 페이지, 다음 페이지
	
	private int total;		   // 전체 데이터 개수
	private Criteria cri;      // 현재 페이징 번호, 한페이지에 표시할 개수
	
	public PageDTO(Criteria cri, int total) {
		
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
		this.startPage = this.endPage - 9;
		
		int realEnd = (int) (Math.ceil((total * 1.0)/cri.getAmount()));
		
		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;		// 현재 페이징 시작 번호가 1보다 크다면 이전버튼(true)
		this.next = this.endPage < realEnd; // 현재 페이징 끝 번호가 전체 끝보다 작다면 다음버튼(true)
		
	}

}
