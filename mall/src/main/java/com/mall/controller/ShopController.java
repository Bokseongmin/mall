package com.mall.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mall.service.ShopService;
import com.mall.vo.GoodsViewVo;

@Controller
@RequestMapping("/shop/*")
public class ShopController {
	
	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	@Resource
	ShopService service;
	
	//리스트
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public void getList(@RequestParam("c") int cateCode, @RequestParam("l") int level, Model model) throws Exception {
		logger.info("get list");
		
		List<GoodsViewVo> list = service.list(cateCode, level);
		
		model.addAttribute("list", list);
	}
	
	// 조회
	@RequestMapping(value="/view", method = RequestMethod.GET)
	public void getView(@RequestParam("n") int gdsNum, Model model) throws Exception {
		logger.info("get view");
		
		GoodsViewVo view = service.view(gdsNum);
		model.addAttribute("view", view);
	}
}
