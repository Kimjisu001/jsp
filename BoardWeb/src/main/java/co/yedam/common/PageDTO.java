package co.yedam.common;

import lombok.Data;

@Data
public class PageDTO {
	//현재 페이지를 기준으로 파라메타를 기준으로 알수 있는데 4페이지가 소속되어있는 페이지와 마지막 페이지를 계산하기 위함.
	//50개를 한번에 보여줄수 없으니 현재페이지를 기준으로 필드선언
	
	private int startPage, endPage;
	private boolean prev, next;
	private int page;
	 
	//생성자.
	
	public PageDTO(int page, int totalCnt) {
		// 1페이지 ~ (현재페이지) 4페이지 ~ 10페이지
		this.page = page; 
		this.endPage = (int)(Math.ceil(page /10.0) * 10);
		this.startPage = this.endPage - 9;
		
		int realEnd = (int)Math.ceil(totalCnt/5.0);
		this.endPage = this.endPage > realEnd ? realEnd : this.endPage;
		
		
		this.prev = this.startPage > 1;
		this.next = this.endPage == realEnd ? false : true;
		
		
		
		
	//게터세터 추가
		
		
		
	}
	
}
