package jungkosta.auction.domain;

public class AuctionCriteria {

	private int page = 1;
	private int perPageNum = 4;
	private String sort;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
			return;
		}

		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 2;
			return;
		}

		this.perPageNum = perPageNum;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public int getPageStart() {

		return (this.page - 1) * perPageNum;
	}

	@Override
	public String toString() {
		return "AuctionCriteria [page=" + page + ", perPageNum=" + perPageNum + ", sort=" + sort + "]";
	}

}
