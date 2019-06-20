package com.kitri.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.service.MemberService;


@Controller
@RequestMapping("/user")//유저가 공통이니까
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	/* @qualifier("impll"); */
	private MemberService memberService;
	
	

	
	@RequestMapping(value = "/register.kitri", method = RequestMethod.GET) //get방식은 단순 페이지이동
	public String register() {
		return "user/member/member"; //뷰의 이름만 설정하면 됨
	}
	
	@RequestMapping(value = "/register.kitri", method = RequestMethod.POST)//post는 회원가입을 진짜로 할거야
	public String register(MemberDetailDto memberDetailDto, Model model) {
		int cnt = memberService.registerMember(memberDetailDto);
		if(cnt != 0) {
			model.addAttribute("userInfo", memberDetailDto);
			return "user/member/registerok";
		}
		return "user/member/registerfail"; //뷰의 이름만 설정하면 됨
	}
	

	
	
	@RequestMapping(value = "/idcheck.kitri", method = RequestMethod.GET)//post는 회원가입을 진짜로 할거야
	public @ResponseBody String idCheck(@RequestParam(name = "checkid", defaultValue = "") String id) { /* 넘어오는 파라미터의 이름하고 컨트롤러 변수 이름하고 같으면 설정필요x 다르다면 저 리퀘스트파람 설정해주기  */
		logger.info("검색 아이디: " + id);
		String json = memberService.idCheck(id);
		return json; //WEB-INF/views/{"idcount" : 0}
	}
	
	@RequestMapping("/zipsearch.kitri") //페이지이동
	@ResponseBody
	public String zipSearch(@RequestParam("doro") String doro) {
		//logger.info("검색도로명: " +  doro);
		String json = memberService.zipSearch(doro);
		return json;
	}
	
	@RequestMapping("/login.kitri") //페이지이동
	public String login() {
		return "user/login/login"; //뷰의 이름만 설정하면 됨
	}
	
}


