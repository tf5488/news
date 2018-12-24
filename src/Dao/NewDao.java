package Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.News;

public class NewDao extends BaseDao {

	// 获取每页的新闻列表
	public List<News> findByPage(int first, int pageNo) {
		List<News> list = new ArrayList<News>();
		String sql = "SELECT * FROM news LIMIT ?,?";
		try {
			rs = super.selectDate(sql, (first - 1) * pageNo, pageNo);
			while (rs.next()) {
				int nid = rs.getInt("nid");
				int ntid = rs.getInt("ntid");
				String ntitle = rs.getString("ntitle");
				String nauthor = rs.getString("nauthor");
				Date ncreateDate = rs.getDate("ncreateDate");
				String nsummary = rs.getString("nsummary");
				News news = new News(nid, ntid, ntitle, nauthor, ncreateDate,
						nsummary);
				list.add(news);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, prap, conn);
		}
		return list;
	}

	// 获取总的条数
	public int totalNews() {
		int temp = 0;
		String sql = "SELECT COUNT(nid) FROM news";
		try {
			rs = super.selectDate(sql);
			while (rs.next()) {
				temp = rs.getInt(1);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, prap, conn);
		}
		return temp;
	}

	public int addNew(int ntid, String ntitle, String nauthor,
			Date ncreatedate, String nsummary) {
		String sql = "INSERT INTO news (ntid,ntitle,nauthor,ncreateDate,nsummary)VALUES(?,?,?,?,?)";
		java.sql.Date date = new java.sql.Date(ncreatedate.getTime()); // util.date>>sql.date
		int temp = super.upDate(sql, ntid, ntitle, nauthor, date, nsummary);
		return temp;
	}

	public List<News> showAll() {
		List<News> list = new ArrayList<News>();
		String sql = "SELECT * FROM news";
		try {
			rs = super.selectDate(sql);
			while (rs.next()) {
				int nid = rs.getInt("nid");
				int ntid = rs.getInt("ntid");
				String ntitle = rs.getString("ntitle");
				String nauthor = rs.getString("nauthor");
				Date ncreateDate = rs.getDate("ncreateDate");
				String nsummary = rs.getString("nsummary");
				News news = new News(nid, ntid, ntitle, nauthor, ncreateDate,
						nsummary);
				list.add(news);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, prap, conn);
		}
		return list;
	}

	public int deletNew(int nid) {
		String sql = "DELETE FROM `news` WHERE nid = ?";
		int temp = super.upDate(sql, nid);
		return temp;
	}

	public News findById(int nid) {
		News news = null;
		String sql = "SELECT * FROM news WHERE nid = ?";
		try {
			rs = super.selectDate(sql, nid);
			while (rs.next()) {
				int ntid = rs.getInt("ntid");
				String ntitle = rs.getString("ntitle");
				String nauthor = rs.getString("nauthor");
				Date ncreateDate = rs.getDate("ncreateDate");
				String nsummary = rs.getString("nsummary");
				news = new News(nid, ntid, ntitle, nauthor, ncreateDate,
						nsummary);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, prap, conn);
		}

		return news;
	}

	public int changeNew(int nid, int ntid, String ntitle, String nauthor,
			Date ncreatedate, String nsummary) {
		java.sql.Date date = new java.sql.Date(ncreatedate.getTime());
		String sql = "UPDATE news SET ntid =?,ntitle=?,nauthor=?,ncreateDate = ?,nsummary = ? WHERE nid = ? ";
		int temp = super
				.upDate(sql, ntid, ntitle, nauthor, date, nsummary, nid);
		return temp;
	}

	public List<News> findByTopic(int i) {
		List<News> list = new ArrayList<>();
		String sql = "SELECT * FROM news WHERE ntid= ? ";
		try {
			rs = super.selectDate(sql,i);
			while (rs.next()) {
				int nid = rs.getInt("nid");
				int ntid = rs.getInt("ntid");
				String ntitle = rs.getString("ntitle");
				String nauthor = rs.getString("nauthor");
				Date ncreateDate = rs.getDate("ncreateDate");
				String nsummary = rs.getString("nsummary");
				News news = new News(nid, ntid, ntitle, nauthor, ncreateDate,
						nsummary);
				list.add(news);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, prap, conn);
		}
		return list;
	}

}
