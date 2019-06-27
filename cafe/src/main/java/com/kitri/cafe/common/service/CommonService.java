package com.kitri.cafe.common.service;

import java.util.Map;

import com.kitri.cafe.util.PageNavigation;

//공통으로 사용할 애들
public interface CommonService {

	int getNextSeq();
	PageNavigation getPageNavigation(Map<String, String> parameter);
}
