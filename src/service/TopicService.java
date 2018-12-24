package service;

import java.util.List;

import Dao.TopicDao;

import entity.Topic;

public class TopicService {
	TopicDao topdao = new TopicDao();

	public List<Topic> showAll() {
		List<Topic> list = topdao.showAll();
		return list;
	}

	public Topic findById(int ntid) {
		Topic top = topdao.findById(ntid);
		return top;
	}

	public Topic findByName(String tname) {
		Topic top = topdao.findByName(tname);
		return top;
	}

	public String addTopic(String tname) {
		String msg = null;
		int temp = topdao.addTopic(tname);
		if (temp > 0) {
			msg = "修改成功！";
		} else {
			msg = "修改失败!";
		}
		return msg;
	}

	public String deletTopic(int tid) {
		String msg = null;
		int temp = topdao.deletTopic(tid);
		if (temp > 0) {
			msg = "修改成功！";
		} else {
			msg = "修改失败!";
		}
		return msg;
	}

	public String changeTopic(int tid, String tname) {
		String msg = null;
		int temp = topdao.changeTopic(tid, tname);
		if (temp > 0) {
			msg = "修改成功！";
		} else {
			msg = "修改失败!";
		}
		return msg;
	}
}
