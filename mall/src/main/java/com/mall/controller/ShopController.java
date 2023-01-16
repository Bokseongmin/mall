package com.mall.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mall.service.ShopService;
import com.mall.vo.AccountVo;
import com.mall.vo.GoodsViewVo;
import com.mall.vo.ReplyVo;

@Controller
@RequestMapping("/shop/*")
public class ShopController {

	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);

	@Resource
	ShopService service;

	// 리스트
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getList(@RequestParam("c") int cateCode, @RequestParam("l") int level, Model model) throws Exception {
		logger.info("get list");

		List<GoodsViewVo> list = service.list(cateCode, level);

		model.addAttribute("list", list);
	}

	// 조회 - 리뷰 목록
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void getView(@RequestParam("n") int gdsNum, Model model) throws Exception {
		logger.info("get view");

		GoodsViewVo view = service.view(gdsNum);
		model.addAttribute("view", view);

		/*
		 * List<ReplyVo> reply = service.reply_list(gdsNum); model.addAttribute("reply",
		 * reply);
		 */
	}

	/*
	 * // 조회 - 리뷰 작성
	 * 
	 * @RequestMapping(value="/view", method = RequestMethod.POST) public String
	 * postView(ReplyVo vo, HttpSession session) throws Exception {
	 * logger.info("post view");
	 * 
	 * AccountVo account = (AccountVo)session.getAttribute("account");
	 * vo.setUserId(account.getUserId());
	 * 
	 * service.up(vo);
	 * 
	 * return "redirect:/shop/view?n=" + vo.getGdsNum(); }
	 * 
	 */

	// 리뷰 작성 ajax
	@ResponseBody
	@RequestMapping(value = "/view/up", method = RequestMethod.POST)
	public void reply_write(ReplyVo vo, HttpSession session) throws Exception {
		logger.info("reply write");

		AccountVo account = (AccountVo) session.getAttribute("account");
		vo.setUserId(account.getUserId());

		service.up(vo);
	}

	// 조회 - ajax
	@ResponseBody
	@RequestMapping(value = "/view/replyList", method = RequestMethod.GET)
	public List<ReplyVo> getReplyList(@RequestParam("n") int gdsNum) throws Exception {
		logger.info("get reply list");

		List<ReplyVo> reply = service.reply_list(gdsNum);

		return reply;
	}

	// 리뷰 수정
	@ResponseBody
	@RequestMapping(value = "/view/replyModify", method = RequestMethod.POST)
	public int postReplyModify(ReplyVo vo, HttpSession session) throws Exception {
		logger.info("post reply modify");

		int result = 0;

		AccountVo account = (AccountVo) session.getAttribute("account");
		String userId = service.idCheck(vo.getRepNum());

		System.out.println(account.getUserId());
		System.out.println(vo.getRepNum());
		System.out.println(userId);

		if (account.getUserId().equals(userId)) {
			vo.setUserId(account.getUserId());
			service.reply_modify(vo);

			result = 1;
		}
		return result;
	}

	// 리뷰 삭제
	@ResponseBody
	@RequestMapping(value = "/view/replyDelete", method = RequestMethod.POST)
	public int postReplyList(ReplyVo vo, HttpSession session) throws Exception {
		logger.info("post reply delete");

		int result = 0;

		AccountVo account = (AccountVo) session.getAttribute("account");
		String userId = service.idCheck(vo.getRepNum());

		System.out.println(account.getUserId());
		System.out.println(vo.getRepNum());
		System.out.println(userId);

		if (account.getUserId().equals(userId)) {
			vo.setUserId(account.getUserId());
			service.reply_delete(vo);

			result = 1;
		}
		return result;
	}
}
