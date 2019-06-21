package com.kitri.member.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.service.MemberService;


@Controller
@RequestMapping("/user")//유저가 공통이니까
@SessionAttributes("userInfo") //userinfo를 세션에다가 담는다 //모델에 담으면 request의역할이어서 다음페이지에만 저장됨
//@SessionAttributes(names = {"userInfo", "b", "c"}) //여러개보낼경우
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
			model.addAttribute("registerInfo", memberDetailDto);
			return "user/member/registerok";
		}
		return "user/member/registerfail"; //뷰의 이름만 설정하면 됨
	}
	

	@RequestMapping(value = "/idcheck.kitri", method = RequestMethod.GET)
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
	
	@RequestMapping(value = "/login.kitri", method = RequestMethod.GET) 
	public String login() {
		return "user/login/login"; //뷰의 이름만 설정하면 됨
	}
	
//	@RequestMapping(value = "/login.kitri", method = RequestMethod.POST) 
//	public String login(@RequestParam("id")String id, @RequestParam("pass") String pass, HttpSession session) {
//		MemberDto memberDto = memberService.loginMember(id, pass);
//		if(memberDto != null) {
//			session.setAttribute("userInfo", memberDto);
//			return "user/login/loginok"; 
//		}else {
//			return "user/login/loginfail"; 
//		}
//		
//	}
	
	@RequestMapping(value = "/login.kitri", method = RequestMethod.POST) 
	public String login(@RequestParam Map<String, String> map, Model model ) { //@RequestParam 이걸 안쓰면 맵이 보내주는 모델로 인식하고 쓰면 받아오는걸로 인식
		MemberDto memberDto = memberService.loginMember(map);
		if(memberDto != null) {
			model.addAttribute("userInfo", memberDto);
			return "user/login/loginok"; 
		}else {
			return "user/login/loginfail"; 
		}
	}
	
//	이걸로 하면 세션의 정보가 사라지지않아서 밑에 있는 sessionStatus를 사용하자!
//	@RequestMapping("/logout.kitri")
//	public String logout(HttpSession session) {
//		session.removeAttribute("userInfo");
//		return "redirect:/index.jsp";//아무것도 지정안하면 forward이고 지정해주면 redirect(주소바뀜)
//	}
	
	@RequestMapping("/logout.kitri")
	public String logout(@ModelAttribute("userInfo") MemberDto memberDto,SessionStatus  sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/index.jsp";
	}
}


