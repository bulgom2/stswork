package org.codehows.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	
	private int pageNum;    // 페이지 넘버
	private int amount;		// 페이지당 몇개 데이터 출력
	
	private String type;	// 검색 타입(T:제목, C:내용, W:작성자)
	private String keyword;	// 검색 키워드(검색 단어)
	
	public Criteria() {
		this(1,10);			// 1 페이지당 10개의 게시물 출력
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
	
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.getAmount())
				.queryParam("type", this.getType())
				.queryParam("keyword", this.getKeyword());
		
		return builder.toUriString();
	}
}
