package com.kitri.cafe.board.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kitri.cafe.board.service.ReboardService;

@Controller
@RequestMapping("/reboard")
public class ReboardController {

	@Autowired
	private ReboardService reboardService;
	
// return "reboard/write"; //리퀘스트 맵핑 두개 이름이 폴더이름도 같다면 void로만 해도 이동이 됨
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void write(@RequestParam Map<String, String> parameter, Model model) {
		model.addAttribute("parameter", parameter);
	}
	
}
