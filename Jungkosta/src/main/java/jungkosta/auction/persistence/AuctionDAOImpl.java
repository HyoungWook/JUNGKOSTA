package jungkosta.auction.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.auction.domain.AuctionVO;

@Repository
public class AuctionDAOImpl implements AuctionDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "jungkosta.mappers.auction.AuctionMapper";
	
	
	@Override
	public void insertSale(AuctionVO auction) throws Exception {
		sqlSession.insert(namespace+".insertSale", auction);
	}

	@Override
	public void insertAuction(AuctionVO auction) throws Exception {
		try {
			insertSale(auction);
			sqlSession.insert(namespace+".insertAuction",auction);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public Integer selectAuction_id() throws Exception {
		sqlSession.selectOne()
		return null;
		
		try {
			if (sqlSession.select != null) {
				return session.getMapper(AuctionMapper.class).selectSale_id();
			} else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
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


}
