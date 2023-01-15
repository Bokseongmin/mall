package com.mall.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mall.service.AdminService;
import com.mall.utils.UploadFileUtils;
import com.mall.vo.CategoryVo;
import com.mall.vo.GoodsViewVo;
import com.mall.vo.GoodsVo;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Resource
	AdminService service;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
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
	
	@RequestMapping(value="/goods/up", method=RequestMethod.POST)
	public String postGoodsUp(GoodsVo vo, MultipartFile file) throws Exception {
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		 fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
		} else {
		 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
		
		// gdsImg에 원본 파일 경로 + 파일명 저장
		vo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		// gdsThumbImg에 섬네일 파일 경로 + 썸네일 파일명 저장
		vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		service.up(vo);
		return "redirect:/admin/index";
	}
	
	//상품 목록
	@RequestMapping(value="/goods/list", method=RequestMethod.GET)
	public void getGoodsList(Model model) throws Exception {
		logger.info("get goods list");
		
		List<GoodsVo> list = service.list();
		
		model.addAttribute("list", list);
	}
	
	//상품 조회
	@RequestMapping(value="/goods/view", method=RequestMethod.GET)
	public void getGoodsView(@RequestParam("n") int gdsNum, Model model) throws Exception {
		logger.info("get goods view");
		
		GoodsViewVo gds = service.view(gdsNum);
		System.out.println(gds.getGdsThumbImg());
		model.addAttribute("goods", gds);
	}
	
	//상품 수정
	@RequestMapping(value="/goods/modify", method=RequestMethod.GET)
	public void getGoodsModfiy(@RequestParam("n") int gdsNum, Model model) throws Exception {
		logger.info("get goods modify");
		
		GoodsViewVo gds = service.view(gdsNum);
		model.addAttribute("goods", gds);
		
		List<CategoryVo> category = service.category();
		model.addAttribute("category", JSONArray.fromObject(category));
	}
	
	@RequestMapping(value="/goods/modify", method=RequestMethod.POST)
	public String postGoodsModfiy(GoodsVo vo) throws Exception {
		logger.info("post goods modify");
		
		service.modify(vo);
		
		return "redirect:/admin/index";
	}
	
	// 상품 삭제
	@RequestMapping(value="/goods/delete", method=RequestMethod.POST)
	public String postGoodsDelete(@RequestParam("n") int gdsNum) throws Exception {
		logger.info("post goods delete");
		
		service.delete(gdsNum);
		
		return "redirect:/admin/index";
	}
}
