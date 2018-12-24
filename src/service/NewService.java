package service;

import java.util.Date;
import java.util.List;

import util.PageBean;

import entity.News;
import Dao.NewDao;

public class NewService {
	NewDao newdao = new NewDao();
	
	public PageBean<News> newsPage(int first,int pageNo){
		PageBean<News> pagebean =new PageBean<>();
		// �������ܵ�ҳ��
		int totalNews = newdao.totalNews();
		pagebean.setTotalCount(totalNews);
		
		// ����ÿҳ����
		pagebean.setPageSize(pageNo);
		
		// ������ҳ
		pagebean.setPageNo(first);
		
		// ���������б�
		pagebean.setPageList(newdao.findByPage(pagebean.getPageNo(), pagebean.getPageSize()));
		return pagebean;
	}
	

	public List<News> showAll() {
		List<News> list = newdao.showAll();
		return list;
	}

	public News findById(int nid) {
		News news = newdao.findById(nid);
		return news;
	}

	public String addNew(int ntid, String ntitle, String nauthor,
			Date ncreatedate, String nsummary) {
		String msg = null;
		int temp = newdao.addNew(ntid, ntitle, nauthor, ncreatedate, nsummary);
		if (temp > 0) {
			msg = "�޸ĳɹ���";
		} else {
			msg = "�޸�ʧ��!";
		}
		return msg;
	}

	public String changeNew(int nid, int ntid, String ntitle, String nauthor,
			Date ncreatedate, String nsummary) {
		String msg = null;
		int temp = newdao.changeNew(nid, ntid, ntitle, nauthor, ncreatedate,
				nsummary);
		if (temp > 0) {
			msg = "�޸ĳɹ���";
		} else {
			msg = "�޸�ʧ��!";
		}
		return msg;
	}

	public String deletNew(int nid) {
		String msg = null;
		int temp = newdao.deletNew(nid);
		if (temp > 0) {
			msg = "�޸ĳɹ���";
		} else {
			msg = "�޸�ʧ��!";
		}
		return msg;
	}


	public List<News> findByTopic(int i) {
		return newdao.findByTopic(i);
	}
}
