package com.mall.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mall.service.AdminService;
import com.mall.vo.CategoryVo;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Resource
	AdminService service;
	
	//관리자 화면
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public void getIndex() throws Exception {
		logger.info("get index");
	}
	
	//상품 등록
	@RequestMapping(value="/goods/up", method=RequestMethod.GET)
	public void getGoodsUp(Model model) throws Exception {
		logger.info("get goods up");
		
		List<CategoryVo> category = service.category();
		model.addAttribute("category", JSONArray.fromObject(category));
	}
}
