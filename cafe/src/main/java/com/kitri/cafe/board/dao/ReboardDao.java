package com.kitri.cafe.board.dao;

import java.util.List;
import java.util.Map;

import com.kitri.cafe.board.model.ReboardDto;

public interface ReboardDao {

	int writeArticle(ReboardDto reboardDto);
	List<ReboardDto> listArticle(Map<String, String> parameter);//게시판번호,페이지번호,검색조건,...많으니까 map으로 가져와라
	ReboardDto viewArticle(int seq); //글번호가져감
	int modifyArticle(ReboardDto reboardDto);
	void deleteArticle(int seq);
	
	
	//----------------------일반게시판 종료---------------
	
	void updateStep(ReboardDto reboardDto); //맵을 만들면 복잡하니 dto를 보내버린다??
	int replyArticle(ReboardDto reboardDto); //얘는 진짜 필요
	void updateReply(int pseq);
	
}
