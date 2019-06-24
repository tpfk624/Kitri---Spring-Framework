package com.kitri.cafe.board.service;

import java.util.List;
import java.util.Map;

import com.kitri.cafe.board.model.ReboardDto;

public interface ReboardService {


	int writeArticle(ReboardDto reboardDto);
	List<ReboardDto> listArticle(Map<String, String> parameter);//게시판번호,페이지번호,검색조건,...많으니까 map으로 가져와라
	ReboardDto viewArticle(int seq); //글번호가져감
	int modifyArticle(ReboardDto reboardDto);
	void deleteArticle(int seq);
}
