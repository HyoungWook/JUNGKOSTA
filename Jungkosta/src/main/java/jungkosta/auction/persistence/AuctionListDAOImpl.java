package jungkosta.auction.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.auction.domain.AuctionCriteria;
import jungkosta.auction.domain.AuctionVO;

@Repository
public class AuctionListDAOImpl implements AuctionListDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "jungkosta.main.mappers.auction.AuctionMapper";

	@Override
	public List<AuctionVO> auctionList(Map<String, Object> map) throws Exception {

		AuctionCriteria cri = (AuctionCriteria) map.get("cri");

		return sqlSession.selectList(namespace + ".auctionList", map,
				new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}

}
