package com.mall.service;

import java.util.List;

import com.mall.vo.CategoryVo;
import com.mall.vo.GoodsViewVo;
import com.mall.vo.GoodsVo;
import com.mall.vo.OrderListVo;
import com.mall.vo.OrderVo;

public interface AdminService {
	
	//카테고리
	public List<CategoryVo> category() throws Exception;
	
	//상품 등록
	public void up(GoodsVo vo) throws Exception;
	
	/*//상품 목록
	public List<GoodsVo> list() throws Exception; */
	
	//상품 목록
	public List<GoodsViewVo> list() throws Exception;
	
	/*//상품 정보
	public GoodsVo view(int gdsNum) throws Exception; */
	
	//상품 정보 + 조인
	public GoodsViewVo view(int gdsNum) throws Exception;
	
	// 상품 수정
	public void modify(GoodsVo vo) throws Exception;
	
	// 상품 삭제
	public void delete(int gdsNum) throws Exception;
	
	// 모든 주문
	public List<OrderVo> order_list() throws Exception;
	
	// 특정 주문
	public List<OrderListVo> order_view(OrderVo vo) throws Exception;
	
	// 배달 정보
	public void delivery(OrderVo vo) throws Exception;
	
	// 수량 조절
	public void change_stock(GoodsVo vo) throws Exception;
}
