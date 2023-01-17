package com.mall.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mall.dao.AdminDao;
import com.mall.vo.CategoryVo;
import com.mall.vo.GoodsViewVo;
import com.mall.vo.GoodsVo;
import com.mall.vo.OrderListVo;
import com.mall.vo.OrderVo;

@Service
public class AdminServiceImpl implements AdminService {

	@Resource
	private AdminDao dao;

	public List<CategoryVo> category() throws Exception {
		return dao.category();
	}

	public void up(GoodsVo vo) throws Exception {
		dao.up(vo);
	}

	/*// 상품 목록
	public List<GoodsVo> list() throws Exception {
		return dao.list();
	}*/
	
	public List<GoodsViewVo> list() throws Exception {
		return dao.list();
	}

	/*
	 * public GoodsVo view(int gdsNum) throws Exception { return dao.view(gdsNum); }
	 */

	public GoodsViewVo view(int gdsNum) throws Exception {
		return dao.view(gdsNum);
	}

	public void modify(GoodsVo vo) throws Exception {
		dao.modify(vo);
	}

	public void delete(int gdsNum) throws Exception {
		dao.delete(gdsNum);
	}
	
	public List<OrderVo> order_list() throws Exception {
		return dao.order_list();
	}
	
	public List<OrderListVo> order_view(OrderVo vo) throws Exception {
		return dao.order_view(vo);
	}
	
	public void delivery(OrderVo vo) throws Exception {
		dao.delivery(vo);
	}
}
