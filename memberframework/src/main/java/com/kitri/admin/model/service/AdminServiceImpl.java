package com.kitri.admin.model.service;

import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.admin.model.dao.AdminDao;
import com.kitri.admin.model.dao.AdminDaoImpl;
import com.kitri.member.model.MemberDetailDto;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Override
	public String getMemberList(Map<String, String> map) {
		//json 우편번호 참고 //map은 로그인 참고
		List<MemberDetailDto> list = adminDao.getMemberList(map);
		JSONObject json = new JSONObject();
		JSONArray jarray = new JSONArray(list);
		
//		String result = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
//		result += "<memberlist>\n";
//		for(MemberDetailDto memberDetailDto : list) {
//			result += "	<member>\n";
//			result += "		<id>" + memberDetailDto.getId() + "</id>\n";
//			result += "		<name>" + memberDetailDto.getName() + "</name>\n";
//			result += "		<email>" + memberDetailDto.getEmailid() + "@" + memberDetailDto.getEmaildomain() + "</email>\n";
//			result += "		<tel>" + memberDetailDto.getTel1() + "-" + memberDetailDto.getTel2() + "-" + memberDetailDto.getTel3() + "</tel>\n";
//			result += "		<address><![CDATA[" + memberDetailDto.getZipcode() + " " + memberDetailDto.getAddress() + " " + memberDetailDto.getAddressDetail() + "]]></address>\n";
//			result += "		<joindate>" + memberDetailDto.getJoindate() + "</joindate>\n";
//			result += "	</member>\n";
//		}
//		result += "</memberlist>";
//		System.out.println(result);
		
		json.put("memberlist", jarray);
		//System.out.println(json.toString());
		return json.toString();
	}

}

















