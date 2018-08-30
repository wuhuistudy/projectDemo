package net.syntrust.entity;

/** 
 * @Description: 分页信息
 */
public class PageInfo{
	/* 当前页数 */
	private String pageIndex;
	/* 每页大小 */
	private String pageSize;
	/* 数量统计 */
	private Integer count;

	public PageInfo() {
		super();
	}

	public PageInfo(String pageIndex, String pageSize, Integer count) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.count = count;
	}

	public String getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(String pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "PageInfo [pageIndex=" + pageIndex + ", pageSize=" + pageSize + ", count=" + count + "]";
	}
	
}
