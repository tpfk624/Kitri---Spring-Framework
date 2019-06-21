package com.kitri.member.model.service;

import java.util.List;
import java.util.Map;

import com.kitri.member.model.*;

public interface MemberService {

	String idCheck(String id); 		   
	String zipSearch(String doro); 	 
	int registerMember(MemberDetailDto memberDetailDto);  
	MemberDto loginMember(Map<String, String> map); 

	//우리가 나중에 해야함
	MemberDetailDto getMember(String id);     
	int modifyMember(MemberDetailDto MemberDetailDto);   
	int deleteMember(String id);  
	
}
