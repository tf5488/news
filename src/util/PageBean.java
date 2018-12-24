package util;

import java.util.List;

/**
 * ������
 * 
 * @author TAn
 * 
 * @param <T>
 */
public class PageBean<T> {
	private int pageSize = 8; // ÿҳ����
	private int totalCount; // �ܵ�����
	private int totalPages; // �ܵ�ҳ�� ֻ����������
	private int pageNo = 1; // ��ǰҳ��
	private List<T> pageList; // ��ǰҳ�����ݼ���

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
				: (totalCount / pageSize + 1); // �ж��ǲ�����ҳ
	}

	public int getTotalPages() {
		return totalPages;
	}
	
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		// ��ǰҳ������ ����С��1 ���ܴ�������ҳ��
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
