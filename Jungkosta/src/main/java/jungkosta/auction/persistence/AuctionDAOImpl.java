package jungkosta.auction.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.domain.CategoryVO;

@Repository
public class AuctionDAOImpl implements AuctionDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "jungkosta.mappers.auction.AuctionMapper";

	@Override
	public void insertSale(AuctionVO auction) throws Exception {
		sqlSession.insert(namespace + ".insertSale", auction);
	}

	@Override
	public void insertAuction(AuctionVO auction) throws Exception {
		try {
			insertSale(auction);
			sqlSession.insert(namespace + ".insertAuction", auction);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Integer selectAuction_id() throws Exception {
		/*
		 * sqlSession.selectOne()
		 * 
		 * try { if (sqlSession.select != null) { return
		 * session.getMapper(AuctionMapper.class).selectSale_id(); } else {
		 * return 0; } } catch (Exception e) { e.printStackTrace(); return 0;
		 */

		return null;
	}

	@Override
	public Integer selectSale_id() throws Exception {

		return null;
	}

	@Override
	public List<AuctionVO> listAuction() throws Exception {
		return null;
	}

	@Override
	public AuctionVO selectSale(int sale_id) throws Exception {
		return null;
	}

	@Override
	public AuctionVO selectAuction(int auction_id) throws Exception {
		return null;
	}

	// start 현우 추가 부분
	@Override
	public AuctionVO read(int sale_id) throws Exception {

		return sqlSession.selectOne(namespace + ".read", sale_id);
	}

	@Override
	public CategoryVO selectCategory(int subca_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".selectCategory", subca_id);
	}
	// end 현우 추가 부분

}
