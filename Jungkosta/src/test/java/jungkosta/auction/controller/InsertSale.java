package jungkosta.auction.controller;

import static org.junit.Assert.*;

import java.sql.Timestamp;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.persistence.AuctionDAO;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })//Spring Container 객체 생성
public class InsertSale {
	
	//@Inject
	//private AuctionDAO dao;

	@Test
	public void test() throws Exception {
		
		/*AuctionVO vo = new AuctionVO();
		vo.setAuction_id(33);
		vo.setAuction_stcost(3000);
		vo.setImmediate_bid_cost(300000);
		vo.setAuction_end_date(Timestamp.valueOf("2016-12-15 12:00:00.0"));
		vo.setSale_id(64);
		vo.setItem_name("test");
		vo.setItem_cost(vo.getAuction_stcost());
		vo.setBuy_time(Timestamp.valueOf("2016-09-25 12:00:00.0"));
		vo.setItem_scratch("test");
		vo.setItem_status("미개봉:박스를 개봉하지 않은 상품");
		vo.setAdditional_info("test");
		vo.setBuy_info("test");
		vo.setEmail("aaa@aaa.com");
		vo.setSubca_id(1);
		
		System.out.println(vo);*/
		
		//dao.insertSale(vo);
		//dao.insertAuction(vo);
	}

}
