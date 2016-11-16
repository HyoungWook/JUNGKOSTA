package jungkosta.auction.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.auction.domain.AuctionVO;

@Repository
public class AuctionListDAOImpl implements AuctionListDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "jungkosta.mappers.auction.AuctionListMapper";

	@Override
	public List<AuctionVO> auctionList() throws Exception {

		return sqlSession.selectList(namespace + ".auctionList");
	}

}
