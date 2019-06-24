package com.kitri.cafe.board.service;

import java.util.List;
import java.util.Map;

import com.kitri.cafe.board.model.MemoDto;

public interface MemoService {


	void writeMemo(MemoDto memoDto);
	List<MemoDto> listMemo(Map<String, String> parameter);//게시판번호,페이지번호,검색조건,...많으니까 map으로 가져와라
	void modifyMemo(MemoDto memoDto);
	void deleteMemo(int seq);
	
}
