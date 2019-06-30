package com.kitri.cafe.admin.board.dao;

import java.util.List;

import com.kitri.cafe.admin.board.model.BoardListDto;
import com.kitri.cafe.admin.board.model.BoardTypeDto;
import com.kitri.cafe.admin.board.model.CategoryDto;

public interface BoardAdminDao {
	
	List<BoardListDto> getBoardMenuList(int ccode);
	
	//카테고리만들기
	List<CategoryDto> getCategoryList();
	void makeCategory(CategoryDto categoryDto);
	
	//보드만들기
	List<BoardTypeDto> getBoardTypeList();
	void makeBoard(BoardListDto boardListDto);
	
}
