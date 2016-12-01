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
	public List<AuctionVO> auctionList(AuctionCriteria cri) throws Exception {

		return sqlSession.selectList(namespace + ".auctionList", cri,
				new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}

	@Override
	public List<AuctionVO> auctionCate(Map<String, Object> map) throws Exception {
		return sqlSession.selectList(namespace+".auctionCate", map);
	}



}
