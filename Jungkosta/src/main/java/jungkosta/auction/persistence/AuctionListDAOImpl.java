package jungkosta.auction.persistence;

import java.util.List;
import java.util.Map;

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
	public List<AuctionVO> auctionList(Map<String, String> map) throws Exception {

		return sqlSession.selectList(namespace + ".auctionList", map);
	}

}
