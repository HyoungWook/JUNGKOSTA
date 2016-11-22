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

	private static final String namespace = "jungkosta.main.mappers.auction.AuctionMapper";

	@Override
	public void insertSale(AuctionVO auction) throws Exception {
		sqlSession.insert(namespace + ".insertSale", auction);
	}

	@Override
	public void insertAuction(AuctionVO auction) throws Exception {

		sqlSession.insert(namespace + ".insertAuction", auction);

	}

	@Override
	public int selectAuction_id() throws Exception {

		if (sqlSession.selectOne(namespace + ".selectAuction_id") != null) {
			return sqlSession.selectOne(namespace + ".selectAuction_id");
		} else {
			return 0;
		}

	}

	@Override
	public int selectSale_id() throws Exception {

		if (sqlSession.selectOne(namespace + ".selectSale_id") != null) {
			return sqlSession.selectOne(namespace + ".selectSale_id");
		} else {
			return 0;
		}
	}

	@Override
	public AuctionVO read(int sale_id) throws Exception {

		return sqlSession.selectOne(namespace + ".read", sale_id);
	}

	@Override
	public CategoryVO selectCategory(int subca_id) throws Exception {
		return sqlSession.selectOne(namespace + ".selectCategory", subca_id);
	}

	@Override
	public void updateItemCost(AuctionVO auction) throws Exception {

		sqlSession.update(namespace+".updateItemCost",auction);
	}

	@Override
	public void updateAuctionSt(AuctionVO auction) throws Exception {
		sqlSession.update(namespace+".updateAuctionSt", auction);
	}

}
