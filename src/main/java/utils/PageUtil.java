package utils;
/**
 * 先设置totalCount、pageSize
 * 在设置当前页
 * @author keller
 *
 */
public class PageUtil {

	private int totalCount;// 数据库的总记录数
	private int pageSize = 5;// 每页显示的最大记录数；
	private int pageCount;// 总页数
	private int currentPage;// 当前页
	private int currentPageCount;// 当前页的总记录数
	private int currentStart;// 当前页的起始记录
	private int currentEnd;// 当前页的结束记录

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;

	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage < 1 ? 1 : currentPage;
		this.currentPage = this.currentPage > this.getPageCount() ? this
				.getPageCount() : this.currentPage;
		this.currentPageCount = this.currentPage == this.getPageCount() ? this
				.getTotalCount() - (this.currentPage - 1) * this.getPageSize()
				: this.getPageSize();
		this.currentStart=(this.currentPage-1)*this.getPageSize();
		this.currentEnd=this.currentStart+this.currentPageCount-1;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPageCount() {
		this.pageCount = this.totalCount % this.pageSize == 0 ? this.totalCount
				/ this.pageSize : this.totalCount / this.pageSize + 1;

		return pageCount;
	}

	public int getCurrentPage() {

		return currentPage;
	}

	public int getCurrentPageCount() {
		return currentPageCount;
	}

	public int getCurrentStart() {
		return currentStart;
	}

	public int getCurrentEnd() {
		return currentEnd;
	}

}
