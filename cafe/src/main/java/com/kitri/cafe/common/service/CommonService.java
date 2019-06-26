package com.kitri.cafe.common.service;

//공통으로 사용할 애들
public interface CommonService {

	int getNextSeq();
	void updateHit(int seq); //조회수
	
}
