package com.kitri.cafe.board.dao;

import java.util.List;
import java.util.Map;

import com.kitri.cafe.board.model.AlbumDto;
import com.kitri.cafe.board.model.MemoDto;

public interface MemoDao {

	int writeArticle(MemoDto memoDto);
	List<AlbumDto> listArticle(Map<String, String> parameter);//게시판번호,페이지번호,검색조건,...많으니까 map으로 가져와라
	AlbumDto viewArticle(int seq); //글번호가져감
	int modifyArticle(MemoDto memoDto);
	void deleteArticle(int seq);
}
