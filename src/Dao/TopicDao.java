package Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Topic;

public class TopicDao extends BaseDao {

	public List<Topic> showAll() {
		List<Topic> list = new ArrayList<Topic>();
		String sql = "SELECT * FROM `topic` ";
		try {
			rs = super.selectDate(sql);
			while (rs.next()) {
				int tid = rs.getInt("tid");
				String tname = rs.getString("tname");
				Topic top = new Topic(tid, tname);
				list.add(top);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, prap, conn);
		}
		return list;
	}
	
	public int addTopic(String tname) {
		int temp = 0;
		String sql = "INSERT INTO `topic`(tname) VALUES (?)";
		temp = super.upDate(sql, tname);
		return temp;
	}
	
	public int deletTopic(int tid) {
		int temp = 0;
		String sql = "DELETE FROM `topic` WHERE tid = ?";
		temp = super.upDate(sql, tid);
		return temp;
	}

	public int changeTopic(int tid, String tname) {
		int temp = 0;
		String sql = "UPDATE `topic` SET tname = ? WHERE tid = ?";
		temp = super.upDate(sql, tname,tid);
		return temp;
	}

	public Topic findById(int ntid) {
		Topic top = null;
		String sql = "SELECT * FROM `topic` WHERE tid = ?";
		try {
			rs = super.selectDate(sql,ntid);
			while (rs.next()) {
				int tid = rs.getInt("tid");
				String tname = rs.getString("tname");
				top = new Topic(tid, tname);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, prap, conn);
		}
		return top;
	}

	public Topic findByName(String tname) {
		Topic top = null;
		String sql = "SELECT * FROM `topic` WHERE tname = ?";
		try {
			rs = super.selectDate(sql,tname);
			while (rs.next()) {
				int tid = rs.getInt("tid");
				top = new Topic(tid, tname);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, prap, conn);
		}
		return top;
	}
}
