package com.mall.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mall.service.AccountService;
import com.mall.vo.AccountVo;

@Controller
@RequestMapping("/sign/*")
public class AccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Resource
	AccountService service;
	
	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	//회원가입
	@RequestMapping(value="/up",method=RequestMethod.GET)
	public void getSignup(AccountVo vo) throws Exception {
		logger.info("get signup");
	}
	
	@RequestMapping(value="/up",method=RequestMethod.POST)
	public String postSignup(AccountVo vo) throws Exception {
		logger.info("post signup");
		
		String inputPass = vo.getUserPass();
		String pass = passEncoder.encode(inputPass);
		vo.setUserPass(pass);
		
		service.signup(vo);
		
		return "redirect:/";
	}
	
	//로그인
	@RequestMapping(value="/in", method=RequestMethod.GET)
	public void getSignin() throws Exception {
		logger.info("get signin");
	}
	
	@RequestMapping(value="/in", method=RequestMethod.POST)
	public String postSignin(AccountVo vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		logger.info("post signin");
		
		AccountVo login = service.signin(vo);
		HttpSession session = req.getSession();
		
		boolean passMatch = passEncoder.matches(vo.getUserPass(), login.getUserPass());
		
		if(login != null && passMatch) {
			session.setAttribute("account", login);
		} else {
			session.setAttribute("account", null);
			rttr.addFlashAttribute("msg", false);
			return "redirect:/sign/in";
		}
		
		return "redirect:/";
	}
	
	//로그아웃
	@RequestMapping(value="/out", method = RequestMethod.GET)
	public String signout(HttpSession session) throws Exception {
		logger.info("get signout");
		
		service.signout(session);
		return "redirect:/";
	}
}
