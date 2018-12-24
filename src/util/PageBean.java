package util;

import java.util.List;

/**
 * 泛型类
 * 
 * @author TAn
 * 
 * @param <T>
 */
public class PageBean<T> {
	private int pageSize = 8; // 每页分量
	private int totalCount; // 总的条数
	private int totalPages; // 总的页数 只读类型数据
	private int pageNo = 1; // 当前页码
	private List<T> pageList; // 当前页的内容集合

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.totalPages = totalCount % pageSize == 0 ? (totalCount / pageSize)
				: (totalCount / pageSize + 1); // 判断是不是整页
	}

	public int getTotalPages() {
		return totalPages;
	}
	
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		// 当前页的设置 不能小于1 不能大于最大的页数
		if (pageNo < 1) {
			this.pageNo = 1;
		} else if (pageNo > totalPages && totalPages != 0) {
			this.pageNo = totalPages;
		} else {
			this.pageNo = pageNo;
		}
	}

	public List<T> getPageList() {
		return pageList;
	}

	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}

}
