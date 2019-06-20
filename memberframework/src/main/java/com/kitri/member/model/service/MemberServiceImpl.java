package com.kitri.member.model.service;

import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.member.model.*;
import com.kitri.member.model.dao.MemberDao;
import com.kitri.member.model.dao.MemberDaoImpl;
import com.sun.javafx.collections.MappingChange.Map;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public String idCheck(String id) {
		int cnt = memberDao.idCheck(id);
//		System.out.println("cnt : " + cnt);
		JSONObject json = new JSONObject();
		json.put("idcount", cnt); 
		return json.toString();//{"idcount" : 0}
	}

	@Override
	public String zipSearch(String doro) {
		List<ZipcodeDto> list = memberDao.zipSearch(doro);
		JSONObject json = new  JSONObject();
		JSONArray jarray = new JSONArray(list);//리스트를 바로 가져갈 수 있어서 아래와 같은거안해도됨
//		for(ZipcodeDto zipcodeDto : list) {
//			JSONObject zipcode = new JSONObject();
//			zipcode.put("zipcode", zipcodeDto.getZipcode());
//			zipcode.put("address", zipcodeDto.getSido() + " " + 
//								   zipcodeDto.getGugun() + " " + 
//								   zipcodeDto.getUpmyon() + " " + 
//								   zipcodeDto.getDoro() + " " + 
//								   zipcodeDto.getBuildingNumber() + " " + 
//								   zipcodeDto.getSigugunBuildingName());
//			jarray.put(zipcode);
//		}
		json.put("ziplist", jarray);
		System.out.println(json.toString());
		return json.toString();
	}
	
	
	@Override
	public int registerMember(MemberDetailDto memberDetailDto) {
		return memberDao.registerMember(memberDetailDto);
	}

	@Override
	public MemberDto loginMember(String id, String pass) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userid", id);
		map.put("userpwd", pass);		
		return  memberDao.loginMember(map);
	}

	@Override
	public MemberDetailDto getMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifyMember(MemberDetailDto MemberDetailDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
