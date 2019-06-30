package com.kitri.cafe.board.dao;

import java.util.List;
import java.util.Map;

import com.kitri.cafe.board.model.BoardDto;

public interface BoardDao {

	int writeArticle(BoardDto boardDto);
	List<BoardDto> listArticle(Map<String, String> parameter);//게시판번호,페이지번호,검색조건,...많으니까 map으로 가져와라
	BoardDto viewArticle(int seq); //글번호가져감
	int modifyArticle(BoardDto boardDto);
	void deleteArticle(int seq);
	
}
