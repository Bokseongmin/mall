package com.mall.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mall.vo.CategoryVo;
import com.mall.vo.GoodsViewVo;
import com.mall.vo.GoodsVo;
import com.mall.vo.OrderListVo;
import com.mall.vo.OrderVo;
import com.mall.vo.ReplyVo;

@Repository("AdminDao")
public class AdminDao extends CommonDao {

	// 카테고리 조회
	public List<CategoryVo> category() throws Exception {
		return getSqlSession().selectList("mAdmin.category");
	}

	// 상품 등록
	public void up(GoodsVo vo) throws Exception {
		getSqlSession().insert("mAdmin.up", vo);
	}

	/*// 상품 목록
	public List<GoodsVo> list() throws Exception {
		return getSqlSession().selectList("mAdmin.list");
	}
	*/
	
	// 상품 목록
	public List<GoodsViewVo> list() throws Exception {
		return getSqlSession().selectList("mAdmin.list");
	}

	/*// 상품 정보
	public GoodsVo view(int gdsNum) throws Exception {
		return getSqlSession().selectOne("mAdmin.view", gdsNum);
	}*/

	// 상품 정보 + 조인
	public GoodsViewVo view(int gdsNum) throws Exception {
		return getSqlSession().selectOne("mAdmin.view", gdsNum);
	}
	
	// 상품 수정
	public void modify(GoodsVo vo) throws Exception {
		getSqlSession().update("mAdmin.modify",vo);
	}
	
	// 상품 삭제
	public void delete(int gdsNum) throws Exception {
		getSqlSession().delete("mAdmin.delete", gdsNum);
	}
	
	// 모든 유저 주문
	public List<OrderVo> order_list() throws Exception {
		return getSqlSession().selectList("mAdmin.order_list");
	}
	
	// 특정 주문
	public List<OrderListVo> order_view(OrderVo vo) throws Exception {
		return getSqlSession().selectList("mAdmin.order_view", vo);
	}
	
	// 배송 정보
	public void delivery(OrderVo vo) throws Exception {
		getSqlSession().update("mAdmin.delivery", vo);
	}
	
	// 수량 조절
	public void change_stock(GoodsVo vo) throws Exception {
		getSqlSession().update("mAdmin.change_stock", vo);
	}
	
	//댓글 조회
	public List<ReplyVo> reply_list() throws Exception {
		return getSqlSession().selectList("mAdmin.reply_list");
	}
	
	//댓글 삭제
	public void reply_delete(int repNum) throws Exception {
		getSqlSession().delete("mAdmin.reply_delete", repNum);
	}
}