package com.kitri.admin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kitri.admin.model.service.AdminService;
import com.kitri.member.model.MemberDto;

@Controller
@RequestMapping("/admin")
@SessionAttributes("userInfo")
public class AdminController {
	
	@Autowired
	private AdminService adminService;  
	
	@RequestMapping(value = "/mvmemberlist.kitri", method = RequestMethod.GET) 
	public String admin(@ModelAttribute("userInfo") MemberDto memberDto) {
		return "admin/member/memberlist"; //뷰의 이름만 설정하면 됨
	}
	
	@RequestMapping(value = "/memberlist.kitri", method = RequestMethod.GET)
	public @ResponseBody String idCheck(@RequestParam Map<String, String> map, @ModelAttribute("userInfo") MemberDto memberDto) {
		System.out.println(map); //@ResponseBody 데이터를 보낼거다
		//adminService.getMemberList(map);
		String result = adminService.getMemberList(map);
		System.out.println(result);
		return result;  //받은 값이 스트링이니까 그대로 넣기
		//WEB-INF/views/{"idcount" : 0}
	}
}