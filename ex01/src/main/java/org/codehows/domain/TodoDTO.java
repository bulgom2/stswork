package org.codehows.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {
	
	// @InitBinder 이용
	// private String title;
	// private Date dueDate;
	
	//SampleController.java에서 InitBinder 부분 주석 처리 후 사용
	private String title;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dueDate;

}
